package Q3_Directory;
import Q2_Directory.Employee;
import java.util.Scanner;

public class ExtensionOfQ2 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter age for Employee " + (i + 1) + ": ");
            int age = scanner.nextInt();
            employees[i] = new Employee(age);
        }
        int[] eifArray = new int[5];
        for (int i = 0; i < 5; i++) {
            eifArray[i] = employees[i].driveCar(employees[i].age) + employees[i].driveBike(employees[i].age) + employees[i].sing() + employees[i].officeWork(employees[i].age);
        }
        sort(employees, eifArray);
        System.out.println("\nSorted Employees by Employee Importance Factor (EIF):");
        for (Employee employee : employees) {
            System.out.println("Age: " + employee.age + ", EIF: " + eifArray[getIndex(employees, employee)]);
        }
        scanner.close();
    }

    public static void sort(Employee[] employees, int[] eifArray) {
        //Bubble Sort : TC : O(N^2)
        for (int i = 0; i < employees.length - 1; i++) {
            for (int j = 0; j < employees.length - i - 1; j++) {
                if (eifArray[j] > eifArray[j + 1]) {
                    Employee tempEmployee = employees[j];
                    employees[j] = employees[j + 1];
                    employees[j + 1] = tempEmployee;
                    int tempEIF = eifArray[j];
                    eifArray[j] = eifArray[j + 1];
                    eifArray[j + 1] = tempEIF;
                }
            }
        }
    }

    public static int getIndex(Employee[] employees, Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == employee) {
                return i;
            }
        }
        return -1;
    }
}
