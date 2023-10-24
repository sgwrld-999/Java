package Q1_Directory;

abstract class Shape {
    abstract double calculateRectangleArea(double length, double breadth);
    abstract double calculateSquareArea(double side);
    abstract double calculateCircleArea(double radius);
}

class AreaCalculator extends Shape {
    @Override
    double calculateRectangleArea(double length, double breadth) {
        return length * breadth;
    }

    @Override
    double calculateSquareArea(double side) {
        return side * side;
    }

    @Override
    double calculateCircleArea(double radius) {
        return Math.PI * radius * radius;
    }
}
