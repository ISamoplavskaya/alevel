package ua.samoplavskaya.hw_reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class PersonFactory {
    public Person createPerson(String name, int age, String address) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<? extends Person> personClass = Person.class;
        return personClass.getConstructor(String.class, int.class, String.class).newInstance(name, age, address);
    }
    public void printFields(Object obj) throws ClassNotFoundException, IllegalAccessException {
        Class objectClass =obj.getClass();
        Field[] fields= objectClass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            System.out.println(field.getName()+" : "+field.get(obj));
        }

    }
}
