package goit.vh.kickstarter.dao;

import java.sql.Connection;

/**
 * Created by Viktor on 01.08.2015.
 */
public class PostgreSQLDAOFactory extends DAOFactory {
    public static final String DRIVER=
            "COM.cloudscape.core.RmiJdbcDriver";
    public static final String DBURL=
            "jdbc:cloudscape:rmi://localhost:1099/CoreJ2EEDB";

    // метод для создания соединений к Cloudscape
    public static  Connection createConnection() {
        // Использовать DRIVER и DBURL для создания соединения
        // Рекомендовать реализацию/использование пула соединений
        return null;
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
