package com.airbnb.jdbc;

import java.sql.*;
import java.util.*;

/**
 * Created by Игорь on 11.10.2015.
 */
public abstract class AbstractBaseDao {

    private static final String url = "jdbc:mysql://localhost:3306/AIRBNB";
    private static final String name = "root";
    private static final String pass = "root";
    private Connection conn = null;
    private Statement stmt = null;

    private void getConnection() {
        try {
            conn = DriverManager.getConnection(url, name, pass);
            stmt = conn.createStatement();
            System.out.println("Connect is succesfull");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void closeConnection() {
        try {
            if (stmt != null || conn != null) {
                stmt.close();
                conn.close();
            } else return;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateData(String sqlCode){
        getConnection();
        try {
            stmt.executeUpdate(sqlCode);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public List<Object> objectsList(String sqlCode) {
        List<Object> objects = new ArrayList<Object>();
        getConnection();
        try {
            ResultSet resultSet = stmt.executeQuery(sqlCode);
            while (resultSet.next()){
                Object object = createObject(resultSet);
                objects.add(object);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return objects;
    }

    Object createObject(ResultSet resultSet){
        return null;
    }
}
