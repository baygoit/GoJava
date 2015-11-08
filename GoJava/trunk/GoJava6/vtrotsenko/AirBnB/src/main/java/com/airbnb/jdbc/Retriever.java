package com.airbnb.jdbc;

import com.airbnb.system.Log;

import java.sql.*;

/**
 * Created by root on 11.10.15.
 */
public class Retriever {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/AirBnB";

    // Database credentials
    static final String USER = "root";
    static final String PASSWORD = "301214vt";

    public static void main(String[] args) throws SQLException {

        Connection connection = null;
        Statement statement = null;

        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // STEP 2: Create the connection object (open a connection)
            Log.logger.info("Connecting to database ...");
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // STEP 3: Create the Statement object
            Log.logger.info("Creating database ...");
            statement = connection.createStatement();

            // STEP 4: Execute the query
            String query = "select * from User";
            Log.logger.info("Query executed ...");

            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                String firstname = rs.getString("name");
                String lastname = rs.getString("surname");
                System.out.println("firstname: " + firstname + ", lastname: " + lastname);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            // STEP 5: Close the connection
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        Log.logger.info("Goodbye!");

    }

}
