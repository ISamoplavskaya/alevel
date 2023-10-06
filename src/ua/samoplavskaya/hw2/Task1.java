package ua.samoplavskaya.hw2;

public class Task1 {
    public static void main(String[] args) {
        double x1 = 1;
        double y1 = 5;
        double x2 = 5;
        double y2 = 5;
        double x3 = 6;
        double y3 = 7;
        double area = areaOfTriangle(x1, y1, x2, y2, x3, y3);
        System.out.println("Area of triangle = " + area);
    }

    public static double areaOfTriangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        double area = Math.abs(0.5 * ((x1 - x3) * (y2 - y3) - (x2 - x3) * (y1 - y3)));
        return area;
    }
}
