package goit.vh.kickstarter.dao;


import org.postgresql.ds.PGPoolingDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Viktor on 01.08.2015.
 */
public class PostgreSQLDAOFactory extends DAOFactory {

    @Override
    public CategoryDAO getCategoryDAO() {
        return new CategoryPostgreSQLDAO();
    }

    @Override
    public ProjectDAO getProjectDAO() {
        return null;
    }
}
