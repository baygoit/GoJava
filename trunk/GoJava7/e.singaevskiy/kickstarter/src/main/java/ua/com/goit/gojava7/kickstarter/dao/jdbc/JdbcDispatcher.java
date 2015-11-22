package ua.com.goit.gojava7.kickstarter.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class JdbcDispatcher {

    protected Connection connection;
    protected PreparedStatement preparedStatement;
    protected Statement statement;

    public JdbcDispatcher(Connection connection) {
        this.connection = connection;
    }

    protected abstract void executeStatement() throws SQLException;

    public void execute() {
        try {

            connection.setAutoCommit(false);

            executeStatement();

            if (statement != null) {
                statement.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }

            connection.commit();
            connection.setAutoCommit(true);

        } catch (SQLException e) {
            printSQLException(e);
            if (connection != null) {
                try {
                    System.err.print("Transaction is being rolled back");
                    connection.rollback();
                } catch (SQLException excep) {
                    printSQLException(excep);
                }
            }
        }
    }
    
    public static void printSQLException(SQLException ex) {

        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                if (ignoreSQLException(((SQLException) e).getSQLState()) == false) {

                    //e.printStackTrace(System.err);
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
