package controller;

import java.sql.*;

public class ConnectionToDB {

    public Connection getConnection(String path, String name, String password) {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(path, name, password);
        } catch (Exception e) {
            new RuntimeException("Exception " + e);
        }
        return connection;
    }

}
