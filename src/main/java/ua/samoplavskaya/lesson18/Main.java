package ua.samoplavskaya.lesson18;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Person person = new Person("Alex", 35);
        Class<? extends Person> personClass = Person.class;
        Field ageField = personClass.getDeclaredField("age");
        ageField.setAccessible(true);
        int age = ageField.getInt(person);
        System.out.println(age);
        ageField.set(person, 999);
        System.out.println(ageField.getInt(person));


    }
}
