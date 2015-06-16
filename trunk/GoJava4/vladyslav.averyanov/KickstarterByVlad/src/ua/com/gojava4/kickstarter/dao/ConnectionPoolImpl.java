package ua.com.gojava4.kickstarter.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPoolImpl implements ConnectionPool {
	private static final String SQL_URL = "jdbc:sqlite:resources/database.db";
	private static final String SQL_USER = "test";
	private static final String SQL_PASSWORD = "";

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

