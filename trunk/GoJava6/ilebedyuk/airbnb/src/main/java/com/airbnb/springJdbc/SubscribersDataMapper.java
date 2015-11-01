package com.airbnb.springJdbc;

import com.airbnb.model.User;
import com.airbnb.observer.Observer;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Игорь on 29.10.2015.
 */
public class SubscribersDataMapper implements RowMapper<Observer> {
    public Observer mapRow(ResultSet resultSet, int i) throws SQLException {
        User observer = new User();
        observer.setUserId(resultSet.getInt("idobserver"));
        return observer;
    }
}
