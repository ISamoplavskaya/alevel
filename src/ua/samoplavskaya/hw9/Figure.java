package ua.samoplavskaya.hw9;

public abstract class Figure {
    private final String nameFigure;

    public String getNameFigure() {
        return nameFigure;
    }

    public Figure(String nameFigure) {
        this.nameFigure = nameFigure;
    }

    public abstract double perimeter();

    public abstract double area();

    public void printFigure() {
        System.out.printf("Perimeter of a %s: %f, area: %f \n", nameFigure, perimeter(), area());
    }
}
