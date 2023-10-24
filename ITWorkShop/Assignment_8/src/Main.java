import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Hello world!");
        ArrayList<Student> studentsList = new ArrayList<Student>(5);
        System.out.println("Enter the Name, Roll, BirthYear: ");
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter the Student " + (i + 1) + " details");
            System.out.print("Name : ");
            String studentName = scanner.nextLine();
            System.out.print("Roll : ");
            int studentRoll = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Birth Year : ");
            String studentBirthYear = scanner.nextLine();
            Student tempObj = new Student(studentName, studentRoll, studentBirthYear);
            studentsList.add(tempObj);
        }
        int i = 1;
        for (Student obj : studentsList) {
            System.out.println("Printing the details of student " + i + " : ");
            System.out.println("Student Name: " + obj.getName());
            System.out.println("Student Roll: " + obj.getRoll());
            System.out.println("Student Birth Year: " + obj.getBirthYear());
            i++;
        }

        // Sort and print by first name
        Collections.sort(studentsList, Student.FirstNameComparator);
        System.out.println("Sorted by First Name : ");
        printStudentList(studentsList);

        // Sort and print by title
        Collections.sort(studentsList, Student.TitleComparator);
        System.out.println("Sorted by Title : ");
        printStudentList(studentsList);

        // Sort and print in reverse order of roll number
        Collections.sort(studentsList, Student.ReverseRollComparator);
        System.out.println("Sorted in Reverse Order of Roll Number : ");
        printStudentList(studentsList);

        // Sort and print in ascending order of birth year
        Collections.sort(studentsList, Student.BirthYearComparator);
        System.out.println("Sorted in Ascending Order of Birth Year : ");
        printStudentList(studentsList);
    }

    public static void printStudentList(ArrayList<Student> studentList, String message) {
        System.out.println(message);
        int i = 1;
        for (Student obj : studentList) {
            System.out.println("Printing the details of student " + i + " : ");
            System.out.println("Student Name: " + obj.getName());
            System.out.println("Student Roll: " + obj.getRoll());
            System.out.println("Student Birth Year: " + obj.getBirthYear());
            i++;
        }
    }
    public static void sortingReverseOrderRoll(ArrayList<Student> arrayList) {
        Collections.sort(arrayList, new Comparator<Student>() {
            @Override
            public int compare(Student student1, Student student2) {
                return Integer.compare(student2.getRoll(), student1.getRoll());
            }
        });
    }

    public static void sortingByBirthYear(ArrayList<Student> arrayList) {
        Collections.sort(arrayList, new Comparator<Student>() {
            @Override
            public int compare(Student student1, Student student2) {
                int birthYear1 = Integer.parseInt(student1.getBirthYear());
                int birthYear2 = Integer.parseInt(student2.getBirthYear());
                return Integer.compare(birthYear1, birthYear2);
            }
        });
    }

    public static void printStudentList(ArrayList<Student> studentList) {
        int i = 1;
        for (Student obj : studentList) {
            System.out.println("Printing the details of student " + i + " : ");
            System.out.println("Student Name: " + obj.getName());
            System.out.println("Student Roll: " + obj.getRoll());
            System.out.println("Student Birth Year: " + obj.getBirthYear());
            i++;
        }
    }
}
