package ua.samoplavskaya.hw_dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnectionUtil {
    public static Connection get() {
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/alevel", "postgres", "postgres");
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
