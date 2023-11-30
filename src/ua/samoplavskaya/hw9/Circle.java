package ua.samoplavskaya.hw9;

public class Circle extends Figure {

    private final double radius;

    public Circle(String nameFigure, double radius) {
        super(nameFigure);
        this.radius = radius;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(getNameFigure());
        sb.append('{');
        sb.append("area=").append(area());
        sb.append(", perimeter=").append(perimeter());
        sb.append('}');
        return sb.toString();
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
