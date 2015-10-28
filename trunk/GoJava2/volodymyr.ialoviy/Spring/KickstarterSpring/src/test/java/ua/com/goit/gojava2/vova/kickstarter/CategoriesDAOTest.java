//package ua.com.goit.gojava2.vova.kickstarter;
//
//import static org.junit.Assert.*;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.List;
//
//import javax.sql.DataSource;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import ua.com.goit.gojava2.vova.kickstarter.model.CategoriesDAO;
//import ua.com.goit.gojava2.vova.kickstarter.model.Category;
//
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath:test-application-context.xml" })
//public class CategoriesDAOTest {
//
//	@Autowired
//	private CategoriesDAO categoriesDAO;
//	
//	@Autowired
//	private DataSource dataSource;
//	
//	@Before
//	public void createTable(){
//		try (Connection connection = dataSource.getConnection()) {
//			Statement statement = connection.createStatement();
//			statement.execute("CREATE TABLE categories (id_category bigserial NOT NULL, name_category text NOT NULL, description_category text, CONSTRAINT categories_pkey PRIMARY KEY (id_category)) WITH (OIDS=FALSE); ALTER TABLE categories OWNER TO postgres;");
//			statement.execute("INSERT INTO categories (name_category) VALUES ('name1');");
//			statement.execute("INSERT INTO categories (name_category) VALUES ('name2');");
//		} catch (SQLException e) {
//			throw new RuntimeException("create and insert table categories from kickstartertest DB - smth wrong", e);
//		}
//	}
//
//	@After
//	public void deleteTable(){
//		try (Connection connection = dataSource.getConnection()) {
//			Statement statement = connection.createStatement();
//			statement.execute("DROP TABLE categories");
//		} catch (SQLException e) {
//			throw new RuntimeException("delete table categories from kickstartertest DB - smth wrong", e);
//		}
//	}
//
//	@Test
//	public void shouldAllCategories_whenNotAllCatecories() {
//		List<Category> categories = categoriesDAO.getCategories();
//		assertTrue(categories.get(0).toString().equals("1 - name1"));
//		assertTrue(categories.get(1).toString().equals("2 - name2"));
//		assertEquals(2, categories.size());
//	}
//}
