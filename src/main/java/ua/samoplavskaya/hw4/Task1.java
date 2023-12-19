package ua.samoplavskaya.hw4;
//Заполнить одномерный массив случайными целочисленными значениями.
//• Найти среднее арифметическое и среднее геометрическое элементов массива. Размер массива -
//400 элементов.
//P.S. значения элементов можно ограничить значениями 1-10 включительно.
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Task1 {
    public static void main(String[] args) {
        int[] numbers= new int[400];
        fill(numbers);
        System.out.println(Arrays.toString(numbers));
        System.out.println("Arithmetic average= "+ arithmeticAverage(numbers));
        System.out.println("Geometric average= "+ geometricAverage(numbers));

    }
    
    
    public static void fill(int[] array){
        for (int i = 0; i < array.length; i++) {
            array[i]= ThreadLocalRandom.current().nextInt(1,10);
        }
    }

    public static double arithmeticAverage(int[] array){
        double sum=0;
        for (int i = 0; i < array.length; i++) {
            sum+=array[i];
        }
        return sum/array.length;
    }

    public static double geometricAverage (int[] array){
        double mult=1;
        for (int i = 0; i < array.length; i++) {
            mult*=array[i];
        }
        return Math.pow(mult, (double) 1/array.length);
    }
}
