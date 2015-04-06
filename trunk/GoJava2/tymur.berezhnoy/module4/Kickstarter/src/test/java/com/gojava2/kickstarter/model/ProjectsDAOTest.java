package com.gojava2.kickstarter.model;

import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gojava2.kickstarter.dao.ProjectsDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context.xml", "classpath:test-application-context.xml"})
public class ProjectsDAOTest extends ProjectStorageTest {
	
	@Autowired
	private ProjectsDAO projectsDAO;
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	ProjectStorage getStorage() {
		return projectsDAO;
	}
	
	@Before
	public void setUping() {
		try(Statement statement = dataSource.getConnection().createStatement()) {
			statement.execute("INSERT INTO categories (id, name) VALUES (1, 'Art'), (2, 'Dance')");
		} catch (SQLException e) {
			throw new RuntimeException("Something wrong with driver or connection", e);
		}
	}
	
	@After
	public void cleanUp() {
		try(Statement statement = dataSource.getConnection().createStatement()) {
			statement.execute("DELETE FROM projects WHERE id >= 1");
			statement.execute("DELETE FROM categories WHERE id >= 1");
			statement.execute("ALTER SEQUENCE projects_id_seq RESTART WITH 1");
			statement.execute("UPDATE projects SET id = nextval('projects_id_seq')");
		} catch (SQLException e) {
			throw new RuntimeException("Something wrong with driver or connection", e);
		}
	}
}