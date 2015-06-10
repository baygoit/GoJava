package edu.kickstarter.databaseDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseService {

	private static Connection connection;
	private volatile static DatabaseService uniqueInstance;

	private DatabaseService() {
	}

	public static synchronized DatabaseService getInstance() {
		if (uniqueInstance == null) {
			try {
				uniqueInstance = new DatabaseService();
				connection = DriverManager.getConnection(
						"jdbc:postgresql://localhost:5432/kickstarter",
						"postgres", "root");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return uniqueInstance;
	}

	public Connection getConnection() {
		return connection;
	}

	public void closeConnection() throws SQLException {
		connection.close();
	}
}
