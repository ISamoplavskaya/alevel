package ua.samoplavskaya.hw_jdbc1;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/alevel","postgres","X951d4b0f");
        String query="insert into public.employee (first_name,last_name,contact_id) values (?,?,?)";
        addEmployee(connection, query,"Olga","Sokol",2);
        addEmployee(connection, query,"Vlad","Piontkovskyiy",4);

        printAllEmployee(connection);
        connection.close();
    }

    private static void printAllEmployee(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from public.employee");
        while (resultSet.next()){
            System.out.println(resultSet.getString("first_name")+" "+resultSet.getString("last_name"));
        }
    }

    private static void addEmployee(Connection connection, String query,String firstName,String lastName,int contactID) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,firstName);
        preparedStatement.setString(2,lastName);
        preparedStatement.setInt(3,contactID);
        preparedStatement.execute();
    }
}
