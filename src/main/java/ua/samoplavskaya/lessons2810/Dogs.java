package ua.samoplavskaya.lessons2810;

public class Dogs {
    private String name;
    private int age;

    Dogs(String name) {
        this.name = name;
    }

    Dogs(String name, int age) {
        this(name);
        this.age = age;
    }

    Dogs() {};

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 0) {
            System.out.println("Age must be positive");
        } else {
            this.age = age;
        }
    }

    public void printDogName() {
        System.out.println("This dog's name is " + name);
    }

    public void printDogAge() {
        System.out.println("This dog's age is " + age);
    }
}
