package ua.samoplavskaya.lesson14;


import java.io.Serializable;
import java.util.Objects;

public class Animal implements Serializable {
    private String kindOFood;
    private int hoursOfSleeping;

    public Animal(String kindOFood, int hoursOfSleeping) {
        this.kindOFood = kindOFood;
        this.hoursOfSleeping = hoursOfSleeping;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return hoursOfSleeping == animal.hoursOfSleeping && Objects.equals(kindOFood, animal.kindOFood);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kindOFood, hoursOfSleeping);
    }

    public void eat() {
        ;
        System.out.println("Eat " + kindOFood);
    }

    public void sleep() {
        System.out.println("Sleep " + hoursOfSleeping);
    }

    public void setKindOFood(String kindOFood) {
        this.kindOFood = kindOFood;
    }

    public String getKindOFood() {
        return kindOFood;
    }

    public int getHoursOfSleeping() {
        return hoursOfSleeping;
    }

    public void setHoursOfSleeping(int hoursOfSleeping) {
        if (hoursOfSleeping < 0) {
            System.out.println("Hours of sleeping must be positive");
        } else {
            this.hoursOfSleeping = hoursOfSleeping;
        }
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Animal{");
        sb.append("kindOFood='").append(kindOFood).append('\'');
        sb.append(", hoursOfSleeping=").append(hoursOfSleeping);
        sb.append('}');
        return sb.toString();
    }
}