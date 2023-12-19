package ua.samoplavskaya.lesson12;

public class Printer <T>{
    public void print(T[] list){
        for (T item: list) {
            System.out.println(item);
        }
    }
}
