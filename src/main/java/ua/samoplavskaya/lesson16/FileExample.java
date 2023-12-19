package ua.samoplavskaya.lesson16;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


public class FileExample {
    public static void main(String[] args) throws IOException {
        File file1 = new File("D:\\A-Level\\Home work\\HomeWork\\src\\ua\\samoplavskaya\\lesson16\\file1.txt");
        File file2 = new File("D:\\A-Level\\Home work\\HomeWork\\src\\ua\\samoplavskaya\\lesson16\\file2.txt");
        file1.createNewFile();
        file2.createNewFile();

        FileOutputStream fileOutputStream = new FileOutputStream(file1);
        String text = "Hello from file, I am on java lesson";
        byte[] bytes = text.getBytes(StandardCharsets.UTF_8);
        fileOutputStream.write(bytes);

        fileOutputStream.close();
        FileInputStream fileInputStream = new FileInputStream(file1);
        byte[] c = fileInputStream.readAllBytes();
        fileInputStream.close();
        FileOutputStream fileOutputStream1 = new FileOutputStream(file2);
        fileOutputStream1.write(c);
        fileOutputStream1.close();


    }
}
