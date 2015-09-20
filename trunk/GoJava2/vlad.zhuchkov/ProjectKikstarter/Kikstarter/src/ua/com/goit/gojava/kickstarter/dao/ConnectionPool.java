package ua.com.goit.gojava.kickstarter.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPool {
	private Connection c;

	public ConnectionPool() {
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/kickstarter", "postgres",
					"admin");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Driver not found", e);
		} catch (SQLException e) {
			throw new RuntimeException("Something with SQL", e);
		}
	}

	public Connection getConnection() {
		return c;
	}

}
