import ObjectSorting.sortingObjectsClass;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<sortingObjectsClass> employees = new ArrayList<>(5);
        // Attributes of the employees -> age, name, Id, salary, department
        employees.add(new sortingObjectsClass(25, "John", 1, 1000, "IT"));
        employees.add(new sortingObjectsClass(30, "Mary", 2, 2000, "HR"));
        employees.add(new sortingObjectsClass(35, "Peter", 3, 3000, "Finance"));
        employees.add(new sortingObjectsClass(40, "Paul", 4, 4000, "Marketing"));
        employees.add(new sortingObjectsClass(45, "James", 5, 5000, "Sales"));

        // Sorting by age using natural ordering
        Collections.sort(employees);

        // Printing the sorted list
        for (sortingObjectsClass employee : employees) {
            System.out.println(employee.getAge() + " " + employee.getName());
        }
    }
}
