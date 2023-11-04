package ua.samoplavskaya.hw9;

import java.util.Scanner;

public abstract class Figure {
    private  String nameFigure;
    private double side;

    public Figure(String nameFigure) {
        this.nameFigure = nameFigure;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public String getNameFigure() {
        return nameFigure;
    }

    public abstract double perimeter();

    public abstract double area();

    public void printFigure() {
        System.out.printf("Perimeter of a %s: %f, area: %f \n", nameFigure, perimeter(), area());
    }


}
