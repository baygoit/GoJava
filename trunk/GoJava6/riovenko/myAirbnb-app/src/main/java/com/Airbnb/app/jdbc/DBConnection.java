package com.Airbnb.app.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by romanroma on 18.10.15.
 */
public class DBConnection {
    private static String username = "root";
    private static String password = "";
    private static String url = "jdbc:mysql://localhost:3306/Airbnb";

    public static Connection getConnection () throws SQLException{
            return DriverManager.getConnection(url, username, password);
    }
}
