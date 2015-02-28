package ua.com.sas.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;

public class ProjectsDAOTest extends ProjectsTest{

	private ConnectionDAO connectionDAO;

	@Override
	Projects getProjects() {
		connectionDAO = new ConnectionDAO("kickstarter_db_test", "postgres", "gfhfien17");
		return new ProjectsDAO(connectionDAO);
	}

	@After
	public void cleanFile(){
		try {
			Connection connection = connectionDAO.getConnection();
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			statement.executeUpdate("delete from projects");
		} catch (SQLException e) {
			throw new RuntimeException(
				"Connection Failed! Check output console", e);
		}
		connectionDAO.closeConnection();
	}

}
