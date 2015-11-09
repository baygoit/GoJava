package jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by root on 27.10.15.
 */
public class DBHelper {

    static final String DB_URL = "jdbc:mysql://localhost/Shop";

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
