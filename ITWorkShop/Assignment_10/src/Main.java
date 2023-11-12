import java.util.Scanner;

// Custom exception classes
class InvalidEmailException extends Exception {
    InvalidEmailException(String msg) {
        super(msg);
    }
}

class InvalidPinCodeException extends Exception {
    InvalidPinCodeException(String msg) {
        super(msg);
    }
}

class InvalidRollNoException extends Exception {
    InvalidRollNoException(String msg) {
        super(msg);
    }
}

class InvalidEmpIdException extends Exception {
    InvalidEmpIdException(String msg) {
        super(msg);
    }
}

// Person class
class Person {
    String firstName;
    String lastName;
    String pan;
    int pinCode;

    Person(String fName, String lName, String pan, int pinCode) {
        this.firstName = fName;
        this.lastName = lName;
        this.pan = pan;
        this.pinCode = pinCode;
    }
}

// Student class
class Student extends Person {
    String emailId;
    String rollNo;

    Student(String fName, String lName, String pan, int pinCode, String email, String rollNo) {
        super(fName, lName, pan, pinCode);
        this.emailId = email;
        this.rollNo = rollNo;
    }

    void validate() throws InvalidEmailException, InvalidRollNoException {
        // Email validation
        if(!emailId.contains("@")) {
            throw new InvalidEmailException("Invalid email");
        }

        // Roll no validation
        if(!rollNo.startsWith("stud")) {
            throw new InvalidRollNoException("Invalid roll no");
        }
    }
}

// Employee class
class Employee extends Person {
    String emailId;
    String empId;

    Employee(String fName, String lName, String pan, int pinCode, String email, String empId) {
        super(fName, lName, pan, pinCode);
        this.emailId = email;
        this.empId = empId;
    }

    void validate() throws InvalidEmailException, InvalidEmpIdException {
        // Email validation
        if(!emailId.contains("@")) {
            throw new InvalidEmailException("Invalid email");
        }

        // Emp ID validation
        if(!empId.startsWith("emp")) {
            throw new InvalidEmpIdException("Invalid emp ID");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for Student
        System.out.println("Enter student details:");
        System.out.print("First Name: ");
        String studentFirstName = scanner.nextLine();
        System.out.print("Last Name: ");
        String studentLastName = scanner.nextLine();
        System.out.print("PAN: ");
        String studentPan = scanner.nextLine();
        System.out.print("Pin Code: ");
        int studentPinCode = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Email: ");
        String studentEmail = scanner.nextLine();
        System.out.print("Roll Number: ");
        String studentRollNo = scanner.nextLine();

        // Input for Employee
        System.out.println("Enter employee details:");
        System.out.print("First Name: ");
        String employeeFirstName = scanner.nextLine();
        System.out.print("Last Name: ");
        String employeeLastName = scanner.nextLine();
        System.out.print("PAN: ");
        String employeePan = scanner.nextLine();
        System.out.print("Pin Code: ");
        int employeePinCode = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Email: ");
        String employeeEmail = scanner.nextLine();
        System.out.print("Employee ID: ");
        String employeeEmpId = scanner.nextLine();

        // Create Student and Employee objects with user input
        Student student = new Student(studentFirstName, studentLastName, studentPan, studentPinCode, studentEmail, studentRollNo);
        Employee employee = new Employee(employeeFirstName, employeeLastName, employeePan, employeePinCode, employeeEmail, employeeEmpId);

        try {
            student.validate();
            System.out.println("Student details are valid.");
        } catch (InvalidEmailException e) {
            System.out.println("Student: " + e.getMessage());
        } catch (InvalidRollNoException e) {
            System.out.println("Student: " + e.getMessage());
        }

        try {
            employee.validate();
            System.out.println("Employee details are valid.");
        } catch (InvalidEmailException | InvalidEmpIdException e) {
            System.out.println("Employee: " + e.getMessage());
        }

        // Array index out of bounds
        int[] arr = {1, 2, 3};
        try {
            System.out.println(arr[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index out of bounds!");
        }

        // Null pointer exception
        String str = null;
        try {
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("Cannot invoke method on null object");
        }
    }
}