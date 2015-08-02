package goit.vh.kickstarter.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Viktor on 01.08.2015.
 */
public class PostgreSQLDAOFactory extends DAOFactory {


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
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/kickstarter", "1", "1");
            if (connection != null)
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
