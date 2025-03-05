//package jm.task.core.jdbc.dao;
//import jm.task.core.jdbc.model.User;
//import jm.task.core.jdbc.util.Util;
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//public class UserDaoJDBCImpl implements UserDao {
//    private static final Logger logger = Logger.getLogger(UserDaoJDBCImpl.class.getName());
//    private final Connection connection = Util.getConnection();
//
//    public UserDaoJDBCImpl() {
//        // Пустой конструктор
//    }
//
//    @Override
//    public void createUsersTable() {
//        String sql = "CREATE TABLE IF NOT EXISTS users (" +
//                "id BIGINT PRIMARY KEY AUTO_INCREMENT, " +
//                "name VARCHAR(50), " +
//                "lastName VARCHAR(50), " +
//                "age TINYINT)";
//        try (Statement statement = connection.createStatement()) {
//            statement.executeUpdate(sql);
//        } catch (SQLException e) {
//            logger.log(Level.SEVERE, "Ошибка при создании таблицы users", e);
//        }
//    }
//
//    @Override
//    public void dropUsersTable() {
//        String sql = "DROP TABLE IF EXISTS users";
//        try (Statement statement = connection.createStatement()) {
//            statement.executeUpdate(sql);
//        } catch (SQLException e) {
//            logger.log(Level.SEVERE, "Ошибка при удалении таблицы users", e);
//        }
//    }
//
//    @Override
//    public void saveUser(String name, String lastName, byte age) {
//        String sql = "INSERT INTO users (name, lastName, age) VALUES (?, ?, ?)";
//        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//            preparedStatement.setString(1, name);
//            preparedStatement.setString(2, lastName);
//            preparedStatement.setByte(3, age);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            logger.log(Level.SEVERE, "Ошибка при сохранении пользователя", e);
//        }
//    }
//
//    @Override
//    public void removeUserById(long id) {
//        String sql = "DELETE FROM users WHERE id = ?";
//        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//            preparedStatement.setLong(1, id);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            logger.log(Level.SEVERE, "Ошибка при удалении пользователя по id", e);
//        }
//    }
//
//    @Override
//    public List<User> getAllUsers() {
//        List<User> users = new ArrayList<>();
//        String sql = "SELECT * FROM users";
//        try (Statement statement = connection.createStatement();
//             ResultSet resultSet = statement.executeQuery(sql)) {
//            while (resultSet.next()) {
//                User user = new User();
//                user.setId(resultSet.getLong("id"));
//                user.setName(resultSet.getString("name"));
//                user.setLastName(resultSet.getString("lastName"));
//                user.setAge(resultSet.getByte("age"));
//                users.add(user);
//            }
//        } catch (SQLException e) {
//            logger.log(Level.SEVERE, "Ошибка при получении списка пользователей", e);
//        }
//        return users;
//    }
//
//    @Override
//    public void cleanUsersTable() {
//        String sql = "TRUNCATE TABLE users";
//        try (Statement statement = connection.createStatement()) {
//            statement.executeUpdate(sql);
//        } catch (SQLException e) {
//            logger.log(Level.SEVERE, "Ошибка при очистке таблицы users", e);
//        }
//    }
//}