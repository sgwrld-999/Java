package Q2_Directory;

class Person {
    public int age;

    public Person(int age) {
        this.age = age;
    }

    void eat() {
        System.out.println("Person is eating.");
    }

    void sleep() {
        System.out.println("Person is sleeping.");
    }

    public int driveBike(int age) {
        return 0;
    }
}

interface Driver {
    default int driveCar(int age);
    void driveBike();
}

interface Singer {
    int sing();
    void riyaz();
}

public class Employee extends Person implements Driver, Singer {
    public Employee(int age) {
        super(age);
    }

    public int driveCar(int age) {
        if (age < 40) {
            System.out.println("Employee is driving a car. Earns 10 points.");
            return 10;
        } else {
            System.out.println("Employee is not allowed to drive a car.");
            return 0;
        }
    }

    public void driveBike() {
        if (age < 40) {
            System.out.println("Employee is driving a bike. Earns 5 points.");
        } else {
            System.out.println("Employee is not allowed to drive a bike.");
        }
    }

    public int sing() {
        if (age < 20) {
            System.out.println("Employee is singing. Earns 15 points.");
            return 15;
        } else {
            System.out.println("Employee is not allowed to sing.");
            return 0;
        }
    }

    public void riyaz() {
        System.out.println("Employee is doing riyaz.");
    }

    public int officeWork(int age) {
        if (age < 40) {
            System.out.println("Employee is doing office work. Earns 20 points.");
            return 20;
        } else {
            System.out.println("Employee is doing office work. Earns 10 points.");
            return 10;
        }
    }
}
