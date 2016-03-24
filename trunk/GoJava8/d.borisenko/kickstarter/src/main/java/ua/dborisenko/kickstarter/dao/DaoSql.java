package ua.dborisenko.kickstarter.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DaoSql {
    private static final int CONN_MAX_TRIES_COUNT = 3;
    private static final String CONNECTION_STRING = "jdbc:mysql://172.21.6.128:3306/kickstarter?user=kickstarter&password=123&useSSL=false";
    private Connection connection;

    Connection getConnection() throws SQLException {
        for (int i = 1; i <= CONN_MAX_TRIES_COUNT && (connection == null || connection.isClosed()); i++) {
            try {
                connection = DriverManager.getConnection(CONNECTION_STRING);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public void closeConnection() throws SQLException {
        if (!(connection == null || connection.isClosed())) {
            connection.close();
        }
    }
}
