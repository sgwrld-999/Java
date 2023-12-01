import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee implements Serializable {
    String employeeName;
    int employeeAge;
    int employeeSalary;
    int employeeID;
    String workDepartment;
    static int totalNumberOfEmployees = 0;

    Employee() {} // Default constructor

    public Employee(String employeeName, int employeeAge, int employeeSalary, int employeeID, String workDepartment) {
        this.employeeName = employeeName;
        this.employeeAge = employeeAge;
        this.employeeSalary = employeeSalary;
        this.employeeID = employeeID;
        this.workDepartment = workDepartment;
        totalNumberOfEmployees++;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(int employeeAge) {
        this.employeeAge = employeeAge;
    }

    public int getEmployeeSalary() {
        return employeeSalary;
    }

    public static int getTotalNumberOfEmployees() {
        return totalNumberOfEmployees;
    }

    public static void setTotalNumberOfEmployees(int totalNumberOfEmployees) {
        Employee.totalNumberOfEmployees = totalNumberOfEmployees;
    }

    public void setEmployeeSalary(int employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getWorkDepartment() {
        return workDepartment;
    }

    public void setWorkDepartment(String workDepartment) {
        this.workDepartment = workDepartment;
    }
}

class TempEmployee extends Employee {
    int durationOfContract;

    TempEmployee(String employeeName, int employeeAge, int employeeSalary, int employeeID, String workDepartment,
                 int durationOfContract) {
        super(employeeName, employeeAge, employeeSalary, employeeID, workDepartment);
        this.durationOfContract = durationOfContract;
    }

    public int getDurationOfContract() {
        return durationOfContract;
    }

    public void setDurationOfContract(int durationOfContract) {
        this.durationOfContract = durationOfContract;
    }


}

class PermanentEmployee extends Employee {
    String workingYear;

    PermanentEmployee(String employeeName, int employeeAge, int employeeSalary, int employeeID, String workDepartment,
                      String workingYear) {
        super(employeeName, employeeAge, employeeSalary, employeeID, workDepartment);
        this.workingYear = workingYear;
    }

    public String getWorkingYear() {
        return workingYear;
    }

    public void setWorkingYear(String workingYear) {
        this.workingYear = workingYear;
    }
}

class Server {
    private List<Employee> employees;

    public Server() {

        employees = new ArrayList<>();

        employees.add(new PermanentEmployee("Robert Downey Jr", 46, 600000, 12, "CEO", "2000"));
        employees.add(new PermanentEmployee("Steve Rogers", 150, 69000, 34, "Marketing", "2010"));
        employees.add(new PermanentEmployee("Dani Daniels", 23, 7000, 45, "BJDepartment", "2015"));
        employees.add(new PermanentEmployee("Alice", 35, 70000, 3, "Finance", "2020"));
        employees.add(new TempEmployee("Bob The Builder", 28, 40000, 4, "Construction", 6));
        employees.add(new TempEmployee("Loki Chandu", 1999, 12414587, 1202, "Mischief", 5));
        employees.add(new TempEmployee("Nageshwar", 57, 12435587, 54234, "Sadist", 1));
        employees.add(new PermanentEmployee("Sunny Deol", 43, 7000000, 400, "OooiiiDeparatment", "2456"));
        employees.add(new PermanentEmployee("Rajnikanth", 70, 70000000, 300, "Acting", "1980"));
        employees.add(new PermanentEmployee("Rajnikanth", 720, 700000, 320, "Acting", "1980"));

    }

    // Method to start the server
    public void startServer(int port) {

        try (ServerSocket serverSocket = new ServerSocket(port)) {

            System.out.println("Server is listening on port " + port);

            while (true) {

                Socket clientSocket = serverSocket.accept();

                System.out.println("Client connected: " + clientSocket.getInetAddress());

                new Thread(() -> handleClient(clientSocket)).start();

            }
        } catch (IOException e) {

            e.printStackTrace();

        }
    }

    private void handleClient(Socket clientSocket) {
        try (ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());

             ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream())) {

            int requestType = ois.readInt();

            switch (requestType) {

                case 1:

                    System.out.println("The total Number of employees are : ");
                    oos.writeInt(employees.size());
                    break;

                case 2:

                    int requestedEmployeeID = ois.readInt();
                    Employee employee = findEmployeeByID(requestedEmployeeID);
                    if (employee != null) {
                        oos.writeObject(employee);
                    } else {
                        oos.writeObject(null);
                    }
                    break;

                case 3:

                    int employeeID1 = ois.readInt();
                    int employeeID2 = ois.readInt();
                    int salary1 = findSalaryByID(employeeID1);
                    int salary2 = findSalaryByID(employeeID2);
                    if (salary1 > salary2) {
                        oos.writeObject("EmployeeID: " + employeeID1 + " has a higher salary.");
                    } else if (salary2 > salary1) {
                        oos.writeObject("EmployeeID: " + employeeID2 + " has a higher salary.");
                    } else {
                        oos.writeObject("Both employees have the same salary.");
                    }
                    break;

                case 4:

                    String districtName = ois.readUTF();
                    List<Employee> employeesInDistrict = findEmployeesByDistrict(districtName);
                    oos.writeObject(employeesInDistrict);
                    break;

                default:

                    System.out.println("Invalid request type");

            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {
                clientSocket.close();

            } catch (IOException e) {

                e.printStackTrace();

            }
        }
    }

    private Employee findEmployeeByID(int employeeID) {

        for (Employee employee : employees) {

            if (employee.getEmployeeID() == employeeID) {
                return employee;
            }

        }

        return null;
    }

    private int findSalaryByID(int employeeID) {

        for (Employee employee : employees) {

            if (employee.getEmployeeID() == employeeID) {

                return employee.getEmployeeSalary();

            }
        }

        return 0;
    }

    private List<Employee> findEmployeesByDistrict(String districtName) {

        List<Employee> employeesInDistrict = new ArrayList<>();

        for (Employee employee : employees) {

            if (employee instanceof PermanentEmployee) {

                PermanentEmployee permanentEmployee = (PermanentEmployee) employee;

                if (permanentEmployee.getWorkDepartment().equalsIgnoreCase(districtName)) {

                    employeesInDistrict.add(employee);

                }
            }
        }

        return employeesInDistrict;
    }
}

class Client {
    Client() {} // Default Constructor

    public static void clientCallingMethod(Scanner scanner) {

        System.out.println("Welcome to the SGWRLD Client: ");
        System.out.println("Enter the host: ");

        String host = scanner.nextLine();
        System.out.println("Enter the port number: ");

        int hostId = scanner.nextInt();
        scanner.nextLine();

        try (Socket socket = new Socket(host, hostId);

             ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

             ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())) {

            System.out.println("Enter the employee ID :");
            int empId = scanner.nextInt();
            oos.writeInt(empId);

            Employee employee = (Employee) ois.readObject();

            if (employee != null) {
                System.out.println("Employee details: " + employee.getEmployeeName());
            } else {
                System.out.println("Employee not found.");
            }

            System.out.println("Enter the employee ID :");
            empId = scanner.nextInt();
            oos.writeInt(empId);

            String result = (String) ois.readObject();
            System.out.println(result);

            System.out.println("Enter the employee ID :");
            empId = scanner.nextInt();
            scanner.nextLine();
            oos.writeInt(empId);

            System.out.println("Enter the district : ");
            String District_Name = scanner.nextLine();
            oos.writeUTF(District_Name);

            List<Employee> employeesInDistrict = (List<Employee>) ois.readObject();
            System.out.println("Employees in Finance department: " + employeesInDistrict);


        } catch (IOException | ClassNotFoundException e) {

            e.printStackTrace();

        }
    }
}

public class Siddhant_Gond_2201191 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("⭐️Welcome to the SGWRLD SERVERS⭐️");

        System.out.println("Starting the Server : ");

        Server server = new Server();
        server.startServer(12345);

        System.out.println("Entering the SGWRLD Client: ");
        Client client = new Client();


        client.clientCallingMethod(scanner);
    }
}
