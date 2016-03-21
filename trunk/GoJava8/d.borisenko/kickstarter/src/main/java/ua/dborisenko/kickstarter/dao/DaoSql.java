package ua.dborisenko.kickstarter.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DaoSql {
    private static final int CONN_MAX_TRIES_COUNT = 3;
    protected Connection connection;
    private String connectionString = "jdbc:mysql://172.21.6.128:3306/kickstarter?user=kickstarter&password=123&useSSL=false";

    Connection getConnection() {
        for (int i = 1; i <= CONN_MAX_TRIES_COUNT && connection == null; i++) {
            try {
                connection = DriverManager.getConnection(connectionString);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
