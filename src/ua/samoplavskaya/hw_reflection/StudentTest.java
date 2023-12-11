package ua.samoplavskaya.hw_reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class StudentTest {
    public static void main(String[] args) {
        System.out.println("=========Task1=========");
        Student student = new Student("Alex", "Brown", 35, 85);
        StudentInfoPrinter printer = new StudentInfoPrinter();
        try {
            printer.printStudentInfo(student);
            Method metodExamStore = Student.class.getDeclaredMethod("passExamSuccessfully");
            metodExamStore.setAccessible(true);
            metodExamStore.invoke(student);
            System.out.println("\nNew exam score:");
            printer.printStudentInfo(student);

            System.out.println("=========Task2=========");
            PersonFactory personFactory = new PersonFactory();
            Person person = personFactory.createPerson("Ron", 5, "London,Baker str");
            personFactory.printFields(person);
        } catch (NoSuchMethodException | ClassNotFoundException | IllegalAccessException | InstantiationException |
                 InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
