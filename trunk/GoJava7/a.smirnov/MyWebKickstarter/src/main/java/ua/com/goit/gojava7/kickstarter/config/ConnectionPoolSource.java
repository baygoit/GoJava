package ua.com.goit.gojava7.kickstarter.config;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionPoolSource {
	private String driver;
	private String host;
	private String username;
	private String password;

	private static ConnectionPoolSource connectionPoolSource;
	private ComboPooledDataSource cpds;

	private ConnectionPoolSource() throws IOException, SQLException, PropertyVetoException {

		readConfiguraionProperties();

		cpds = new ComboPooledDataSource();
		cpds.setDriverClass(driver);
		cpds.setJdbcUrl(host);
		cpds.setUser(username);
		cpds.setPassword(password);
		cpds.setMinPoolSize(5);
		cpds.setAcquireIncrement(5);
		cpds.setMaxPoolSize(50);
		cpds.setMaxStatements(180);
	}

	public static ConnectionPoolSource getInstance() throws IOException, SQLException, PropertyVetoException {
		if (connectionPoolSource == null) {
			connectionPoolSource = new ConnectionPoolSource();
			return connectionPoolSource;
		} else {
			return connectionPoolSource;
		}
	}

	public Connection getConnection() throws SQLException {
		return this.cpds.getConnection();
	}

	public void readConfiguraionProperties() {

		Properties properties = new Properties();

		try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties")) {

			properties.load(inputStream);
			driver = properties.getProperty("driverClassName");
			host = properties.getProperty("dataBaseUrl");
			username = properties.getProperty("username");
			password = properties.getProperty("password");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
