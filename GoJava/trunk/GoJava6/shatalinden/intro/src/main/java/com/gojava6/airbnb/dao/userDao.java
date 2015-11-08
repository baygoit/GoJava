package com.gojava6.airbnb.dao;

import com.gojava6.airbnb.persistence.PersistenceException;
import com.gojava6.airbnb.user.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public static List<User> pullAllUsers() {
        List<User> users = new ArrayList<>();
        String query = "select * from users";
        try (Connection connection = DbDao.initConnection()){
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(query);
            while (resultSet.next()) {
                users.add(createUser(resultSet));
            }
        } catch (PersistenceException | SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public static User pullUserByID(int id) {
        User user = null;
        try (Connection connection = DbDao.initConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()) {
                user = createUser(resultSet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public static User pullUserByEmail(String email) {
        User user = null;
        try (Connection connection = DbDao.initConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE email = ?");
            ps.setString(1, email);
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()) {
                user = createUser(resultSet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    private static User createUser(ResultSet resultSet) {
        User user = null;
        try {
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            String email = resultSet.getString("email");
            String password = resultSet.getString("password");
            int userType = resultSet.getInt("usertype");
            int id = resultSet.getInt("id");
            user = new User(name, surname, email, userType, id, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static void pushUser(User user) {
        try (Connection connection = DbDao.initConnection()) {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO users VALUES(?,?,?,?,?,?)");
            ps.setInt(1, user.getUserID());
            ps.setString(2, user.getName());
            ps.setString(3, user.getSurname());
            ps.setString(4, user.getEmail());
            ps.setBoolean(5, user.getBooleanUserType());
            ps.setString(6, user.getPassword());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateUser(int id, Boolean userType) {
        try (Connection connection = DbDao.initConnection()) {
            PreparedStatement ps = connection.prepareStatement("UPDATE users SET usertype=? WHERE id=?");
            ps.setBoolean(1, userType);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteUser(int id) {
        try (Connection connection = DbDao.initConnection()) {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM users WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}