package ua.dborisenko.kickstarter.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DaoSql {

    private static final String JDBC_CONN_STRING = "jdbc:mysql://172.21.6.128:3306/kickstarter?user=kickstarter&password=123&useSSL=false";
    private static final int CONN_MAX_TRIES_COUNT = 3;
    protected Connection connection;

    public DaoSql() {
        checkConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeQuery("SELECT 1");
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    void checkConnection() {
        for (int i = 1; i <= CONN_MAX_TRIES_COUNT && connection == null; i++) {
            try {
                connection = DriverManager.getConnection(JDBC_CONN_STRING);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    protected ResultSet executeQuery(String query) throws SQLException {
        checkConnection();
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    protected int executeUpdate(String query) throws SQLException {
        checkConnection();
        Statement statement = connection.createStatement();
        return statement.executeUpdate(query);
    }
}
