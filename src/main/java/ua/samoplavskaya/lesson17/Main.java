package ua.samoplavskaya.lesson17;

import ua.samoplavskaya.lesson14.Animal;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.StringReader;

public class Main {
    public static void main(String[] args) throws IOException {
        File file=new File("D:\\A-Level\\Home work\\HomeWork\\src\\ua\\samoplavskaya\\lesson17\\example.txt");
        RandomAccessFile randomAccessFile=new RandomAccessFile(file,"r");
        randomAccessFile.readLine();

        String kindOfFood=randomAccessFile.readLine().split(":")[1];
        String str=randomAccessFile.readLine().split(":")[1].trim();
        int houseOfSleeping=Integer.parseInt(str);
        Animal animal=new Animal(kindOfFood,houseOfSleeping);
        animal.eat();
        animal.sleep();


    }
}
