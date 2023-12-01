package ObjectSorting;

import java.util.ArrayList;
import java.util.Collections;

public class sortingObjectsClass implements Comparable<sortingObjectsClass> {
    // Five employees with different attributes
    int age;
    String name;
    int Id;
    int salary;
    String department;

    public sortingObjectsClass(int age, String name, int Id, int salary, String department) {
        this.age = age;
        this.name = name;
        this.Id = Id;
        this.salary = salary;
        this.department = department;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public int compareTo(sortingObjectsClass o) {
        return Integer.compare(this.age, o.age);
    }

//    public static void main(String[] args) {
//        ArrayList<sortingObjectsClass> employees = new ArrayList<>(5);
//        // Attributes of the employees -> age, name, Id, salary, department
//        employees.add(new sortingObjectsClass(25, "John", 1, 1000, "IT"));
//        employees.add(new sortingObjectsClass(30, "Mary", 2, 2000, "HR"));
//        employees.add(new sortingObjectsClass(35, "Peter", 3, 3000, "Finance"));
//        employees.add(new sortingObjectsClass(40, "Paul", 4, 4000, "Marketing"));
//        employees.add(new sortingObjectsClass(45, "James", 5, 5000, "Sales"));
//
//        // Sorting by age using natural ordering
//        Collections.sort(employees);
//
//        // Printing the sorted list
//        for (sortingObjectsClass employee : employees) {
//            System.out.println(employee.getAge() + " " + employee.getName());
//        }
//    }
}
