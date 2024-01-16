package ua.samoplavskaya.hw_patterns.factoryMetod;

public class DatabaseLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println("Logging to database: " + message);
    }
}
