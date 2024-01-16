package ua.samoplavskaya.hw_dao.dao.impl;

import ua.samoplavskaya.hw_dao.dao.Dao;
import ua.samoplavskaya.hw_dao.entity.Person;
import ua.samoplavskaya.hw_dao.util.JDBCConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCDao implements Dao<Person> {
    private static final JDBCDao INSTANCE = new JDBCDao();

    private JDBCDao() {
    }

    public static JDBCDao getInstance() {
        return INSTANCE;
    }

    private static final String SAVE_SQL = "INSERT INTO persons(first_name,last_name,email) VALUES (?,?,?);";
    private static final String FIND_SQL = "SELECT * FROM persons WHERE id= ?;";
    private static final String FIND_ALL = "SELECT * FROM persons ORDER BY id;";
    private static final String UPDATE = "UPDATE persons SET first_name=?,last_name=?,email=? WHERE id=?;";
    private static final String DELETE = "DELETE FROM persons WHERE id=?;";

    @Override
    public Optional<Person> findByID(long id) {
        try (Connection connection = JDBCConnectionUtil.get()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_SQL);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Person person = getPerson(resultSet);
                return Optional.of(person);
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Person> findAll() {
        List<Person> persons = new ArrayList<>();
        try (Connection connection = JDBCConnectionUtil.get()) {
            PreparedStatement statement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Person person = getPerson(resultSet);
                persons.add(person);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return persons;
    }
    private static Person getPerson(ResultSet resultSet) throws SQLException {
        Person person = new Person(
                resultSet.getLong("id"),
                resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                resultSet.getString("email")
        );
        return person;
    }

    @Override
    public void save(Person person) {
        try (Connection connection = JDBCConnectionUtil.get()) {
            PreparedStatement statement = connection.prepareStatement(SAVE_SQL);
            statement.setString(1, person.getFirstname());
            statement.setString(2, person.getLastname());
            statement.setString(3, person.getEmail());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Person person) {
        try (Connection connection = JDBCConnectionUtil.get()) {
            PreparedStatement statement = connection.prepareStatement(UPDATE);
            statement.setString(1, person.getFirstname());
            statement.setString(2, person.getLastname());
            statement.setString(3, person.getEmail());
            statement.setLong(4, person.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Person person) {
        try (Connection connection = JDBCConnectionUtil.get()) {
            PreparedStatement statement = connection.prepareStatement(DELETE);
            statement.setLong(1, person.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
