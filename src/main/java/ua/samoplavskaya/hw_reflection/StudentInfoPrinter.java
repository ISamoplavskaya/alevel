package ua.samoplavskaya.hw_reflection;

import java.lang.reflect.Field;

public class StudentInfoPrinter {
    public void printStudentInfo(Student student) throws IllegalAccessException {
        Class<? extends Student> studentClass = Student.class;
        Field[] fields = studentClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(ShowInfo.class)) {
                ShowInfo annotation = field.getAnnotation(ShowInfo.class);
                if (annotation.show()) {
                    field.setAccessible(true);
                    Object fieldValue = field.get(student);
                    System.out.println(field.getName() + " : " + fieldValue);

                }
            }

        }
    }
}
