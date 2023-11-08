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
        Animal[] animals = {dog, cat, fish};
        System.out.println("The animal with the longest hours of sleep eats " + animalWithMaxHours(animals).getKindOFood());

    }

    private static Animal animalWithMaxHours(Animal[] animals) {
        Animal maxAnimal = null;
        int maxHoursOfSleeping = 0;

        for (Animal animal : animals) {
            int houseOfSleeping = animal.getHoursOfSleeping();
            if (houseOfSleeping > maxHoursOfSleeping) {
                maxHoursOfSleeping = houseOfSleeping;
                maxAnimal = animal;
            }
        }
        return maxAnimal;
    }

    public static void inheritorClass() {
        OldDogs oldDog = new OldDogs("Kolly", 5);
        oldDog.printDogName();
        oldDog.printDogAge();
        oldDog.setAge(12);
        oldDog.printDogAge();
        oldDog.setName("Kolly");
        System.out.println("This old dog's name is " + oldDog.getName());
    }
}
