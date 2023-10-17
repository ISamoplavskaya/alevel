package ua.samoplavskaya.hw4;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

//Заполнить одномерный массив случайными целочисленными значениями.
//• Все четные значения заменить на нули. Размер массива - 2000 элементов.
public class Task3 {
    public static void main(String[] args) {
        int[] numbers = new int[2000];
        fill(numbers);
        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(replaceEvenWithZero(numbers)));
    }

    public static void fill(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = ThreadLocalRandom.current().nextInt();
        }
    }

    public static int[] replaceEvenWithZero(int[] array) {
        int[] newArray = Arrays.copyOf(array, array.length);
        for (int i = 0; i < newArray.length; i++) {
            if (newArray[i] % 2 == 0) {
                newArray[i] = 0;
            }
        }
        return newArray;
    }
}
