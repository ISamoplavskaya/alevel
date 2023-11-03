package ua.samoplavskaya.lessons10;

public abstract class Animal {
    public Animal(String kindOFood, int hoursOfSleeping) {
        this.kindOFood = kindOFood;
        this.hoursOfSleeping = hoursOfSleeping;
    }
    private String kindOFood;

    private int hoursOfSleeping;

    public abstract String getKindOFood();

    public abstract int getHoursOfSleeping();
}
