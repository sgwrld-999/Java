package Q1_Directory;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter length of the rectangle: ");
        double length = scanner.nextDouble();
        System.out.print("Enter breadth of the rectangle: ");
        double breadth = scanner.nextDouble();
        System.out.print("Enter side of the square: ");
        double side = scanner.nextDouble();
        System.out.print("Enter radius of the circle: ");
        double radius = scanner.nextDouble();
        AreaCalculator areaCalculator = new AreaCalculator();
        //Calculating the Rectangle area
        double rectangleArea = areaCalculator.calculateRectangleArea(length, breadth);
        //Calculating the Square area
        double squareArea = areaCalculator.calculateSquareArea(side);
        //Calculating the Circle area
        double circleArea = areaCalculator.calculateCircleArea(radius);
        System.out.println("Area of Rectangle: " + rectangleArea);
        System.out.println("Area of Square: " + squareArea);
        System.out.println("Area of Circle: " + circleArea);
    }

}