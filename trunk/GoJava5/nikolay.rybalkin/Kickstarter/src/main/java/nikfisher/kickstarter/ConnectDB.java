package nikfisher.kickstarter;

import org.slf4j.LoggerFactory;

import java.sql.*;

public class ConnectDB {


    private final static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ConnectDB.class);

    private static final String DB_DRIVER = "org.sqlite.JDBC";
    private static final String DB_CONNECTION = "jdbc:sqlite:src/main/resources/kickstarter.db";
    private static final String DB_USER = "";
    private static final String DB_PASSWORD = "";

    public static Connection getDBConnection() {
        Connection dbConnection = null;
        try {
            Class.forName(DB_DRIVER);
            LOGGER.info("Successfully load DB driver");
        } catch (ClassNotFoundException e) {
            LOGGER.info("Error load DB driver");
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            LOGGER.info("Successfully connected to DB");
            return dbConnection;
        } catch (SQLException e) {
            LOGGER.info("Error connect to DB");
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }
}

