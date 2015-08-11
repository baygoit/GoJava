package ua.goit.kyrychok.kickstarter.dao.database.datasource_provider;

import org.postgresql.ds.PGPoolingDataSource;
import ua.goit.kyrychok.kickstarter.dao.database.DbDataSourceProvider;

import java.sql.Connection;
import java.sql.SQLException;

public class PsqlDataSourceProvider implements DbDataSourceProvider {
    private PGPoolingDataSource dataSource;

    @Override
    public Connection getConnection() throws SQLException {
        Connection result = dataSource.getConnection();
        result.setAutoCommit(false);
        return result;
    }

    private void testConnection() throws SQLException {
        Connection connection = null;
        try {
            connection = getConnection();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    public void init(String url, String userName, String userPassword) throws SQLException {
        dataSource = new PGPoolingDataSource();
        dataSource.setUrl(url);
        dataSource.setUser(userName);
        dataSource.setPassword(userPassword);
        dataSource.setMaxConnections(5);
        testConnection();
    }
}
