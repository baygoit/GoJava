//package ua.com.sas.model;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//import javax.sql.DataSource;
//
//import org.junit.After;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import ua.com.sas.dao.CategoriesDAO;
//import ua.com.sas.dao.ProjectsDAO;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath:test-application-context.xml" })
//public class ProjectsDAOTest extends ProjectsTest{
//
//	@Autowired
//	private Projects projectsDAO;
//	
//	@Autowired
//	private Categories categoriesDAO;
//
//	@Autowired
//	private DataSource dataSource;
//	
//	@Override
//	Projects getProjects() {
//		return projectsDAO;
//	}
//	
//	@Override
//	Categories getCategories() {
//		return categoriesDAO;
//	}
//	
//	@After
//	public void cleanUp(){
//		try (Connection connection = dataSource.getConnection()) {
//			Statement statement = connection.createStatement();
//			statement.executeUpdate("delete from projects");
//			statement.executeUpdate("delete from categories");
//		} catch (SQLException e) {
//			throw new RuntimeException(
//				"Connection Failed! Check output console", e);
//		}
//	}
//}
