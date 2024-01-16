package ua.samoplavskaya.hw_patterns.builder;

public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer.Builder()
                .setProcessor("Intel(R) Core(TM) i7-7700HQ CPU")
                .setCapacity(64)
                .setGpu("HD Graphics 630")
                .setRam(16.0)
                .setMotherboard("ASUSTec Computer X580VD.317")
                .build();
        System.out.println(computer);

    }
}
