package goit.vh.kickstarter.dao;

import java.sql.SQLException;

/**
 * Created by Viktor on 01.08.2015.
 */
public abstract class DAOFactory {


    public static final int POSTGRESQL = 1;
    public static final int FILE = 2;
    public static final int INMEMORY = 3;

    private static final String URL = "jdbc\\:postgresql\\://localhost\\:5432/kickstarter";
    private static final String USERNAME = "1";
    private static final String PASSWORD = "1";

    public abstract CategoryDAO getCategoryDAO();

    public abstract ProjectDAO getProjectDAO();


    public static DAOFactory getDAOFactory(
            int whichFactory) {

        switch (whichFactory) {
            case POSTGRESQL:
                try {
                    PGConnectionPool pgConnectionPool = new PGConnectionPool();
                    pgConnectionPool.init(URL, USERNAME, PASSWORD);

                } catch (SQLException e) {
                    throw new RuntimeException("Can't initialize database", e);
                }
                return new PostgreSQLDAOFactory();
            case FILE:
                return new FileDAOFactory();
            case INMEMORY:
                return new InMemoryDAOFactory();
            default:
                return null;
        }
    }
}