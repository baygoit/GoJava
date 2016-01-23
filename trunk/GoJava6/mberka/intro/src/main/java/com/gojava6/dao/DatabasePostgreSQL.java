package com.gojava6.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabasePostgreSQL {
    private static DatabasePostgreSQL dbInstance = new DatabasePostgreSQL();
    private Connection connection;

    private DatabasePostgreSQL() {
    }

    public static DatabasePostgreSQL getDbInstance() {
        return dbInstance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void connect() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found.");
            e.printStackTrace();
            return;
        }
        System.out.println("PostgreSQL JDBC Driver Registered!");
        Connection connection = null;
        try {
            connection = DriverManager
                    .getConnection("jdbc:postgresql://localhost:8080/postgres", "postgres", "postgress");
        } catch (SQLException e) {
            System.out.println("Connection failed, check output console.");
            e.printStackTrace();
            return;
        }
        if (connection != null) {
            System.out.println("You made it, take control your database now.");
        } else {
            System.out.println("Failed to make connection.");
        }
    }
}
