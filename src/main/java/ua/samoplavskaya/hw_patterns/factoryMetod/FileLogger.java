package ua.samoplavskaya.hw_patterns.factoryMetod;

public class FileLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println("Logging to file" + message);
    }
}
