package ua.goit.kyrychok.installer;

import java.sql.*;

public class StepDatabase extends AbstractStep {

    public StepDatabase(InstallerOutput output, PostgreSQLProvider dataSource) {
        super(output, dataSource);
    }

    public boolean ifExsists(String dbName) throws SQLException {
        boolean result = false;
        String sql = "select 1 as result from pg_database where datname = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, dbName);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result = resultSet.getInt("result") == 1;
                break;
            }
            connection.commit();
        }
        return result;
    }

    public void createDatabase(String dbName, String ownerName) throws SQLException {
        if (!ifExsists(dbName)) {
            String sql = "create database " + dbName + " with owner = " + ownerName;
            try (Connection connection = dataSource.getConnection();
                 Statement statement = connection.createStatement()) {
                statement.execute(sql);
                output.writeLine(String.format("Database '%s' created", dbName));
                connection.commit();
            }
        } else {
            output.writeLine(String.format("Database '%s' exists", dbName));
        }
    }
}
