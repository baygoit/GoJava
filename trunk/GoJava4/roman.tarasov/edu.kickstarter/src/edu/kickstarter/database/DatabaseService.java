package edu.kickstarter.database;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

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
			Context initCtx = new InitialContext();
			DataSource ds = (DataSource) initCtx
					.lookup("java:comp/env/jdbc/kickstarter");
			connection = ds.getConnection();
			return connection;
		} catch (SQLException | NamingException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void closeConnection() throws SQLException {
		connection.close();
	}
}
