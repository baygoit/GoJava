package com.donishchenko.airbnb.dao.old;

import com.donishchenko.airbnb.dao.UserDao;
import com.donishchenko.airbnb.dbutils.JdbcUtils;
import com.donishchenko.airbnb.dbutils.QueryBuilder;
import com.donishchenko.airbnb.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserJdbcDao implements UserDao {
    private static final String saveUserQuery =
            "INSERT INTO user VALUES(null, ?, ?, ?, ?, ?, ?)";

    private static final String deleteUserQuery =
            "DELETE FROM user WHERE id = ?";

    private static final String getUserByIdQuery =
            "SELECT * FROM user WHERE id = ?";

    private static final String getAllUsersQuery =
            "SELECT * FROM user";

    private static final String updateUserQuery =
            "UPDATE user SET login = ?, password = ?, email = ?, isHost = ?, name = ?, surname = ? WHERE id = ?";

    private static final String getUserByLoginPasswordQuery =
            "SELECT * FROM user WHERE login = ? and password = ?";

    @Override
    public void save(User user) {
        try (Connection conn = JdbcUtils.getConnection()) {
            PreparedStatement stat = conn.prepareStatement(saveUserQuery, Statement.RETURN_GENERATED_KEYS);
            stat.setString(1, user.getLogin());
            stat.setString(2, user.getPassword());
            stat.setString(3, user.getEmail());
            stat.setBoolean(4, user.isHost());
            stat.setString(5, user.getName());
            stat.setString(6, user.getSurname());

            stat.executeUpdate();

            ResultSet keys = stat.getGeneratedKeys();
            keys.next();
            user.setId(keys.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User get(Integer id) {
        User user = null;

        try (Connection conn = JdbcUtils.getConnection()) {
            PreparedStatement stat = conn.prepareStatement(getUserByIdQuery);
            stat.setInt(1, id);

            ResultSet result = stat.executeQuery();
            if (result.next()) {
                user = createUser(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public boolean update(User user) {
        boolean updated = false;

        try (Connection conn = JdbcUtils.getConnection()) {
            PreparedStatement stat = conn.prepareStatement(updateUserQuery);
            stat.setString(1, user.getLogin());
            stat.setString(2, user.getPassword());
            stat.setString(3, user.getEmail());
            stat.setBoolean(4, user.isHost());
            stat.setString(5, user.getName());
            stat.setString(6, user.getSurname());
            stat.setInt(7, user.getId());

            int affectedRows = stat.executeUpdate();

            updated = affectedRows != 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return updated;
    }

    @Override
    public boolean delete(Integer id) {
        boolean deleted = false;

        try (Connection conn = JdbcUtils.getConnection()) {
            PreparedStatement stat = conn.prepareStatement(deleteUserQuery);
            stat.setInt(1, id);

            int affectedRows = stat.executeUpdate();

            deleted = affectedRows != 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return deleted;
    }

    @Override
    public User getByLoginPassword(String login, String password) {
        User user = null;

        try (Connection conn = JdbcUtils.getConnection()) {
            PreparedStatement stat = conn.prepareStatement(getUserByLoginPasswordQuery);
            stat.setString(1, login);
            stat.setString(2, password);

            ResultSet result = stat.executeQuery();
            if (result.next()) {
                user = createUser(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return getAllUsersWithParameter();
    }

    @Override
    public List<User> getAllClients() {
        return getAllUsersWithParameter("isHost", "0");
    }

    @Override
    public List<User> getAllHosts() {
        return getAllUsersWithParameter("isHost", "1");
    }

    private List<User> getAllUsersWithParameter(Object...args) {
        List<User> list = Collections.emptyList();

        QueryBuilder queryBuilder = new QueryBuilder(getAllUsersQuery);
        queryBuilder.parseSql(args);

        try (Connection conn = JdbcUtils.getConnection()) {
            list = new ArrayList<>();

            String query = queryBuilder.getQuery();
            PreparedStatement stat = conn.prepareStatement(query);
            int i = 1;
            for (Object value : queryBuilder.values()) {
                stat.setObject(i++, value);
            }

            ResultSet result = stat.executeQuery();
            while (result.next()) {
                list.add(createUser(result));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    private User createUser(ResultSet result) throws SQLException {
        int id          = result.getInt(1);
        String login    = result.getString(2);
        String password = result.getString(3);
        String email    = result.getString(4);
        boolean isHost  = result.getBoolean(5);
        String name     = result.getString(6);
        String surname  = result.getString(7);

        User user = new User(login, password, email, isHost, name, surname);
        user.setId(id);

        return user;
    }
}
