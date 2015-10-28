package com.db;

import java.sql.Connection;
import java.sql.*;

/**
 * Created by Игорь on 02.10.2015.
 */
public class JDBCExample {
    // JDBC driver name and database URL
    //static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/USER";

    //Database credentials
    static final String USER = "root";
    static final String PASS = "root";

    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        Statement stmt = null;

        try {
            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connection is successful");

            //Register JDBC Driver
            //Class.forName("com.mysql.jdbc.Driver");

            //Open a connection
            //System.out.println("Creating database..");
            stmt = conn.createStatement();
//            String sql = "CREATE TABLE USER_TABLE" +
//                    "(id int AUTO_INCREMENT primary key," +
//                    "name char(25)," +
//                    "surname char(25)," +
//                    "city char(25))";
//            String sql1 = "INSERT INTO USER_TABLE VALUES" +
//                    "(1, 'Vasya', 'Kytr', 'Kiev')";
//            String sql2 = "INSERT INTO USER_TABLE(NAME, SURNAME, CITY) VALUES" +
//                    "('Petro', 'Dfgt', 'Kiev')";
            //stmt.executeUpdate(sql);
            String sql = "SELECT * FROM USER_TABLE";
            //stmt.executeUpdate(sql);
            //stmt.executeUpdate(sql2);
            //System.out.println("Table is created");
            ResultSet rs = stmt.executeQuery(sql);

                int id = rs.getInt(1);
                String name = rs.getString(2);
                String surname = rs.getString(3);
                String city = rs.getString(4);

                System.out.print("id = " + id);
                System.out.print(", name = " + name);
                System.out.print(", surname = " + surname);
                System.out.println(", city = " + city);

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            stmt.close();
            conn.close();
        }
    }
}
