package ua.samoplavskaya.lesson12;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {


        Integer[] intArray1 = {1, 2, 3};
        Integer[] intArray2 = {4, 5, 6};

        Integer[] intArraysCombi = ArrayCombination.ArrayCombi(intArray1, intArray2);
        System.out.println(Arrays.toString(intArraysCombi));
    }



}
