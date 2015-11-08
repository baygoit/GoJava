package com.airbnb.jdbcPrep;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Игорь on 11.10.2015.
 */
public abstract class AbstractBaseDao {

    private static final String url = "jdbc:mysql://localhost:3306/AIRBNB";
    private static final String name = "root";
    private static final String pass = "root";
    public static Connection conn = null;
    public PreparedStatement stmt;


    public static Connection  getConnection() throws SQLException {
        conn = DriverManager.getConnection(url, name, pass);
        System.out.println("Connect is succesfull");
        return conn;
    }

    public void closeConnection() {
        try {
            stmt.close();
            conn.close();
            System.out.println("Conn is close");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Object> objectsList() {
        List<Object> objects = new ArrayList<Object>();
        try {
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()){
                Object object = createObject(resultSet);
                objects.add(object);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return objects;
    }

    Object createObject(ResultSet resultSet){
        return null;
    }
}
