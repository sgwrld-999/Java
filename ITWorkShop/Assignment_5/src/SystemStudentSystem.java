import java.util.ArrayList;
import java.util.Scanner;

public class SystemStudentSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<ManagementSystem> students = new ArrayList<>();

        while (true) {
            System.out.println("\nMenu Options:");
            System.out.println("1. Add Information of a Student");
            System.out.println("2. Get Student Details");
            System.out.println("3. Update Student GPA");
            System.out.println("4. Display Total Number of Students Enrolled");
            System.out.println("5. Compare Students' GPA");
            System.out.println("6. Update Student Details");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    students.add(createStudent(scanner));
                    System.out.println("Student information added successfully.");
                    break;
                case 2:
                    int studentId = getStudentId(scanner, students);
                    if (studentId != -1) {
                        displayStudentDetails(students.get(studentId));
                    }
                    break;
                case 3:
                    studentId = getStudentId(scanner, students);
                    if (studentId != -1) {
                        float newGPA = getNewGPA(scanner);
                        ManagementSystem.updateGPA(studentId, newGPA);
                    }
                    break;
                case 4:
                    System.out.println("Total students enrolled: " + students.size());
                    break;
                case 5:
                    int stdTempID1 , stdTempID2 ;
                    System.out.print("Enter the Std 1 ID :");
                    stdTempID1 = scanner.nextInt();
                    System.out.print("Enter the Std 2 ID :");stdTempID2 = scanner.nextInt();
                    if (students.size() >= 2) {
                        ManagementSystem.compareStudentGPA(students.get(stdTempID1 - 1), students.get(stdTempID2 - 1));
                    } else {
                        System.out.println("There are not enough students to compare.");
                    }
                    break;
                case 6:
                    int stdTempId ;
                    float stdTempGPA ;
                    System.out.print("Enter student ID :");stdTempId = scanner.nextInt();
                    System.out.print("Enter student new GPA :");stdTempGPA = scanner.nextFloat();
                    ManagementSystem.updateGPA(stdTempId , stdTempGPA);
                    break;
                case 7:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static ManagementSystem createStudent(Scanner scanner) {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Student Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Student Major: ");
        String major = scanner.nextLine();

        System.out.print("Enter Student GPA: ");
        float GPA = scanner.nextFloat();

        return new ManagementSystem(id, name, age, major, GPA);
    }

    private static int getStudentId(Scanner scanner, ArrayList<ManagementSystem> students) {
        System.out.print("Enter Student ID: ");
        int studentId = scanner.nextInt();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == studentId) {
                return i;
            }
        }
        System.out.println("Student with ID " + studentId + " not found.");
        return -1;
    }

    private static float getNewGPA(Scanner scanner) {
        System.out.print("Enter New GPA: ");
        return scanner.nextFloat();
    }

    private static void displayStudentDetails(ManagementSystem student) {
        System.out.println("Student ID: " + student.getId());
        System.out.println("Student Name: " + student.getName());
        System.out.println("Student Age: " + student.getAge());
        System.out.println("Student Major: " + student.getMajor());
        System.out.println("Student GPA: " + student.getGPA());
    }
}

class ManagementSystem {
    private int id;
    private String name;
    private int age;
    private String major;
    private float GPA;
    static private int totalStudentsEnrolled;
    static private ArrayList<ManagementSystem> students = new ArrayList<>(); // Added ArrayList to store students

    ManagementSystem() {
    }

    ManagementSystem(int id, String name, int age, String major, float gpa) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.major = major;
        GPA = gpa;
        students.add(this); // Add the student to the list
        totalStudentsEnrolled++;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGPA(float GPA) {
        this.GPA = GPA;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getGPA() {
        return GPA;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public String getMajor() {
        return major;
    }

    public String getName() {
        return name;
    }

    public static int getTotalStudentsEnrolled() {
        return totalStudentsEnrolled;
    }

    public static void updateGPA(int studentId, float newGPA) {
        for (ManagementSystem student : students) {
            if (student.getId() == studentId) {
                student.setGPA(newGPA);
                System.out.println("GPA updated successfully.");
                return;
            }
        }
        System.out.println("Student with ID " + studentId + " not found.");
    }

    public static void compareStudentGPA(ManagementSystem student1, ManagementSystem student2) {
        float std1GPA = student1.getGPA();
        float std2GPA = student2.getGPA();

        if (std1GPA > std2GPA) {
            System.out.println("Name : " + student1.getName());
            System.out.println("Age : " + student1.getAge());
            System.out.println("GPA : " + student1.getGPA());
            System.out.println("Major : " + student1.getMajor());
            System.out.println("ID :" + student1.getId());
        } else if (std1GPA < std2GPA) {
            System.out.println("Name : " + student2.getName());
            System.out.println("Age : " + student2.getAge());
            System.out.println("GPA : " + student2.getGPA());
            System.out.println("Major : " + student2.getMajor());
            System.out.println("ID :" + student2.getId());
        } else {
            System.out.println("Both have the same GPA i.e " + std2GPA);
        }
    }
}
