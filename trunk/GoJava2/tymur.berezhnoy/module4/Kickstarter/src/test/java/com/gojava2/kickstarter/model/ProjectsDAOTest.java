package com.gojava2.kickstarter.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;

import com.gojava2.kickstarter.dao.ProjectsDAO;

public class ProjectsDAOTest extends ProjectStorageTest {

	private Connection connection;
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Can't load driver", e);
		}
	}
	
	@Override
	ProjectStorage getStorage() {
		Statement statement = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test_kickstarter",
													"postgres", "Berezhnoi");
			statement = connection.createStatement();
		} catch (SQLException e) {
			throw new RuntimeException("Can't finde driver", e);
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				throw new RuntimeException("Can't close statement", e);
			}
		}
		return new ProjectsDAO(connection);
	}
	
	@After
	public void cleanUp() {
		Statement statement = null;
		try {
			statement = connection.createStatement();
			statement.execute("DELETE FROM projects WHERE id >= 1");
			statement.execute("ALTER SEQUENCE projects_id_seq RESTART WITH 1");
			statement.execute("UPDATE projects SET id = nextval('projects_id_seq')");
			statement.execute("DELETE FROM categories WHERE id >= 1");
			statement.execute("ALTER SEQUENCE categories_id_seq RESTART WITH 1");
			statement.execute("UPDATE categories SET id = nextval('categories_id_seq')");
		} catch (SQLException e) {
			throw new RuntimeException("Something wrong with driver or connection", e);
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				throw new RuntimeException("Can't close statement", e);
			}
		}
	}
}