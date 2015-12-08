package ua.com.goit.gojava7.kickstarter.config;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

public class DBConnectionManager {
	private BasicDataSource datasource;

	public DBConnectionManager(String driver, String url, String user, String password) throws SQLException {

		try {
			Class.forName(driver);
			Class.forName("org.apache.commons.dbcp2.BasicDataSource");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException(e.getMessage());
		}

		datasource = new BasicDataSource();
		datasource.setDriverClassName(driver);
		datasource.setUrl(url);
		datasource.setUsername(user);
		datasource.setPassword(password);
	}

	public Connection getConnection() throws SQLException {
		Connection connection = datasource.getConnection();
		//connection.setAutoCommit(false);
		return connection;
	}

	public void close() {
		try {
			if (datasource != null && !datasource.isClosed()) {
				datasource.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
