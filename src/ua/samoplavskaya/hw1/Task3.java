package ua.samoplavskaya.hw1;

public class Task3 {
    public static void main(String[] args) {
        int a=5;
        int b=3;
        System.out.println("Before swaping : a = " + a + ", b = "+b);
        a=a+b-(b=a);
        System.out.println("After swaping : a = " + a + ", b = "+b);
    }
}
