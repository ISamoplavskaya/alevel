package ua.samoplavskaya.lesson15;

import ua.samoplavskaya.lesson14.Animal;


import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        List<Integer> oddNumbers = nums.stream()
                .filter(number -> (number % 2) != 0)
                .collect(Collectors.toList());

        System.out.println(oddNumbers);

        List<String> list = new ArrayList<>(Arrays.asList("adfg", "amkllkk", "scsfg", "asdg", "sadg", "aaaaaaaaaaa", "adfg"));
        List<String> sortList = list.stream()
                .filter(s -> s.startsWith("a") && s.length() < 5)
                .collect(Collectors.toList());
        System.out.println(sortList);

        List<Integer> numbers = new ArrayList<>(Arrays.asList(2, 5, 6, 7, 8, 1, 5, 4));
        Optional<Integer> secondSmallest = numbers.stream()
                .distinct()
                .sorted()
                .skip(1)
                .findFirst();

        Optional<Integer> secondLargest = numbers.stream()
                .distinct()
                .sorted((a, b) -> b - a)
                .skip(1)
                .findFirst();


        System.out.println("second smallest: " + secondSmallest.get());
        System.out.println("second largest: " + secondLargest.get());

        Comparator<Animal> houseOfSleepingComparator = (o1, o2) -> (int) o1.getHoursOfSleeping() - o2.getHoursOfSleeping();
        Comparator<Animal> kindOfFoodComparator = (o1, o2) -> (int) o1.getKindOFood().compareTo(o2.getKindOFood());
        houseOfSleepingComparator.thenComparing(kindOfFoodComparator);

        Animal animal1 = new Animal("a", 1);
        Animal animal2 = new Animal("b", 6);
        Animal animal3 = new Animal("c", 6);
        Animal animal4 = new Animal("d", 4);
        Animal animal5 = new Animal("a", 1);
        Animal animal6 = new Animal("e", 8);
        List<Animal> animals = new ArrayList<>(Arrays.asList(animal1, animal2, animal3, animal4,animal5,animal6));
        Optional<Animal> secondSmallestAnimal = animals.stream()
                .distinct()
                .sorted(houseOfSleepingComparator)
                .skip(1)
                .findFirst();

        Optional<Animal> secondLargestAnimal = animals.stream()
                .distinct()
                .sorted(houseOfSleepingComparator.reversed())
                .skip(1)
                .findFirst();

        System.out.println("second smallest: " + secondSmallestAnimal.get());
        System.out.println("second largest: " + secondLargestAnimal.get());

    }
}
