package ua.samoplavskaya.hw9;

public class Circle extends Figure {
    private String nameFigure;
    private double radius;

    public Circle(String nameFigure,double radius) {
        super(nameFigure);
        this.radius=radius;
    }

    @Override
    public void setSide(double radius) {
        super.setSide(radius);
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
