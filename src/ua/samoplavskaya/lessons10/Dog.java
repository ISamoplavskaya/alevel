package ua.samoplavskaya.lessons10;

public class Dog extends Animal{
    private String kindOFood;

    private int hoursOfSleeping;

    public Dog(String kindOFood, int hoursOfSleeping) {
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
