package nikfisher.kickstarter;

import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnectDB {


    private final static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ConnectDB.class);


    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Error loading JDBC driver! ", e);
        }
    }

    public ResultSet getResultSet(String tableName) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/kickstarter.db");
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);
        LOGGER.info("Connect DB.");
        return statement.executeQuery("SELECT * FROM " + tableName);
    }

    public static ConnectDB connectDB;



    public static void main(String[] args) throws SQLException {
        List<String> result = new ArrayList<>();

        ResultSet rs = connectDB.getResultSet("categories");

        while (rs.next()) {
            result.add(rs.getInt("id") + ") " + rs.getString("name"));
        }
    }


}
