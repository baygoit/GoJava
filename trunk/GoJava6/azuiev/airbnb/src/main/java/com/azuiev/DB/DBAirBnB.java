package com.azuiev.DB;

import com.azuiev.User.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 06.10.15.
 */
public class DBAirBnB {

    // JDBC URL, username and password of MySQL server
    private static final String url = "jdbc:mysql://localhost:3306/airbnb";
    private static final String user = "root";
    private static final String password = "masta";

    // JDBC variables for opening and managing connection
    private static Connection con = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;


   public void addUser(User user){

        if (!isDuplicate(user.getEmail())) {
            String query = "insert into user values (null, '" + user.getName() + "', '" + user.getSurName() + "', '" + user.getEmail()+"')";
            insert(query);
        } else {
            System.out.println("email already used: "+ user.getEmail());
        }

    }

    private boolean isDuplicate(String email) {
        String query = "select count(*) from user where email = '" + email+"'";
        ResultSet rs = select(query);
        try {
            if (rs.next()){
                 if (rs.getInt(1) == 1)
                     return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    private void close(){
        try {
            stmt.close();
            con.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    private void connect() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);
            // getting Statement object to execute query
            stmt = con.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public boolean insert(String query) {
        if(stmt==null){
            connect();
        }
        boolean isAdd = false;
        try {
            isAdd = stmt.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isAdd;
    }

    public ResultSet select(String query) {
        if(stmt==null){
            connect();
        }
        try {
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
