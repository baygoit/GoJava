package com.gojava6.differenttasks.mysqltest;

import com.gojava6.differenttasks.SomeObject;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * @Autor Andrey Chaykin
 * @Since 15.10.2015
 */

public class MySqlTestDB {

    private static final String URL = "jdbc:mysql://localhost:3306/USER";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {

        SomeObject user = new SomeObject(10, "Dartanian", "Silikonovych", "Guatemala");

        try {
            List<SomeObject> linkList = getListObj();

            for (SomeObject someObject : linkList) {
                System.out.println(someObject);
            }
        } catch (SQLException e) {
            System.out.println("NO CONNECTION");
            e.printStackTrace();
        }

        try {
            putNewObjectInDB(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        try {
            List<SomeObject> linkList = getListObj();

            for (SomeObject someObject : linkList) {
                System.out.println(someObject);
            }
        } catch (SQLException e) {
            System.out.println("NO CONNECTION");
            e.printStackTrace();
        }

        try {
            deleteObjectInDB(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            List<SomeObject> linkList = getListObj();

            for (SomeObject someObject : linkList) {
                System.out.println(someObject);
            }
        } catch (SQLException e) {
            System.out.println("NO CONNECTION");
            e.printStackTrace();
        }

    }

    public static List<SomeObject> getListObj() throws SQLException {
        String query = "select * from user_table";
        List<SomeObject> linkList = new LinkedList<SomeObject>();

        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        ResultSet resultSet = null;
        Statement statement;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String city = resultSet.getString("city");

                SomeObject smObjid = new SomeObject(id, name, surname, city);

                linkList.add(smObjid);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return linkList;
    }

    public static void putNewObjectInDB(SomeObject user) throws SQLException {
        String query = "INSERT INTO user_table (name, surname, city) VALUES " + "('" + user.getName() + "', '" +
                user.getSurname() + "', '" + user.getCity() + "');";

        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        ResultSet resultSet = null;
        Statement statement;

        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (connection != connection) {
                    connection.close();
                }
            } catch (SQLException e) {

            }
        }
    }

    public static void deleteObjectInDB(SomeObject user) throws SQLException {
        String query = "DELETE FROM user_table WHERE name = '" + user.getName() + "';";

        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        ResultSet resultSet = null;
        Statement statement;

        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
