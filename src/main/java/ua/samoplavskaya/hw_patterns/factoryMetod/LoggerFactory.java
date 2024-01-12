package ua.samoplavskaya.hw_patterns.factoryMetod;

public class LoggerFactory {
    public Logger createLogger(LoggerType type) {
        Logger logger = switch (type) {
            case FILE -> new FileLogger();
            case EMAIL -> new EmailLogger();
            case DATABASE -> new DatabaseLogger();
        };
        return logger;
    }
}
