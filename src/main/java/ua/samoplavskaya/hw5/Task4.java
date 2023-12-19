package ua.samoplavskaya.hw5;

//Удаление из массива k-го элемента со сдвигом всех расположенных справа от него
//элементов на одну позицию влево.
//*Необходимо создать новый массив, в котором удаляется элемент и вернуть его из метода.
//Изначальный массив не должен измениться
//[1, 2, 3, 4] -> [1, 2, 4]

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Task4 {
    public static void main(String[] args) {
        int[] array = new int[10];
        fillArray(array);
        System.out.println(Arrays.toString(array));
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the item number that needs to be removed?(Remember that the countdown starts from 0)");
        int k = scanner.nextInt();
        System.out.println("New array:");
        System.out.println(Arrays.toString(removeKElement(array, k)));

    }

    public static void fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(1, 10);
        }
    }

    public static int[] removeKElement(int[] array, int k) {
        int[] newArray = new int[array.length - 1];
        for (int i = 0; i < array.length; i++) {
            if (i < k) {
                newArray[i] = array[i];
            } else if (i == k) {
                continue;
            } else newArray[i - 1] = array[i];
        }
        return newArray;
    }
}
