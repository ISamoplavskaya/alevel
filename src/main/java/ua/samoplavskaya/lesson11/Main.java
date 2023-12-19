package ua.samoplavskaya.lesson11;

import java.util.EmptyStackException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double radius = inputRadius();
        Circle circle = new Circle(radius);
        System.out.println(circle.getArea());
    }

    private static double inputRadius() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter radius: ");
        double radius = scanner.nextDouble();
        try {
            if (radius < 0) {
                throw new ExceptionRadius("Radius must be positive");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return radius;
    }
}
