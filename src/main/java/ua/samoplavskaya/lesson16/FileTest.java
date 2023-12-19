package ua.samoplavskaya.lesson16;

import ua.samoplavskaya.lesson14.Animal;

import java.io.*;
import java.util.Scanner;

public class FileTest {
    public static void main(String[] args) throws IOException {
        File file=new File("D:\\A-Level\\Home work\\HomeWork\\src\\ua\\samoplavskaya\\lesson16\\file1.txt");
        file.createNewFile();

        FileWriter writer=new FileWriter(file);
        String text="Hello";
        writer.write(text);
        writer.flush();


    }
}
