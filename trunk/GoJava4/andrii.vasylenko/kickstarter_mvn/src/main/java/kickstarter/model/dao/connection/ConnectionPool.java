package kickstarter.model.dao.connection;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionPool {
	/**
	 * return Connection from Pool
	 */
	public Connection getConnection() throws SQLException;
}
