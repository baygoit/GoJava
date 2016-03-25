package com.vladik.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
    public static final String DATABASE_URL = "jdbc:mysql://localhost/Kickstarter";
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "";
    private static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(DATABASE_URL, USER_NAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public ConnectionProvider() {
    }

    public static Connection getConnection() {
        return connection;
    }
}
