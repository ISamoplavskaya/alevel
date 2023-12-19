package ua.samoplavskaya.hw6;
//Ошибка в строке 22. ПРи запуске Debug выводит ошибку "java.lang.IndexOutOfBoundsException : Invalid array range: 1 to 1"
// при значениях i=0, j=1. Искала ошибку в цикле For. Там и заметила, что вместо j<triangle[i].length стоит i.

import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        int[][] triangle = new int[5][];
        triangle[0] = new int[1];
        triangle[1] = new int[2];
        triangle[2] = new int[3];
        triangle[3] = new int[4];
        triangle[4] = new int[5];
        for (int i = 0; i < triangle.length; i++) {
            System.out.println(triangle.length + "!");
            System.out.println("i = " + i);
            for (int j = 0; j < triangle[i].length; j++) {
                System.out.println(triangle[i].length);
                triangle[i][j] = 0;
            }
        }

        for (int i = 0; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                System.out.print(triangle[i][j] + " ");

            }
            System.out.println();
        }
    }
}
