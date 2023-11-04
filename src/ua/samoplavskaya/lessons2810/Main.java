package ua.samoplavskaya.lessons2810;

public class Main {
    public static void main(String[] args) {
        System.out.println("Task1");
        classDogs();
        System.out.println("Task2");
        animalWithMaxSleepHours();
        System.out.println("Task3");
        inheritorClass();

    }

    public static void classDogs() {
        Dogs dog1 = new Dogs("maltipoo", 10);
        Dogs dog2 = new Dogs();
        dog2.setAge(5);
        dog2.setName("Buldog");
        dog2.printDogName();
        dog2.printDogAge();
    }

    public static void animalWithMaxSleepHours() {
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
    private static Animal animalWithMaxHours(Animal animal1, Animal animal2, Animal animal3) {
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

    public static void inheritorClass() {
        OldDogs oldDog = new OldDogs("Kolly", 5);
        oldDog.printDogName();
        oldDog.printDogAge();
        oldDog.setAge(12);
        oldDog.printDogAge();
        oldDog.setName("Kolly");
        System.out.println("This old dog's name is "+ oldDog.getName());
    }
}
