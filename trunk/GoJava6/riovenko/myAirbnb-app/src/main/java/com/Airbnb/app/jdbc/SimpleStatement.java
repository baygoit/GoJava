package com.Airbnb.app.jdbc;

import java.sql.*;

/**
 * Created by romanroma on 18.10.15.
 */
public class SimpleStatement {
    public static void main(String[] args) throws SQLException {
        retrieve();
        //update();
    }

    private static void retrieve() throws SQLException {
        Connection connection = null;
        Statement stmt = null;
        String query = "select * from Users";

        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/Airbnb", "root", "");

            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String firstname = rs.getString("Name");
                String lastname = rs.getString("Surname");
                System.out.println("firstname: " + firstname + ", lastname: " + lastname);
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        } finally {
            connection.close();
        }
    }

    private static void update() throws SQLException {
        Connection connection = null;
        Statement stmt = null;
        String query = "update user set firstname = 'Jason'";

        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/airbnb", "root", "");

            stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            stmt.executeUpdate(query);

            /*while (rs.next()) {
                String firstname = rs.getString("firstname");
                rs.updateString("firstname", "Jason");
                rs.updateRow();
            }*/
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        } finally {
            connection.close();
        }
    }

    private static void insert() throws SQLException {
        Connection connection = null;
        Statement stmt = null;
        String query = "select * from user";

        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/airbnb", "root", "");

            stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(query);

            rs.moveToInsertRow();
            rs.updateString("firstname", "Brad");
            rs.updateString("lastname", "Pitt");
            rs.updateBoolean("type", false);
            rs.insertRow();

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        } finally {
            connection.close();
        }
    }
}
