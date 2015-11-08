package dao.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Pool {

	private static Connection connection;
	private volatile static Pool uniqueInstance;
	private volatile DataSource ds = null;
	private volatile boolean realPool = true;

	private Pool() {
	}

	public static Pool getInstance() {
		if (uniqueInstance == null) {
			synchronized (Pool.class) {
				if (uniqueInstance == null) {
					uniqueInstance = new Pool();
				}
			}
		}
		return uniqueInstance;
	}

	public synchronized Connection getConnection() throws KickstarterException {
		if (realPool) {
			try {

				if (ds == null) {
					InitialContext initCtx = new InitialContext();
					ds = (DataSource) initCtx
							.lookup("java:comp/env/jdbc/kickstarter");
				}
				connection = ds.getConnection();

			} catch (SQLException | NamingException e) {
				ds = null;
				connection = null;
				throw new KickstarterException("Pool exception", e);
			}
			return connection;
		}
		return testConnection();
	}

	private Connection testConnection() throws KickstarterException {
		try {
			if (connection == null || connection.isClosed()) {
				connection = DriverManager.getConnection(
						"jdbc:postgresql://localhost:5432/kickstarter",
						"postgres", "root");
			}

		} catch (SQLException e) {
			connection = null;
			throw new KickstarterException("Pool exception", e);
		}
		return connection;
	}

	public void setRealPool(boolean realPool) {
		this.realPool = realPool;
	}
}