package ua.samoplavskaya.hw_patterns.factoryMetod;

public class EmailLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println("Logging to email: " + message);
    }
}
