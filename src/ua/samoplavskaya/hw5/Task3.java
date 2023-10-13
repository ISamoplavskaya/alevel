package ua.samoplavskaya.hw5;
//Дан двумерный массив NxN(количество строк = количество столбцов), написать программу
//которая поменяет местами столбцы и строки.

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Task3 {
    public static void main(String[] args) {
        int[][] array = new int[3][3];
        fillArray(array);
        printArray(array);
        System.out.println("===============================");
        printArray(swapColAndRow(array));

    }

    private static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }

    public static void fillArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = ThreadLocalRandom.current().nextInt(1, 20);
            }

        }
    }

    public static int[][] swapColAndRow(int[][] array) {
        int[][] newArray = new int[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                newArray[i][j] = array[j][i];
            }
        }
        return newArray;
    }
}
