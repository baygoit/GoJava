package ua.com.gojava4.kickstarter.dao;

import java.sql.Connection;

public interface ConnectionPool extends AutoCloseable {
	public Connection getConnection();
}
