package com.gojava6.airbnb.dao;

import com.gojava6.airbnb.persistence.PersistenceException;
import com.gojava6.airbnb.user.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class userDao  {

    public static List<User> pullAllUsers() {
        List<User> users = new ArrayList<>();
        String query = "select * from users";
        try (Connection connection = dbDao.initConnection()){
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
        try (Connection connection = dbDao.initConnection()) {
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

    private static User createUser(ResultSet resultSet) {
        User user = null;
        try {
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            String email = resultSet.getString("email");
            int userType = resultSet.getInt("usertype");
            int id = resultSet.getInt("id");
            user = new User(name, surname, email, userType, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static void pushUser(User user) {
        try (Connection connection = dbDao.initConnection()) {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO users VALUES(?,?,?,?,?)");
            ps.setInt(1, user.getUserID());
            ps.setString(2, user.getName());
            ps.setString(3, user.getSurname());
            ps.setString(4, user.getEmail());
            ps.setBoolean(5, user.getBooleanUserType());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void pushUser(String name, String surname, String email) {
        try (Connection connection = dbDao.initConnection()) {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO users VALUES(?,?,?,?,?)");
            ps.setInt(1, 0);
            ps.setString(2, name);
            ps.setString(3, surname);
            ps.setString(4, email);
            ps.setBoolean(5, false);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateUser(int id, Boolean userType) {
        try (Connection connection = dbDao.initConnection()) {
            PreparedStatement ps = connection.prepareStatement("UPDATE users SET usertype=? WHERE id=?");
            ps.setBoolean(1, userType);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteUser(int id) {
        try (Connection connection = dbDao.initConnection()) {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM users WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}