package ua.nenya.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	private Connection connection;
	private String url = "jdbc:postgresql://127.0.0.1:5432/postgres";
	private String user = "postgres";
	private String password = "111111";

	private void openConnection() throws SQLException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		connection = DriverManager.getConnection(url, user, password);
	}

	public synchronized Connection getConnection() throws SQLException {
		if (connection == null || connection.isClosed()) {
			openConnection();
		}
		return connection;
	}

	
	public void closeConnection() throws SQLException {
		connection.close();
	}
}
