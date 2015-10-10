package com.gojava6.airbnb.dao;

import com.gojava6.airbnb.model.User;
import com.gojava6.airbnb.model.UserType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDao extends AbstractDao {

    public void createUser(String name, String surname, String email, UserType userType) {
        String sqlCode = "INSERT INTO user VALUES (null, '"
                + name + "', '"
                + surname + "', '"
                + email + "', '"
                + userType.getUserType() + "')";
        updateDatabase(sqlCode);
    }

    public void deleteUser(Integer userId) {
        String sqlCode = "DELETE FROM user WHERE user_id = " + userId;
        updateDatabase(sqlCode);
    }

    public void updateUserTypeToHost(Integer userId) {
        String sqlCode = "UPDATE user SET user_type = 'host' WHERE user_id = " + userId;
        updateDatabase(sqlCode);
    }

    public Object getUser(Integer userId) {
        String sqlCode = "SELECT * FROM user WHERE user_id =" + userId;
        List<Object> userList = readDatabase(sqlCode);
        return userList.get(0);
    }

    public List<Object> getUserList() {
        String sqlCode = "SELECT * FROM user";
        return readDatabase(sqlCode);
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
