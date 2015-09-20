package kickstarter.model.dao;

import java.sql.Connection;

public interface ConnectionPool extends AutoCloseable {
	public Connection getConnection();
}
