package ua.samoplavskaya.lessons10;

public class OldDogs extends Dogs{
    private String name;
    private int age;
    public OldDogs(String name, int age) {
        super(name,age);

    }

    @Override
    public void setAge(int age) {
        super.setAge(age);
        if (age < 10) {
            System.out.println("Age must be more than 10");
        } else {
            this.age = age;
        }
    }

    @Override
    public void printDogName() {
        System.out.println("This old dog's name is "+name);
    }

    @Override
    public void dogColor() {
        System.out.println("This old dog is black");
    }

}
