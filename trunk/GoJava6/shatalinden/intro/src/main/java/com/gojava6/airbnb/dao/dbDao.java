package com.gojava6.airbnb.dao;

import com.gojava6.airbnb.persistence.PersistenceException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbDao {

    private static Connection connection;

    public static Connection initConnection() throws PersistenceException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/airbnb", "root", "root");
        } catch (SQLException e) {
            throw new PersistenceException(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
