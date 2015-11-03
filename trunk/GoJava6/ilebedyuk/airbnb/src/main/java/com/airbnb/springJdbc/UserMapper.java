package com.airbnb.springJdbc;

import com.airbnb.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Игорь on 29.10.2015.
 */
public class UserMapper implements RowMapper<User>{

    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setUserId(resultSet.getInt("iduser"));
        user.setName(resultSet.getString("name"));
        user.setSurname(resultSet.getString("surname"));
        user.setEmail(resultSet.getString("email"));
        user.setCity(resultSet.getString("city"));
        user.setUserType(resultSet.getString("usertype"));
        return user;
    }
}
