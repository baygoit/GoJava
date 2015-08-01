package goit.vh.kickstarter.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Viktor on 01.08.2015.
 */
public class PostgreSQLDAOFactory extends DAOFactory {
    public static void main(String[] argv) {

        // метод для создания соединений к Cloudscape
        // public static Connection createConnection() {

        Connection connection = null;
        System.out.println("-------- PostgreSQL "
                + "JDBC Connection Testing ------------");

        try {

            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {

            System.out.println("Where is your PostgreSQL JDBC Driver? "
                    + "Include in your library path!");
            e.printStackTrace();
           // return null;

        }

        System.out.println("PostgreSQL JDBC Driver Registered!");


        try {

            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost/test?user=1&password=1");

        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            // return null;


        }


    }
    @Override
    public CategoryDAO getCategoryDAO() {
        return new PostgreSQLDAO();
    }

    @Override
    public ProjectDAO getProjectDAO() {
        return null;
    }
}
