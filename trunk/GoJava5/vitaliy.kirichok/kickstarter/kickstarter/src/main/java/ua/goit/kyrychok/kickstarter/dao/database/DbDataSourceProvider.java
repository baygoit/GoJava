package ua.goit.kyrychok.kickstarter.dao.database;

import java.sql.Connection;
import java.sql.SQLException;

public interface DbDataSourceProvider {

    Connection getConnection() throws SQLException;
}
