package ua.samoplavskaya.lesson14;

import java.util.Comparator;

public class AnimalKindOfFoodComparator implements Comparator<Animal> {
    @Override
    public int compare(Animal o1, Animal o2) {
        return (o1.getKindOFood().compareTo(o2.getKindOFood()));
    }
}