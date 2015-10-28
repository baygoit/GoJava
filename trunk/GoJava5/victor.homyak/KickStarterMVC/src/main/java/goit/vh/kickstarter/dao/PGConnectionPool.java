package goit.vh.kickstarter.dao;

import org.postgresql.ds.PGPoolingDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Viktor on 13.08.2015.
 */
public   class PGConnectionPool {
    private static  PGPoolingDataSource dataSource;
    public static Connection getConnection() {

        Connection result = null;
        try {
            result = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
//TODO remoove url.
    public   void init(String url, String userName, String userPassword) throws SQLException {
        dataSource = new PGPoolingDataSource();
        dataSource.setDataSourceName("A Data Source");
        dataSource.setServerName("localhost");
        dataSource.setDatabaseName("kickstarter");
        dataSource.setUser(userName);
        dataSource.setPassword(userPassword);
        dataSource.setMaxConnections(10);

    }
}
