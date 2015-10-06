package com.azuiev.DB;

import com.azuiev.User.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 06.10.15.
 */
public class DBAirBnB {
    private enum Types {UPDATE, INSERT, SELECT};
    // JDBC URL, username and password of MySQL server
    private static final String url = "jdbc:mysql://localhost:3306/airbnb";
    private static final String user = "root";
    private static final String password = "masta";

    // JDBC variables for opening and managing connection
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public List<User> selectUser(){
        String query = "select * from user";
        ResultSet rs = execute(Types.SELECT, query);
        List<User> list = new ArrayList<User>();
        try {
            while (rs.next()){
                User.Builder builder = User.createBuilder();
                User user = builder.createUser(rs.getString(2), rs.getString(3), rs.getString(4));
                list.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }

        return list;
    }

    public void addUser(User user){
        if (!isDuplicate(user.getEmail())) {
            String query = "insert into user values (null, '" + user.getName() + "', '" + user.getSurName() + "', '" + user.getEmail()+"')";
            execute(Types.INSERT, query);
        } else {
            System.out.println("email already used: "+ user.getEmail());
        }

    }

    private boolean isDuplicate(String email) {
        String query = "select count(*) from user where email = '" + email+"'";
        ResultSet rs = execute(Types.SELECT,query);
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
    private void connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        // opening database connection to MySQL server
        con = DriverManager.getConnection(url, user, password);
        // getting Statement object to execute query
        stmt = con.createStatement();
    }
    private ResultSet execute(Types type, String query) {

        try {
            connect();
            if(type != Types.SELECT) {
                stmt.executeUpdate(query);
            }
            if(type == Types.SELECT){
                rs = stmt.executeQuery(query);
            }
            return rs;

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return rs;


    }

}
