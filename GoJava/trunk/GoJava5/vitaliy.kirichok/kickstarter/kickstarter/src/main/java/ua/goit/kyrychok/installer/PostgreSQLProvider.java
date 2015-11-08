package ua.goit.kyrychok.installer;

import org.postgresql.ds.PGPoolingDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class PostgreSQLProvider {
    private PGPoolingDataSource dataSource;
    private InstallerOutput output;

    public PostgreSQLProvider(InstallerOutput output) {
        this.output = output;
    }

    public void init(String serverName, int portNumber, String dbName, String user, String password) throws SQLException {
        this.init(serverName, portNumber, user, password);
        dataSource.setDatabaseName(dbName);
    }

    public void init(String serverName, int portNumber, String user, String password) throws SQLException {
        dataSource = new PGPoolingDataSource();
        dataSource.setServerName(serverName);
        dataSource.setPortNumber(portNumber);
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setMaxConnections(1);
    }

    public Connection getConnection() throws SQLException {
        Connection result = dataSource.getConnection();
        result.setAutoCommit(false);
        return result;
    }

    private String getConnectionName() {
        String result = String.join(":", dataSource.getServerName(), Integer.toString(dataSource.getPortNumber()),
                dataSource.getDatabaseName(), dataSource.getUser());
        return result;
    }

    public void testConnection() {
        String connectionName = getConnectionName();
        try (Connection connection = getConnection()) {
            output.writeLine(String.format("Test connection '%s' successful.", connectionName));
        } catch (SQLException e) {
            throw new RuntimeException(String.format("Test connection '%s' fail.", connectionName), e);
        }
    }

    public void close() {
        dataSource.close();
    }
}
