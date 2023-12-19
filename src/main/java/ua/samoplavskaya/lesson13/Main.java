package ua.samoplavskaya.lesson13;

import java.util.*;

//
//написати метод, який приймає List, element та індекс
//Вставляє заданий елемент по заданому індексу та аиаодить ліст у зворотноьмоу порядку
public class Main {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> arrayList2 = new ArrayList<>(Arrays.asList(6,7,5,5));
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(7);
        arrayList.add(8);
        if (compare(arrayList, arrayList2)) {
            System.out.println("The lists are identical");
        } else {
            System.out.println("Lists are different");
        }
        System.out.println("Before test: " + arrayList);
        test(arrayList, 0, 2);
        System.out.println("After test: " + arrayList);
    }

    public static <T> List<T> test(List<T> list, T item, int index) {
        list.add(index, item);
        Collections.reverse(list);
        return list;
    }

    public static <T> boolean compare(List<T> list1, List<T> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }
        return  list1.containsAll(list2)&& list2.containsAll(list1);

    }
}
