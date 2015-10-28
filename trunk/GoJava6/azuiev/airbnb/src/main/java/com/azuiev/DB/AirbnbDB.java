package com.azuiev.db;

import com.azuiev.dao.DaoDB;

import java.sql.*;

/**
 * Created by Administrator on 06.10.15.
 */
public class AirbnbDB implements DaoDB {

    // JDBC URL, username and password of MySQL server
    private static final String url = "jdbc:mysql://localhost:3306/airbnb";
    private static final String user = "root";
    private static final String password = "masta";
    private static final String driver = "com.mysql.jdbc.Driver";


    // JDBC variables for opening and managing connection
    private static Connection connection = null;
    //private static Statement stmt = null;
    //private static ResultSet rs = null;

    @Override
    public Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return connection;
    }

    @Override
    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
