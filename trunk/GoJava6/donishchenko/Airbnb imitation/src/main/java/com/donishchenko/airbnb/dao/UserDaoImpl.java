package com.donishchenko.airbnb.dao;

import com.donishchenko.airbnb.jdbc.DBUtils;
import com.donishchenko.airbnb.model.User;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private static final String saveUserQuery =
            "INSERT INTO user VALUES(null, ?, ?, ?, ?)";

    private static final String deleteUserQuery =
            "DELETE FROM user WHERE id = ?";

    private static final String getUserByIdQuery =
            "SELECT id, name, surname, email, isHost FROM user WHERE id = ?";

    private static final String getAllUsersQuery =
            "SELECT * FROM user";

    private static final String getAllUsersParamQuery =
            "SELECT * FROM user WHERE isHost = ?";

    @Override
    public void save(User user) throws SQLException {
        try (Connection conn = DBUtils.getConnection()) {
            PreparedStatement stat = conn.prepareStatement(saveUserQuery);
            stat.setString(1, user.getName());
            stat.setString(2, user.getSurname());
            stat.setString(3, user.getEmail());
            stat.setBoolean(4, user.isHost());

            stat.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        try (Connection conn = DBUtils.getConnection()) {
            PreparedStatement stat = conn.prepareStatement(deleteUserQuery);
            stat.setInt(1, id);

            stat.executeUpdate();
        }
    }

    @Override
    public User getUserById(int id) throws SQLException {
        try (Connection conn = DBUtils.getConnection()) {
            PreparedStatement stat = conn.prepareStatement(getUserByIdQuery);
            stat.setInt(1, id);

            ResultSet result = stat.executeQuery();
            result.next();

            return createUser(result);
        }
    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        return getAllUsersWithParameter(Parameter.ALL);
    }

    @Override
    public List<User> getAllClients() throws SQLException {
        return getAllUsersWithParameter(Parameter.CLIENT);
    }

    @Override
    public List<User> getAllHosts() throws SQLException {
        return getAllUsersWithParameter(Parameter.HOST);
    }

    private enum Parameter {
        ALL, CLIENT, HOST
    }

    private List<User> getAllUsersWithParameter(Parameter param) throws SQLException {
        try (Connection conn = DBUtils.getConnection()) {
            List<User> list = new LinkedList<>();

            String query = getAllUsersQuery;
            boolean isHost = false;
            if (param == Parameter.CLIENT) {
                query = getAllUsersParamQuery;
                isHost = false;
            } else if (param == Parameter.HOST) {
                query = getAllUsersParamQuery;
                isHost = true;
            }

            PreparedStatement stat = conn.prepareStatement(query);
            if (param != Parameter.ALL) {
                stat.setBoolean(1, isHost);
            }

            ResultSet result = stat.executeQuery();
            while (result.next()) {
                list.add(createUser(result));
            }

            return list;
        }
    }

    private User createUser(ResultSet result) throws SQLException {
        int id          = result.getInt(1);
        String name     = result.getString(2);
        String surname  = result.getString(3);
        String email    = result.getString(4);
        boolean isHost  = result.getBoolean(5);

        User user = new User(name, surname, email, isHost);
        user.setId(id);

        return user;
    }
}
