package ua.samoplavskaya.lesson18;

import java.lang.reflect.Field;

public class Main1 {
    public static void main(String[] args) {
        Document document=new Document("Alex","Black","manager");
        Class<? extends Document> documentClass=document.getClass();
        Field[] fields=documentClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Printable.class)) {
                try {
                    field.setAccessible(true);
                    Object value = field.get(document);
                    System.out.println("Field Name: " + field.getName() + ", Value: " + value);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
