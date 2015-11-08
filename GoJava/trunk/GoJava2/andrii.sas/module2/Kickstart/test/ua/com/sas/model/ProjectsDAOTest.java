package ua.com.sas.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;

public class ProjectsDAOTest extends ProjectsTest{

	private ConnectionDAO connectionDAO;
	private Connection connection;

	@Override
	Projects getProjects() {
		connectionDAO = new ConnectionDAO("kickstarter_db_test", "postgres", "gfhfien17");
		connection = connectionDAO.getConnection();
		return new ProjectsDAO(connectionDAO);
	}
	
	@Override
	Categories getCategories() {
		return new CategoriesDAO(connectionDAO);
	}
	
	@After
	public void cleanFile(){
		try {
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			statement.executeUpdate("delete from projects");
			statement.executeUpdate("delete from categories");
		} catch (SQLException e) {
			throw new RuntimeException(
				"Connection Failed! Check output console", e);
		}
		connectionDAO.closeConnection();
	}

}
