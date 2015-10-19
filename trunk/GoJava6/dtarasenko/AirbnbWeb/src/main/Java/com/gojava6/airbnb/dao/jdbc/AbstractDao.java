package com.gojava6.airbnb.dao.jdbc;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDao {

    void updateDatabase(String sqlCode) {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = getDBConnection();
            statement = connection.createStatement();
            statement.executeUpdate(sqlCode);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    List<Object> readDatabase(String sqlCode) {
        List<Object> objectList = new ArrayList<Object>();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = getDBConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlCode);

            while (resultSet.next()) {
                Object object = createObject(resultSet);
                objectList.add(object);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return objectList;
    }

    private Connection getDBConnection() {
        Connection connection = null;
        DataSource dataSource = null;

        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            dataSource = (DataSource) envContext.lookup("jdbc/ResAirbnb");
        } catch (NamingException e) {
            System.out.println(e.getMessage());
        }
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    abstract Object createObject(ResultSet resultSet) throws SQLException;
}
