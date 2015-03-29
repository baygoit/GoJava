package ua.com.sas.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-application-context.xml" })
public class CategoriesDAOTest extends CategoriesTest{

	
	@Autowired
	private Categories categoriesDAO;
	
	@Autowired
	private DataSource dataSource;

	@Override
	Categories getList() {
		return categoriesDAO;
	}
		
	@After
	public void cleanFile(){
		try (Connection connection = dataSource.getConnection()) {
			Statement statement = connection.createStatement();
			statement.executeUpdate("delete from categories");
		} catch (SQLException e) {
			throw new RuntimeException(
				"Connection Failed! Check output console", e);
		}
	}
}
