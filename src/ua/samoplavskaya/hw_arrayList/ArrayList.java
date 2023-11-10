package ua.samoplavskaya.hw_arrayList;

import java.util.Arrays;

public class ArrayList<T> {
    private Object[] array;
    private int size;

    ArrayList(int size) {
        this.size = size;
        array = new Object[size];
    }

    //Add element to the end of array {1,2,3} -> {1,2,3,4}
    void add(T element) {
        Object[] newArray = array;
        array = Arrays.copyOf(newArray, newArray.length + 1);
        array[array.length - 1] = element;
    }

    //Add element to given position of array {1,2,3} -> {1,4,2,3}
    void add(T element, int index) {
        Object[] newArray = array;
        array = new Object[newArray.length + 1];

        if (index != 0) {
            for (int i = 0; i < newArray.length + 1; i++) {
                if (i < index) {
                    array[i] = newArray[i];
                } else if (i == index) {
                    array[index] = element;
                } else array[i] = newArray[i - 1];
            }
        } else {
            System.arraycopy(newArray, 0, array, index + 1, newArray.length);
            array[index] = element;
        }
    }

    //Returns index of the given element, if element doesn't exist return -1
    int indexOf(T element) {
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (element == array[i]) {
                index = i;
            }
        }
        return index;
    }

    boolean isContains(T element) {
        return indexOf(element) != -1;
    }

    T get(int index) {
        return (T) array[index];
    }


    Object[] remove(int index) {
        Object[] newArray = array;
        array = new Object[newArray.length - 1];
            for (int i = 0; i < newArray.length -1; i++) {
                if (i < index) {
                    array[i] = newArray[i];
                } else array[i] = newArray[i +1];
            }
        return array;

    }

    void print() {
        for (Object o : array) {
            System.out.println(o);
        }
    }
}