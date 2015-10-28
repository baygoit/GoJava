package com.donishchenko.airbnb.dao;

import com.donishchenko.airbnb.jdbc.DBUtils;
import com.donishchenko.airbnb.jdbc.QueryBuilder;
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
            "SELECT * FROM user WHERE id = ?";

    private static final String getAllUsersQuery =
            "SELECT * FROM user";

    private static final String updateUserQuery =
            "UPDATE user SET name = ?, surname = ?, email = ?, isHost = ? WHERE id = ?";

    @Override
    public int save(User user) throws SQLException {
        try (Connection conn = DBUtils.getConnection()) {
            PreparedStatement stat = conn.prepareStatement(saveUserQuery, Statement.RETURN_GENERATED_KEYS);
            stat.setString(1, user.getName());
            stat.setString(2, user.getSurname());
            stat.setString(3, user.getEmail());
            stat.setBoolean(4, user.isHost());

            stat.executeUpdate();

            ResultSet keys = stat.getGeneratedKeys();
            keys.next();
            user.setId(keys.getInt(1));

            return user.getId();
        }
    }

    @Override
    public boolean delete(int id) throws SQLException {
        try (Connection conn = DBUtils.getConnection()) {
            PreparedStatement stat = conn.prepareStatement(deleteUserQuery);
            stat.setInt(1, id);

            int affectedRows = stat.executeUpdate();

            return affectedRows != 0;
        }
    }

    @Override
    public boolean update(int id, User user) throws SQLException {
        User existingUser = get(id);
        if (existingUser == null) {
            throw new SQLException("Wrong id");
        }

        try (Connection conn = DBUtils.getConnection()) {
            PreparedStatement stat = conn.prepareStatement(updateUserQuery);
            stat.setString(1, user.getName());
            stat.setString(2, user.getSurname());
            stat.setString(3, user.getEmail());
            stat.setBoolean(4, user.isHost());
            stat.setInt(5, id);

            int affectedRows = stat.executeUpdate();

            return affectedRows != 0;
        }
    }

    @Override
    public User get(int id) throws SQLException {
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
        return getAllUsersWithParameter();
    }

    @Override
    public List<User> getAllClients() throws SQLException {
        return getAllUsersWithParameter("isHost", "0");
    }

    @Override
    public List<User> getAllHosts() throws SQLException {
        return getAllUsersWithParameter("isHost", "1");
    }

    private List<User> getAllUsersWithParameter(String...args) throws SQLException {
        QueryBuilder queryBuilder = new QueryBuilder(getAllUsersQuery);
        queryBuilder.parse(args);

        try (Connection conn = DBUtils.getConnection()) {
            List<User> list = new LinkedList<>();

            String query = queryBuilder.getQuery();
            PreparedStatement stat = conn.prepareStatement(query);
            int i = 1;
            for (String value : queryBuilder.values()) {
                stat.setObject(i, value);
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
