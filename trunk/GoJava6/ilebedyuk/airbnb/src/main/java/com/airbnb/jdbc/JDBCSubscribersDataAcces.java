package com.airbnb.jdbc;

import com.airbnb.dao.ISubscriberDao;
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
        List<Object> objects = objectsList(sqlCode);
        for (Object o : objects) {
            User user = (User) o;
            observers.add(user);
        }
        return observers;
    }

    @Override
    public Observer getUser(int id) {
        sqlCode = "SELECT user.* FROM user join observer on idobserver = iduser where idobserver = " + id + ";";
        Observer observer = (Observer) objectsList(sqlCode).get(0);
        return observer;
    }

    @Override
    public void delete(int id) {
        sqlCode = "delete from observer where id = " + id + ";";
        updateData(sqlCode);
        System.out.println("User with id = " + id + " deleted succesfull");
    }

    @Override
    public void addToDb(Observer observer) {
        User user = (User) observer;
        sqlCode = "insert into observer values(" + user.getUserId() + ");";
        updateData(sqlCode);
        System.out.println("User is added to DB");
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
