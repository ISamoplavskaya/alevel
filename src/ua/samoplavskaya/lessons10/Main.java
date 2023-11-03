package ua.samoplavskaya.lessons10;


public class Main {
    public static void main(String[] args) {
        Animal dog = new Dog("Meat", 5);
        Animal cat = new Cat("Fish", 2);
        int dogHours = dog.getHoursOfSleeping();
        int catHours = cat.getHoursOfSleeping();
        System.out.println("The animal with the longest hours of sleep eats " + ((dogHours > catHours) ? dog.getKindOFood() : cat.getKindOFood()));


    }
}
