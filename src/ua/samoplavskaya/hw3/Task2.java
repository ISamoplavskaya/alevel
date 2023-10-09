package ua.samoplavskaya.hw3;
//Подсчитать количество слов в строке
//• Вводится строка, состоящая из слов, разделенных пробелами.
// Требуется посчитать количество слов в ней.

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter string:");
        String line = scanner.nextLine().trim();
        //System.out.println(removeExtraSpaces(line));
        String mewLine = removeExtraSpaces(line);
        System.out.println("The number of words in a line is " + wordCounter(mewLine));
    }

    public static String removeExtraSpaces(String line) {
        while (line.contains("  ")) {
            String replace = line.replace("  ", " ");
            line = replace;
        }
        return line;
    }

    public static int wordCounter(String line) {
        int n = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == ' ') {
                n++;
            }
        }
        return n + 1;
    }
}

