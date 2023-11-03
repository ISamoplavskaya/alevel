package ua.samoplavskaya.lessons10;

public class Cat extends Animal {
    private String kindOFood;
private int hoursOfSleeping;

    public Cat(String kindOFood, int hoursOfSleeping) {
        super(kindOFood, hoursOfSleeping);
        this.kindOFood=kindOFood;
        this.hoursOfSleeping=hoursOfSleeping;

    }

    @Override
    public String getKindOFood() {
        return kindOFood;
    }

    @Override
    public int getHoursOfSleeping() {
        return hoursOfSleeping;
    }
}
