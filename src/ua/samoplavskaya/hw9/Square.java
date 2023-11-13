package ua.samoplavskaya.hw9;

public class Square extends Figure {
    private final double side;

    public Square(String nameFigure, double side) {
        super(nameFigure);
        this.side = side;
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
