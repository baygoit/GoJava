package ua.com.goit.gojava2.vova.kickstarter;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import ua.com.goit.gojava2.vova.kickstarter.model.CategoriesDAO;
import ua.com.goit.gojava2.vova.kickstarter.model.Category;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-application-context.xml" })
public class CategoriesDAOTest {

	@Autowired
	private CategoriesDAO categoriesDAO;
	
	@Autowired
	private DataSource dataSource;
	
	@Before
	public void createTable(){
		try (Connection connection = dataSource.getConnection()) {
			Statement statement = connection.createStatement();
			statement.execute("CREATE TABLE categories (id_category bigserial NOT NULL, name_category text NOT NULL, description_category text, CONSTRAINT categories_pkey PRIMARY KEY (id_category)) WITH (OIDS=FALSE); ALTER TABLE categories OWNER TO postgres;");
			statement.execute("INSERT INTO categories (name_category) VALUES ('name1');");
			statement.execute("INSERT INTO categories (name_category) VALUES ('name2');");
			statement.execute("CREATE TABLE projects (id_project bigserial NOT NULL, id_category integer NOT NULL, name_project text NOT NULL, short_description_project text NOT NULL, full_description_project text, foto_project text, link_project text, how_much_needed_project integer NOT NULL, how_much_collected_project integer NOT NULL, how_much_remaining_project integer NOT NULL, date_close_project date NOT NULL, CONSTRAINT projects_pkey PRIMARY KEY (id_project), CONSTRAINT projects_id_category_fkey FOREIGN KEY (id_category) REFERENCES categories (id_category) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION ) WITH (OIDS=FALSE); ALTER TABLE projects OWNER TO postgres;");
			statement.execute("INSERT INTO projects (id_category, name_project, short_description_project, full_description_project, foto_project, link_project, how_much_needed_project, how_much_collected_project, how_much_remaining_project, date_close_project) VALUES (1, 'name1', 'short description1','full description1', 'foto1', 'link1', 1000, 10, 990, '2015-07-20');");
			statement.execute("INSERT INTO projects (id_category, name_project, short_description_project, full_description_project, foto_project, link_project, how_much_needed_project, how_much_collected_project, how_much_remaining_project, date_close_project) VALUES (2, 'name2', 'short description2','full description2', 'foto2', 'link2', 1000, 10, 990, '2015-07-20');");
			statement.execute("CREATE TABLE faq (id_project integer NOT NULL,question text NOT NULL, CONSTRAINT faq_id_project_fkey FOREIGN KEY (id_project) REFERENCES projects (id_project) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION) WITH (OIDS=FALSE); ALTER TABLE faq OWNER TO postgres;");
		} catch (SQLException e) {
			throw new RuntimeException("create and insert table projects from kickstartertest DB - smth wrong", e);
		}
	}

	@After
	public void deleteTable(){
		try (Connection connection = dataSource.getConnection()) {
			Statement statement = connection.createStatement();
			statement.execute("DROP TABLE faq");
			statement.execute("DROP TABLE projects");
			statement.execute("DROP TABLE categories");
		} catch (SQLException e) {
			throw new RuntimeException("delete table projects from kickstartertest DB - smth wrong", e);
		}
	}

	@Test
	public void shouldAllCategories_whenNotAllCatecories() {
		List<Category> categories = categoriesDAO.getCategories();
		assertTrue(categories.get(0).toString().equals("1 - name1"));
		assertTrue(categories.get(1).toString().equals("2 - name2"));
		assertEquals(2, categories.size());
	}
}
