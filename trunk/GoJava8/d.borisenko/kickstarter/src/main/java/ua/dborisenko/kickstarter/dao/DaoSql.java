package ua.dborisenko.kickstarter.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbcp2.BasicDataSource;

public abstract class DaoSql {
    private static final String JDBC_DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
    private static final String JDBC_CONNECTION_STRING = "jdbc:mysql://172.21.6.128:3306/kickstarter?user=kickstarter&password=123&useSSL=false";
    private static final int MAX_CONNECTIONS_COUNT = 5;
    private BasicDataSource connectionPool;

    public DaoSql() {
        initPool();
    }

    private void initPool() {
        connectionPool = new BasicDataSource();
        connectionPool.setDriverClassName(JDBC_DRIVER_CLASS_NAME);
        connectionPool.setUrl(JDBC_CONNECTION_STRING);
        connectionPool.setInitialSize(MAX_CONNECTIONS_COUNT);
    }

    Connection getConnection() throws SQLException {
        return connectionPool.getConnection();
    }

    public void closePool() throws SQLException {
        connectionPool.close();
    }

    protected void closeStatement(Statement statement) throws SQLException {
        if (statement != null && !(statement.isClosed())) {
            statement.close();
        }
    }
}
