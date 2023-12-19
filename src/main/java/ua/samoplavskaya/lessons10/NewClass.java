package ua.samoplavskaya.lessons10;

public class NewClass implements Swimmable{
    @Override
    public void swim() {
        System.out.println("swim");
    }

    @Override
    public void walk() {
        System.out.println("walk");
    }
}
