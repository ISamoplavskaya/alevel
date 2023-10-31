package ua.samoplavskaya.lessons2810;

import java.io.OutputStream;

public class Task3 {
    public static void main(String[] args) {
        OldDogs oldDog = new OldDogs("Kolly", 5);
        oldDog.printDogName();
        oldDog.printDogAge();
        oldDog.setAge(12);
        oldDog.printDogAge();
        oldDog.setName("Kolly");
        System.out.println("This old dog's name is "+ oldDog.getName());
    }
}
