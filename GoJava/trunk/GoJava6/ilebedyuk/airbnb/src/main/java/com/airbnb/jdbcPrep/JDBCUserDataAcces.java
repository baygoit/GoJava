package com.airbnb.jdbcPrep;

import com.airbnb.dao.IUserDao;
import com.airbnb.model.User;
import com.airbnb.model.UserType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Игорь on 06.10.2015.
 */
public class JDBCUserDataAcces extends AbstractBaseDao implements IUserDao {
    private String sqlCode;

    @Override
    public List<User> getUserList() {
        List<User> users = new ArrayList<User>();
        sqlCode = "select * from user;";
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(sqlCode);
            List<Object> objects = objectsList();
            for (Object o : objects) {
                User user = (User) o;
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return users;
    }

    @Override
    public User getUser(int id) {
        User user = null;
        sqlCode = "select * from user where iduser = ?;";
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(sqlCode);
            stmt.setInt(1, id);
            user = (User) objectsList().get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return user;
    }

    @Override
    public void updateName(int id, String newName) {
        sqlCode = "update user set name = ? where iduser = ?;";
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(sqlCode);
            stmt.setString(1, newName);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        System.out.println("User with id: " + id + " is updated in DB");
    }

    @Override
    public void updateUserType(int id) {
        sqlCode = "update user set usertype = ? where iduser = ?;";
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(sqlCode);
            stmt.setString(1, String.valueOf(UserType.HOST));
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        System.out.println("User with id: " + id + " is became HOST");
    }

    @Override
    public void delete(int id) {
        sqlCode = "delete from user where iduser = ?;";
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(sqlCode);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("User with id = " + id + "is deleted from DB");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    @Override
    public void addToDb(User user) {
        sqlCode = "insert into user values(null, ?, ?, ?, ?, ?);";
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(sqlCode);
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getSurname());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getCity());
            stmt.setString(5, user.getUserType());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        System.out.println("User" + user.getName() + "is added to DB");
    }

    @Override
    User createObject(ResultSet resultSet) {
        User user = null;
        try {
            int userId = resultSet.getInt("iduser");
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            String email = resultSet.getString("email");
            String city = resultSet.getString("city");
            String userType = resultSet.getString("usertype");

            user = new User(name, surname, email, city, userType);
            user.setUserId(userId);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
