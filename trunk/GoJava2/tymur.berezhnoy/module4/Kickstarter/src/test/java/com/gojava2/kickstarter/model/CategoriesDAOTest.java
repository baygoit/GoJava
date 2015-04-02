package com.gojava2.kickstarter.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;

import com.gojava2.kickstarter.dao.CategoriesDAO;

public class CategoriesDAOTest extends CategoryStorageTest {

	private Connection connection;
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Can't load driver", e);
		}
	}
	
	@Override
	CategoryStorage getStorage() {
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test_kickstarter",
													"postgres", "Berezhnoi");
		} catch (SQLException e) {
			throw new RuntimeException("Can't get no connection", e);
		}
		return new CategoriesDAO(connection);
	}
	
	@After
	public void cleanUp() {
		Statement statement = null;
		try {
			statement = connection.createStatement();
			statement.execute("DELETE FROM categories WHERE id >= 0");
		} catch (SQLException e) {
			throw new RuntimeException("Can't create statement", e);
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				throw new RuntimeException("Can't close statement", e);
			}
		}
	}
}