package Q2_Directory;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Enter the Age : ");
        int age = scanner.nextInt();
        Employee employee = new Employee(age);
        Driver driver = employee;
        driver.driveCar(age);
        driver.driveBike();
        Singer singer = employee;
        singer.sing();
        singer.riyaz();
        employee.officeWork(age);
    }
}