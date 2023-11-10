package ua.samoplavskaya.lessons2810;

public class Task2 {
    public static void main(String[] args) {

        Animal dog = new Animal();
        Animal cat = new Animal();
        Animal fish = new Animal();

        dog.setKindOFood("Meat");
        dog.setHoursOfSleeping(9);
        cat.setKindOFood("Fish");
        cat.setHoursOfSleeping(15);
        fish.setKindOFood("feed");
        fish.setHoursOfSleeping(7);
        System.out.println("The animal with the longest hours of sleep eats " + animalWithMaxHours(dog, cat, fish).getKindOFood());

    }

    public static Animal animalWithMaxHours(Animal animal1, Animal animal2, Animal animal3) {
        int animal1Hours = animal1.getHoursOfSleeping();
        int animal2Hours = animal2.getHoursOfSleeping();
        int animal3Hours = animal3.getHoursOfSleeping();
        if (animal1Hours < animal2Hours) {
            if (animal2Hours < animal3Hours) {
                return animal3;
            } else return animal2;
        } else if (animal1Hours < animal3Hours) {
            return animal3;
        } else return animal1;
    }
}