package ua.samoplavskaya.lesson12;

import java.util.Arrays;

public class ArrayCombination {
    public static <T> T[] ArrayCombi(T[] array1, T[] array2) {
        int length1 = array1.length;
        int length2 = array2.length;

        T[] result = Arrays.copyOf(array1, length1 + length2);

        for (int i = 0; i < length2; i++) {
            result[length1 + i] = array2[i];
        }
        return result;
    }
}
