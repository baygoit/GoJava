package dao;

import jdbc.ConnectorDB;
import model.User;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by root on 04.11.15.
 */
public class UserDAO implements AbstractDAO<Integer, User> {

    public static final String SQL_SELECT_ALL_USERS = "SELECT * FROM User";
    public static final String SQL_INSERT = "INSERT INTO User VALUES(?,?,?,?,?,?)";

    private ConnectorDB connectorDB = new ConnectorDB();
    private Connection connection = connectorDB.getConnection();

    public Set<User> findAll() {
        Set<User> users = new HashSet<User>();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_USERS);

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                user.setLastname(resultSet.getString("lastname"));
                user.setEmail(resultSet.getString("email"));
                user.setIsRegisteredAsHost(resultSet.getBoolean("isHost"));


                users.add(user);
            }

        } catch (SQLException e) {
            System.err.println("SQL exception (request or table failed): " + e);
        }
        finally {
            try {
                statement.close();
                connectorDB.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return users;
    }

    public User findEntityById(Integer id) {
        return null;
    }

    public boolean delete(Integer id) {
        return false;
    }

    public boolean delete(User entity) {
        return false;
    }

    public boolean create(User entity) {
        boolean flag = false;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_INSERT);
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.setString(2, entity.getName());
            preparedStatement.setString(3, entity.getPassword());
            preparedStatement.setString(4, entity.getLastname());
            preparedStatement.setString(5, entity.getEmail());
            preparedStatement.setBoolean(6, entity.isRegisteredAsHost());

            preparedStatement.executeUpdate();

            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                    connectorDB.closeConnection();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return flag;
    }

    public User update(User entity) {
        return null;
    }
}
