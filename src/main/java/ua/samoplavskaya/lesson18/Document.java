package ua.samoplavskaya.lesson18;

//        Написати код, який буде обробляти цю анотацію @Printable. А саме:
//        Створити клас Document, в якого буде 3 поля типу String. Створити конструктор, який буде їх ініціалізовувати.
//        Поставити анотацію @Printable над якимось із полів, можна на 2х, можна на 3х.
//        І написати в мейні наступну логіку:
//        - витягнути !! приватні поля з класу Document
//        - перевірити, чи поле анотоване анотацією @Printable
//        - якщо так, то дістати значення цього поля з реально
public class Document {
    @Printable
    private String firstName;
    @Printable
    private String secondName;
    private String position;

    public Document(String firstName, String secondName, String position) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.position = position;
    }
}
