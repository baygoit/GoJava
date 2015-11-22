package ua.com.goit.gojava7.kickstarter.dao.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

public class JdbcDispatcher {
    
    private BasicDataSource datasource;

    public JdbcDispatcher(String driver, String url, String user, String password)
            throws SQLException {
        
        datasource = new BasicDataSource();
        datasource.setDriverClassName(driver);
        datasource.setUrl(url);
        datasource.setUsername(user);
        datasource.setPassword(password);
    }

    public Connection getConnection() throws SQLException {
        Connection connection = datasource.getConnection();
        connection.setAutoCommit(false);
        return connection;
    }

    public void processException(SQLException ex) {
        printSQLException(ex);
    }

    public static void printSQLException(SQLException ex) {

        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                if (ignoreSQLException(((SQLException) e).getSQLState()) == false) {

                    System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                    System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                    System.err.println("Message: " + e.getMessage());

                    Throwable t = ex.getCause();
                    while (t != null) {
                        System.out.println("Cause: " + t);
                        t = t.getCause();
                    }
                }
            }
        }
    }

    public static boolean ignoreSQLException(String sqlState) {

        if (sqlState == null) {
            System.out.println("The SQL state is not defined!");
            return false;
        }

        // X0Y32: Jar file already exists in schema
        if (sqlState.equalsIgnoreCase("X0Y32"))
            return true;

        // 42Y55: Table already exists in schema
        if (sqlState.equalsIgnoreCase("42Y55"))
            return true;

        return false;
    }

}
