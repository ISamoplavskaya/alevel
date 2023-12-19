package ua.samoplavskaya.hw_comparator;

import ua.samoplavskaya.hw9.Circle;
import ua.samoplavskaya.hw9.Figure;
import ua.samoplavskaya.hw9.Square;
import ua.samoplavskaya.hw9.Triangle;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Comparator<Figure> figureAreaComparator= (o1, o2) -> (int) (o1.area()-o2.area());
        Comparator<Figure> figurePerimeterComparator= (o1,o2) -> (int) (o1.perimeter()-o2.perimeter());
        figureAreaComparator.thenComparing(figurePerimeterComparator);

        List<Figure> figures=new ArrayList<>();
        Figure circle = new Circle("Circle", 2);
        Figure square = new Square("Square", 4);
        Triangle triangle = new Triangle("Triangle");
        triangle.setSideA(3);
        triangle.setSideB(3);
        triangle.setSideC(3);

        figures.add(circle);
        figures.add(square);
        figures.add(triangle);
        figures.sort(figureAreaComparator);
        System.out.println(figures);

    }
}
