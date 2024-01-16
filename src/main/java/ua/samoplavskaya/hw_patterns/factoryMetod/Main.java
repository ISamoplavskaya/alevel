package ua.samoplavskaya.hw_patterns.factoryMetod;

public class Main {
    public static void main(String[] args) {
        LoggerFactory loggerFactory = new LoggerFactory();
        Logger logger = loggerFactory.createLogger(LoggerType.DATABASE);
        logger.log("Hello");
    }
}
