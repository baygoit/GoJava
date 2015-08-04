package goit.vh.kickstarter.dao;

import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Viktor on 01.08.2015.
 */
public class PostgreSQLDAOFactory extends DAOFactory {

    private static final String URL = "jdbc:postgresql://localhost:5432/kickstarter";
    private static final String USERNAME = "1";
    private static final String PASSWORD = "1";

    public static Connection createConnection() {

        Connection connection = null;
        System.out.println("-------- PostgreSQL "
                + "JDBC Connection Testing ------------");

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your PostgreSQL JDBC Driver? "
                    + "Include in your library path!");
            e.printStackTrace();
            return null;
        }

        System.out.println("PostgreSQL JDBC Driver Registered!");

        try {
//            Driver driver =  new Driver();
//            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (!connection.isClosed())
                System.out.println("Connected!");
            return connection;
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public CategoryDAO getCategoryDAO() {
        return new CategoryPostgreSQLDAO(createConnection());
    }

    @Override
    public ProjectDAO getProjectDAO() {
        return null;
    }
}
