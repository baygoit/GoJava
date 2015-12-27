package com.gojava6.dao;

/*Singleton pattern.*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseMySQL {
    private Connection connection;

    private static DatabaseMySQL dbInstance = new DatabaseMySQL();

    private DatabaseMySQL() {

    }

    public static DatabaseMySQL getDbInstance() {
        return dbInstance;
    }

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found.");
            e.printStackTrace();
        }
        System.out.println("MySQL JDBC Driver Registered!");
        Connection connection = null;
        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/airbnb", "root", "root");
        } catch (SQLException e) {
            System.out.println("Connection failed, check output console.");
            e.printStackTrace();
        }
        if (connection != null) {
            System.out.println("You made it, take control your database now.");
        } else {
            System.out.println("Failed to make connection.");
        }
        return connection;
    }

}

