package ua.samoplavskaya.lesson16;

import ua.samoplavskaya.lesson14.Animal;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Test {
    public static void main(String[] args) throws IOException {


        File file = new File(("D:\\A-Level\\Home work\\HomeWork\\src\\ua\\samoplavskaya\\lesson16\\example.txt"));
        file.createNewFile();

        FileOutputStream fileOutputStream=new FileOutputStream(file);
        Animal animal=new Animal("meat",5);

        ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(animal);
    }
}