package ua.goit.kyrychok.kickstarter.dao.database.datasource_provider;

import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;
import ua.goit.kyrychok.kickstarter.dao.database.DbDataSourceProvider;

import java.sql.Connection;
import java.sql.SQLException;

public class OraDbDataSourceProvider implements DbDataSourceProvider {
    private PoolDataSource dataSource;

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
        dataSource = PoolDataSourceFactory.getPoolDataSource();
        dataSource.setConnectionFactoryClassName("oracle.jdbc.pool.OracleDataSource");
        dataSource.setURL(url);
        dataSource.setUser(userName);
        dataSource.setPassword(userPassword);
        dataSource.setMaxPoolSize(5);
        testConnection();
    }
}
