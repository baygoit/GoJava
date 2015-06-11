package edu.kickstarter.database;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DatabaseService {

	private static Connection connection;
	private volatile static DatabaseService uniqueInstance;
	private volatile DataSource ds = null;

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

	public synchronized Connection getConnection() throws KickstarterException {
		try {
			if (ds == null) {
				InitialContext initCtx = new InitialContext();
				ds = (DataSource) initCtx
						.lookup("java:comp/env/jdbc/kickstarter");
			}
			connection = ds.getConnection();
		} catch (SQLException | NamingException e) {
			ds = null;
			throw new KickstarterException("Exception", e);
		}
		return connection;
	}

	public synchronized void closeConnection() throws SQLException {
		connection.close();
	}
}
