package vadya_zakusylo.kickstarter.my_sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import vadya_zakusylo.kickstarter.model.dao.ConnectionPool;
import vadya_zakusylo.kickstarter.my_sql.exception.NotAvailableConnectionException;

public class ConnectionPoolSingltone implements ConnectionPool {
	private static ConnectionPoolSingltone connectionPool;

	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost/kickstarter";
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	private static ArrayList<Connection> availableConnections = new ArrayList<>();
	private static ArrayList<Connection> usedConnections = new ArrayList<>();

	private ConnectionPoolSingltone() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("Can't connect to MySQL");
		}
		initConnection();
	}

	private static void initConnection() {
		try {
			int sumConnection = 6;
			for (int oneConnection = 0; oneConnection < sumConnection; oneConnection++) {
				availableConnections.add(DriverManager.getConnection(URL, USER, PASSWORD));
			}
		} catch (SQLException e) {
			System.out.println("Can't create the connection!");
		}
	}

	@Override
	public Connection getConnection() {
		Connection connection;
		if (availableConnections.size() == 0) {
			throw new NotAvailableConnectionException();
		} else {
			connection = availableConnections.get(availableConnections.size() - 1);
			availableConnections.remove(availableConnections.size() - 1);
			usedConnections.add(connection);
		}
		return connection;
	}

	@Override
	public void closeConnection(Connection connection) {
		availableConnections.add(connection);
		usedConnections.remove(connection);
	}

	public static synchronized ConnectionPoolSingltone getConnectionPool() {
		if (connectionPool == null) {
			connectionPool = new ConnectionPoolSingltone();
		}
		return connectionPool;
	}
}
