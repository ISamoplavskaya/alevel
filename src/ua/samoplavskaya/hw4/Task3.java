package ua.samoplavskaya.hw4;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

//Заполнить одномерный массив случайными целочисленными значениями.
//• Все четные значения заменить на нули. Размер массива - 2000 элементов.
public class Task3 {
    public static void main(String[] args) {
        int[] numbers= new int[2000];
        fill(numbers);
        System.out.println(Arrays.toString(numbers));
        int[] newNumbers = Arrays.copyOf(numbers,numbers.length) ;
        replaceWith0(newNumbers);
        System.out.println(Arrays.toString(newNumbers));
    }

    public static void fill(int[] array){
        for (int i = 0; i < array.length; i++) {
            array[i]= ThreadLocalRandom.current().nextInt();
        }
    }

    public static void replaceWith0(int[] array){
        for (int i = 0; i < array.length; i++) {
            if (array[i]%2==0){
                array[i]=0;
            }

        }
    }
}
