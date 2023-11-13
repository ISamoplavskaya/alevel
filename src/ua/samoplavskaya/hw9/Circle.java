package ua.samoplavskaya.hw9;

public class Circle extends Figure {

    private final double radius;

    public Circle(String nameFigure, double radius) {
        super(nameFigure);
        this.radius = radius;
    }

    @Override
    public double perimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}
