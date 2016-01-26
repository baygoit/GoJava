package ua.com.goit.gojava7.kikstarter.config;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class MysqlProvider {

	private String driver;
	private String host;
	private String username;
	private String password;

	private static MysqlProvider datasource;
	private ComboPooledDataSource cpds;

	private MysqlProvider() throws IOException, SQLException, PropertyVetoException {

		readConfiguraionProperties();

		cpds = new ComboPooledDataSource();
		cpds.setDriverClass(driver);
		cpds.setJdbcUrl(host);
		cpds.setUser(username);
		cpds.setPassword(password);
		cpds.setMinPoolSize(5);
		cpds.setAcquireIncrement(5);
		cpds.setMaxPoolSize(20);
		cpds.setMaxStatements(180);
	}

	public static MysqlProvider getInstance()
			throws IOException, SQLException, PropertyVetoException {
		if (datasource == null) {
			datasource = new MysqlProvider();
			return datasource;
		} else {
			return datasource;
		}

	}

	public Connection getConnection() throws SQLException {
		return this.cpds.getConnection();
	}

	private void readConfiguraionProperties() {
		Properties properties = new Properties();

		try (InputStream inputStream = getClass().getClassLoader()
				.getResourceAsStream("config.properties")) {

			properties.load(inputStream);

			driver = properties.getProperty("driverOracle");
			host = properties.getProperty("databaseHostOracle");
			username = properties.getProperty("usernameOracle");
			password = properties.getProperty("passwordOracle");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
