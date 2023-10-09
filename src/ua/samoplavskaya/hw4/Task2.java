package ua.samoplavskaya.hw4;
//Заполнить одномерный массив случайными целочисленными значениями.
//• Проверить сколько простых чисел присутствует в массиве. Размер массива 1000 элементов.
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Task2 {
    public static void main(String[] args) {
        int[] numbers = new int[1000];
        fill(numbers);
        System.out.println(Arrays.toString(numbers));

        System.out.println("The number of prime numbers in the array is " + howManyPrime(numbers));
    }

    public static void fill(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(1, 100);
        }
    }

    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int howManyPrime(int[] array) {
        int k = 0;
        for (int i = 0; i < array.length; i++) {
            if (isPrime(array[i])) {
                //System.out.println(array[i]);
                k++;
            }
        }
        return k;
    }
}




