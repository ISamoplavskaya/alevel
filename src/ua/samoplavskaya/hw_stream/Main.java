package ua.samoplavskaya.hw_stream;

import ua.samoplavskaya.hw9.Circle;
import ua.samoplavskaya.hw9.Figure;
import ua.samoplavskaya.hw9.Square;
import ua.samoplavskaya.hw9.Triangle;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//1.За допомогою Stream API знайти фігуру, площа якої більша за мінімальну на заданий параметр
//private Figure findFigure(double difference)
//2. За допомогою Stream API знайти фігуру у якої площа у два рази більша за периметер

public class Main {
    public static void main(String[] args) {
        List<Figure> figures = new ArrayList<>(List.of(
                new Circle("Circle1", 2),
                new Circle("Circle2", 5),
                new Square("Square1", 4),
                new Square("Square2", 8)
        ));

        Triangle triangle1 = new Triangle("Triangle1");
        triangle1.setSideA(3);
        triangle1.setSideB(3);
        triangle1.setSideC(3);
        figures.add(triangle1);

        System.out.println(figures);

        double difference = 10.0;
        List<Figure> result1 = findFigure1(figures, difference);

        if (!result1.isEmpty()) {
            System.out.println("Figure whose area is greater than the minimum at " + difference + ": ");
            for (Figure figure : result1) System.out.print(figure.getNameFigure() + ", ");
        } else {
            System.out.println("No figures found whose area is greater than the minimum at " + difference + ": ");
        }

        List<Figure> result2 = findFigure2(figures);

        if (!result2.isEmpty()) {
            System.out.println("\nFigures whose area is twice the perimeter ");
            for (Figure f : result2) System.out.print(f.getNameFigure() + ", ");
        } else {
            System.out.println("No figures found whose area is twice the perimeter");
        }
    }


    public static List<Figure> findFigure1(List<Figure> figures, double difference) {
        return figures.stream()
                .filter(figure -> figure.area() > findMinArea(figures) + difference)
                .collect(Collectors.toList());
    }

    private static double findMinArea(List<Figure> figures) {
        return figures.stream()
                .mapToDouble(Figure::area)
                .min()
                .orElse(0.0);
    }

    public static List<Figure> findFigure2(List<Figure> figures) {
        return figures.stream()
                .filter(figure -> figure.area() == 2 * figure.perimeter())
                .collect(Collectors.toList());
    }
}
