package ua.samoplavskaya.hw9;

public class Square extends Figure {
    private final double side;

    public Square(String nameFigure, double side) {
        super(nameFigure);
        this.side = side;
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
        return 4 * side;
    }

    @Override
    public double area() {
        return side * side;
    }
}
