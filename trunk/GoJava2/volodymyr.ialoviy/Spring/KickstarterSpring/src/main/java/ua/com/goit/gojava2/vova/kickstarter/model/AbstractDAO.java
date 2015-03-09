package ua.com.goit.gojava2.vova.kickstarter.model;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

public class AbstractDAO {

	protected DataSource dataSource;

	protected Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

}