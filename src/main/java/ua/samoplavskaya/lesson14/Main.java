package ua.samoplavskaya.lesson14;

import ua.samoplavskaya.lesson11.Circle;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Comparator<Animal> animalComporator = new AnimalHouseOfSleepingComparator();
        Set<Animal> animals = new TreeSet<>(animalComporator);

        Animal animal = new Animal("meat", 5);
        Animal animal1 = new Animal("fish", 6);

        animals.add(animal);
        animals.add(animal1);
        System.out.println(animals);

        Circle circle1=new Circle(2);
        Circle circle2=new Circle(3);

        Set<Circle> circles=new TreeSet<>();
        circles.add(circle1);
        circles.add(circle2);
        System.out.println(circles);

        Comparator<Animal> kindOfFoodComparator=new AnimalKindOfFoodComparator();
        Comparator<Animal> houseOfSleepingComparator=new AnimalHouseOfSleepingComparator();
        houseOfSleepingComparator.thenComparing(kindOfFoodComparator);

        Set<Animal> animals1=new TreeSet<>(houseOfSleepingComparator);
        Animal animal2 = new Animal("meat", 8);
        Animal animal3 = new Animal("fish", 8);
        animals1.add(animal2);
        animals1.add(animal3);
        System.out.println(animals1);
    }

    public static <T> List<T> removeDublicates(List<T> list) {
        Set<T> set = new HashSet<>(list);
        return new ArrayList<>(set);
    }
}
