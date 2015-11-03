package com.airbnb.jdbcPrep;

import com.airbnb.dao.ISubscriberDao;
import com.airbnb.jdbcPrep.AbstractBaseDao;
import com.airbnb.model.User;
import com.airbnb.observer.Observer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Игорь on 11.10.2015.
 */
public class JDBCSubscribersDataAcces extends AbstractBaseDao implements ISubscriberDao {
    String sqlCode = null;

    @Override
    public List<Observer> getUserList() {
        List<Observer> observers = new ArrayList<Observer>();
        sqlCode = "SELECT user.* FROM observer join user on idobserver = iduser;";
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(sqlCode);
            List<Object> objects = objectsList();
            for (Object o : objects) {
                User user = (User) o;
                observers.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return observers;
    }

    @Override
    public Observer getUser(int id) {
        Observer observer = null;
        sqlCode = "SELECT user.* FROM user join observer on idobserver = iduser where idobserver = ?;";
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(sqlCode);
            stmt.setInt(1, id);
            observer = (Observer) objectsList().get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return observer;
    }

    @Override
    public void delete(int id) {
        sqlCode = "delete from observer where id = ?;";
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(sqlCode);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("User with id = " + id + " deleted succesfull");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    @Override
    public void addToDb(Observer observer) {
        User user = (User) observer;
        sqlCode = "insert into observer values(?);";
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(sqlCode);
            stmt.setInt(1, user.getUserId());
            System.out.println("User is added to DB");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
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
