package ua.samoplavskaya.hw_arrayList;


public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrayInt = new ArrayList<>(2);
        arrayInt.add(5);
        arrayInt.add(6);
        arrayInt.add(7);
        arrayInt.add(7);
        arrayInt.add(7);
        arrayInt.print();
        System.out.println("Index of element: " + arrayInt.indexOf(7));
        arrayInt.add(8, 2);
        System.out.println("Array with added element:");
        arrayInt.print();
        System.out.println("Does the array contain the given element? " + arrayInt.isContains(7));
        System.out.println("3d element of array: " + arrayInt.get(3));
        arrayInt.remove(1);
        arrayInt.print();
    }
}
