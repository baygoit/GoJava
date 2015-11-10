package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by root on 04.11.15.
 */
public class ConnectorDB {
    static final String DB_URL = "jdbc:mysql://localhost/AirBnB";

    // Database credentials
    static final String USER = "root";
    static final String PASSWORD = "301214vt";
    private Connection connection = null;

    public Connection getConnection() {
        try {
            connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void closeConnection() {

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
