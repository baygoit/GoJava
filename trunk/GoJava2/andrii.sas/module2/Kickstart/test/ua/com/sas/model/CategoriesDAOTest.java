package ua.com.sas.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;

public class CategoriesDAOTest extends CategoriesTest{

	private ConnectionDAO connectionDAO;

	@Override
	Categories getList() {
		connectionDAO = new ConnectionDAO("kickstarter_db_test", "postgres", "gfhfien17");
		return new CategoriesDAO(connectionDAO);
	}
		
	@After
	public void cleanFile(){
		try {
			Connection connection = connectionDAO.getConnection();
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			statement.executeUpdate("delete from categories");
		} catch (SQLException e) {
			throw new RuntimeException(
				"Connection Failed! Check output console", e);
		}
		connectionDAO.closeConnection();
	}
	
}
