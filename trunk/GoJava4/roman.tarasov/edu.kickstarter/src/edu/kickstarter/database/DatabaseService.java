package edu.kickstarter.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseService {

	private static Connection connection;
	private volatile static DatabaseService uniqueInstance;

	private DatabaseService() {
	}

	public static DatabaseService getInstance() {
		if (uniqueInstance == null) {
			synchronized (DatabaseService.class) {
				if (uniqueInstance == null) {
					uniqueInstance = new DatabaseService();
				}
			}
		}
		return uniqueInstance;
	}

	public Connection getConnection() {
		try {
			if (connection != null) {
				if (!connection.isClosed()) {
					return connection;
				}
			}
			connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/kickstarter", "postgres",
					"root");
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void closeConnection() throws SQLException {
		connection.close();
	}
}
