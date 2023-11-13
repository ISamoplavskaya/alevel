package ua.samoplavskaya.lessons2810;

public class Task1 {
    public static void main(String[] args) {
        Dogs dog1=new Dogs("maltipoo", 10);
        Dogs dog2=new Dogs();
        dog2.setAge(5);
        dog2.setName("Buldog");
        dog2.printDogName();
        dog2.printDogAge();

    }
}
