package goit.vh.kickstarter.dao;

/**
 * Created by Viktor on 01.08.2015.
 */
public abstract class DAOFactory {


    public static final int POSTGRESQL = 1;
    public static final int FILE = 2;
    public static final int INMEMORY = 3;


    public abstract CategoryDAO getCategoryDAO();

    public abstract ProjectDAO getProjectDAO();


    public static DAOFactory getDAOFactory(
            int whichFactory) {

        switch (whichFactory) {
            case POSTGRESQL:
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