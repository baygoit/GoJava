package com.gojava6.airbnb.dao.jdbc;

import com.gojava6.airbnb.dao.IUserDao;
import com.gojava6.airbnb.model.User;

import java.sql.*;
import java.util.List;

public class UserDao extends AbstractDao implements IUserDao {

    public void createUser(User user) {
        String sqlCode = "INSERT INTO user VALUES (null, '" +
                user.getName() + "', '" +
                user.getSurname() + "', '" +
                user.getEmail() + "', '" +
                user.getUserType() + "')";
        updateDatabase(sqlCode);
    }

    public void updateUser(User user) {
        String sqlCode = "UPDATE user SET name = '" +
                user.getName() + "', surname = '" +
                user.getSurname() + "', email = '" +
                user.getEmail() + "', user_type = '" +
                user.getUserType() + "' WHERE user_id = " +
                user.getUserId();
        updateDatabase(sqlCode);
    }

    public void deleteUser(User user) {
        String sqlCode = "DELETE FROM user WHERE user_id = " + user.getUserId();
        updateDatabase(sqlCode);
    }

    public List<User> getUserList() {
        String sqlCode = "SELECT * FROM user";
        return (List<User>)(List<?>) readDatabase(sqlCode);
    }

    public User getUser(Integer userId) {
        String sqlCode = "SELECT * FROM user WHERE user_id =" + userId;
        List<User> userList = (List<User>)(List<?>) readDatabase(sqlCode);
        return userList.get(0);
    }

    @Override
    User createObject(ResultSet resultSet) throws SQLException {
        int userId = resultSet.getInt("user_id");
        String name = resultSet.getString("name");
        String surname = resultSet.getString("surname");
        String email = resultSet.getString("email");
        String userType = resultSet.getString("user_type");

        User user = new User();
        user.setUserId(userId);
        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
        user.setUserType(userType);

        return user;
    }

}
