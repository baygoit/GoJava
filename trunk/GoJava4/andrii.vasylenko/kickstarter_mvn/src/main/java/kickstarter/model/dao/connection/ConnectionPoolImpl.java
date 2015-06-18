package kickstarter.model.dao.connection;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;

public class ConnectionPoolImpl implements ConnectionPool {
	private static volatile ConnectionPool instance;

	private static volatile BasicDataSource connectionPool;

	public static ConnectionPool getInstance() throws SQLException {
		if (instance == null) {
			synchronized (ConnectionPoolImpl.class) {
				if (instance == null) {
					instance = new ConnectionPoolImpl();
				}
			}
		}
		return instance;
	}

	private ConnectionPoolImpl() throws SQLException {
		try {
			InitialContext initCtx = new InitialContext();
			connectionPool = (BasicDataSource) initCtx.lookup("java:comp/env/jdbc/kickstarter");
		} catch (NamingException e) {
			throw new SQLException(e);
		}
	}

	@Override
	public Connection getConnection() throws SQLException {
		return connectionPool.getConnection();
	}
}
