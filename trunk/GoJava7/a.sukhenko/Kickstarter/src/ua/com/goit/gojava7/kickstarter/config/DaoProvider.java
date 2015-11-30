package ua.com.goit.gojava7.kickstarter.config;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoProvider {

	private DataSource dataSource;

	private Connection connection = null;

	public DaoProvider(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void open() {
		if (dataSource == DataSource.MYSQL) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/kickstarter?user=kickadmin&password=kickpass");
			} catch (SQLException e) {
				throw new IllegalStateException("Cannot open connection. " + e.getMessage(), e);
			} catch (ClassNotFoundException e) {
				throw new IllegalStateException("Cannot open load mysql driver. " + e.getMessage(), e);
			}
		}
	}

	public void close() {
		if (dataSource == DataSource.MYSQL) {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new IllegalStateException("Cannot close connection " + connection + ". " + e.getMessage(), e);
			}
		}
	}



}
