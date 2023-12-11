package ua.samoplavskaya.hw_reflection;

public class Student {
    @ShowInfo
    private String firstName;
    @ShowInfo
    private String lastName;
    @ShowInfo(show = false)
    private int age;
    @ShowInfo
    private int examScore;

    public Student(String firstName, String lastName, int age, int examScore) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.examScore = examScore;
    }

    private void passExamSuccessfully() {
        this.examScore = 100;
    }
}
