package kickstarter.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPoolImpl implements ConnectionPool {
	private static final String SQL_URL = "jdbc:postgresql://localhost:5433/kickstarter";
	private static final String SQL_USER = "postgres";
	private static final String SQL_PASSWORD = "111";

	private Connection connection;

	public ConnectionPoolImpl() throws SQLException {
		this.connection = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD);
	}

	@Override
	public Connection getConnection() {
		return connection;
	}

	@Override
	public void close() throws Exception {
		connection.close();
	}
}
