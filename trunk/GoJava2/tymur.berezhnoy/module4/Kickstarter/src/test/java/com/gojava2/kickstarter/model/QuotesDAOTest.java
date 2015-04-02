package com.gojava2.kickstarter.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;

import com.gojava2.kickstarter.dao.QuotesDAO;

public class QuotesDAOTest extends QuoteStorageTest {

	private Connection connection;
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Can't load driver");
		}
	}
	
	@Override
	QuoteStorage getStorage() {
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test_kickstarter",
													"postgres", "Berezhnoi");
		} catch (SQLException e) {
			throw new RuntimeException("Can't get no connection");
		}
		return new QuotesDAO(connection);
	}
	
	@After
	public void cleanUp() {
		try {
			Statement statement = connection.createStatement();
			statement.execute("DELETE FROM quotes WHERE id >= 1");
			statement.execute("ALTER SEQUENCE quotes_id_seq RESTART WITH 1;");
			statement.execute("UPDATE quotes SET id = nextval('quotes_id_seq')");
		} catch (SQLException e) {
			throw new RuntimeException("Can't create statement");
		}
	}
}