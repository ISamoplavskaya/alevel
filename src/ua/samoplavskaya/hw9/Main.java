package ua.samoplavskaya.hw9;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Input radius of circle: ");
        double radius = inputSize();
        Figure circle = new Circle("Circle", radius);
        circle.printFigure();

        System.out.println("Input side of Square: ");
        double side = inputSize();
        Figure square = new Square("Square", side);
        square.printFigure();

        Triangle triangle1 = new Triangle("Triangle1");
        createTriangleWithThreeSides(triangle1);
        triangle1.printFigure();

        Triangle triangle2 = new Triangle("Triangle2");
        createTriangleWithTwoSidesAndAngle(triangle2);
        triangle2.printFigure();

        Triangle triangle3 = new Triangle("Triangle3");
        createTriangleWithBaseHeight(triangle3);
        triangle3.printFigure();

        Figure maxAreaFigure = findMaxAreaFigure(circle, square, triangle1, triangle2, triangle3);
        System.out.println("The figure with the biggest area is a "+maxAreaFigure.getNameFigure()+". The area is equal "+maxAreaFigure.area());
    }

    public static double inputSize() {
        Scanner scanner = new Scanner(System.in);
        double numberDouble;
        while (true) {
            try {

                numberDouble = scanner.nextDouble();
                if (numberDouble < 0) {

                    throw new ExceptionNegativeSize("Number must be positive");

                } else break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Size:");
            }
        }
        return numberDouble;
    }

    public static int inputDegree() {
        Scanner scanner = new Scanner(System.in);
        int degree;
        while (true) {
            try {
                degree = scanner.nextInt();
                if (degree % 180 == 0) {
                    throw new ZeroAngleException("The angle in a triangle cannot be 0");
                } else if (degree < 0) {
                    throw new ExceptionNegativeSize("The angle in a triangle must be positive");
                } else break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Enter angle value  :");
            }
        }
        return degree;
    }

    private static void createTriangleWithThreeSides(Triangle triangle) {
        while (true) {
            System.out.println("Enter side A: ");
            triangle.setSideA(inputSize());
            System.out.println("Enter side B: ");
            triangle.setSideB(inputSize());
            System.out.println("Enter side C: ");
            triangle.setSideC(inputSize());
            try {
                double sideA = triangle.getSideA();
                double sideB = triangle.getSideB();
                double sideC = triangle.getSideC();
                if ((sideA + sideB < sideC) || (sideA + sideC < sideB) || (sideB + sideC < sideA)) {
                    throw new NonexistentTriangleException("This triangle doesn't exist");
                } else break;
            } catch (NonexistentTriangleException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void createTriangleWithTwoSidesAndAngle(Triangle triangle) {
        System.out.println("Enter side A: ");
        triangle.setSideA(inputSize());
        System.out.println("Enter side B: ");
        triangle.setSideB(inputSize());
        System.out.println("Enter triangle angle: ");
        triangle.setDegree(inputDegree());
    }

    private static void createTriangleWithBaseHeight(Triangle triangle) {
        System.out.println("Enter base: ");
        triangle.setSideA(inputSize());
        System.out.println("Enter height: ");
        triangle.setHeight(inputSize());
    }

    private static Figure findMaxAreaFigure(Figure... figures) {
        Figure maxFigure = null;
        double maxArea = 0.0;
        for (Figure figure : figures) {
            double area = figure.area();
            if (area > maxArea) {
                maxArea = area;
                maxFigure = figure;
            }
        }
        return maxFigure;
    }
}