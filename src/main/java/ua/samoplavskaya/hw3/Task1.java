package ua.samoplavskaya.hw3;
//Удалить из строки пробелы и определить, является ли она перевертышем (палиндромом)

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter string:");
        String line = scanner.nextLine();
        String lineWithoutSpases = removeSpases(line);
        System.out.println(lineWithoutSpases);
        polydrome(lineWithoutSpases);
    }

    public static String removeSpases(String line) {
        String lineWithoutSpases = line.replaceAll(" ", "");
        return lineWithoutSpases;
    }

    public static void polydrome(String line) {
        String reverseLine = new StringBuilder(line).reverse().toString();
        if (reverseLine.equals(line)) {
            System.out.println("The string is a polydrome");
        } else System.out.println("The string is not a polydrome");
    }
}

