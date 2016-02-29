package com.shcherbak.processing;

import com.shcherbak.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper {
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setUserID(rs.getInt("id"));
        user.setType(rs.getBoolean("kind"));
        user.setFirstname(rs.getString("firstname"));
        user.setLastname(rs.getString("lastname"));
        user.setEmail(rs.getString("email"));
        user.setNotify(rs.getBoolean("notify"));
        user.setDate(rs.getDate("ts"));
        user.setPassword(rs.getString("password"));
        user.setLogin("login");
        return user;
    }
}