package ua.samoplavskaya.hw5;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

//Проверить, заданный массив на упорядоченность по убыванию, т. е. определить, верно ли,
//что каждый его элемент, начиная со второго, не больше предыдущего.
//*передать массив в метод, получить boolean
public class Task2 {
    public static void main(String[] args) {
        int[] array = {11, 10, 8, 7, 2, 1};
        System.out.println(Arrays.toString(array));
        if (isSortOfHighest(array)) {

            System.out.println("Items are sorted in descending order");
        } else System.out.println("Elements are not sorted");
    }

    public static boolean isSortOfHighest(int[] array) {
        int marker = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i + 1] >= array[i]) {
                marker++;
            }
        }
        if (marker == 0) {
            return true;
        } else return false;
    }

}
