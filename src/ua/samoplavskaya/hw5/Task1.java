package ua.samoplavskaya.hw5;

import java.util.Arrays;
import java.util.Scanner;

//Заполнение двумерного массива значениями индекса (от 1 и до кол-ва элементов в
//массиве), при этом каждая вторая строка - отрицательными значениями.
//Например
//1 2 3
//-4 -5 -6
//7 8 9
//-10 -11 -12
//*Передать массив в метод, заполнить данный массив
public class Task1 {
    public static void main(String[] args) {
        int[][] array = new int[4][3];
        fillArray(array);
        printArray(array);
    }

    public static void fillArray(int[][] array) {
        int k = 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i % 2 == 0) {
                    array[i][j] = k;
                } else array[i][j] = -k;
                k++;
            }
        }
    }
    private static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }

}

