package ua.com.goit.gojava2.vova.kickstarter.model;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

public class AbstractDAO {

	@Autowired
	private DataSource dataSource;

	protected Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

}