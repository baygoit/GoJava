package main.java.jdbc;

import java.sql.*;
import java.sql.SQLException;

/**
 * @autor A_Nakonechnyi
 * @date 14.10.2015.
 */
public class testSttmnt {
    public static void main(String[] args) throws SQLException {
        insert();
        //retrieve();
        //update();
    }

    private static void retrieve() throws SQLException {
        Connection connection = null;
        Statement stmt = null;
        String query = "select * from users";

        try {
            connection = DriverManager
                    .getConnection("main.Java.jdbc:mysql://localhost:3306/airbnb", "root", "polipoli");

            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String name = rs.getString("name");
                String serName = rs.getString("ser_name");
                System.out.println("name: " + name + ", serName: " + serName);
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
        String query = "update users set name = 'Jason'";

        try {
            connection = DriverManager
                    .getConnection("main.Java.jdbc:mysql://localhost:3306/airbnb", "root", "polipoli");

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
        String query = "select * from users";

        try {
            connection = DriverManager
                    .getConnection("main.Java.jdbc:mysql://localhost:3306/airbnb", "root", "polipoli");

            stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(query);

            rs.moveToInsertRow();
            rs.updateString("name", "Brad");
            rs.updateString("ser_name", "Pitt");
            rs.updateString("email", "BPitt@mail");
            rs.updateBoolean("is_host", false);
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
