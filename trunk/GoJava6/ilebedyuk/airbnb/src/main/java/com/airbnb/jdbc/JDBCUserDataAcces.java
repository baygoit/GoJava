package com.airbnb.jdbc;

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
    private String sqlCode = null;

    @Override
    public List<User> getUserList() {
        List<User> users = new ArrayList<User>();
        sqlCode = "select * from user;";
        List<Object> objects = objectsList(sqlCode);
        for (Object o : objects) {
            User user = (User) o;
            users.add(user);
        }
        return users;
    }

    @Override
    public User getUser(int id) {
        sqlCode = "select * from user where iduser = " + id + ";";
        User user = (User) objectsList(sqlCode).get(0);
        System.out.println(user);
        return user;
    }

    @Override
    public void updateName(int id, String newName) {
        sqlCode = "update user set name = '" + newName + "' where iduser = " + id + ";";
        updateData(sqlCode);
        System.out.println("User with id: " + id + " is updated in DB");
    }

    @Override
    public void updateUserType(int id) {
        sqlCode = "update user set usertype = '" + UserType.HOST + "' where iduser = " + id + ";";
        updateData(sqlCode);
        System.out.println("User with id: " + id + " is became HOST");
    }

    @Override
    public void delete(int id) {
        sqlCode = "delete from user where iduser = " + id + ";";
        updateData(sqlCode);
        System.out.println("User with id = " + id + "is deleted from DB");
    }

    @Override
    public void addToDb(User user) {
        sqlCode = "insert into user values(null, '" +
                user.getName() + "', '" +
                user.getSurname() + "', '" +
                user.getEmail() + "', '" +
                user.getCity() + "', '" +
                user.getUserType() + "');";
        updateData(sqlCode);
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
