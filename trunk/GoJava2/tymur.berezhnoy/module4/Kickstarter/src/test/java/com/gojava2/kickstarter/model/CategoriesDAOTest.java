package com.gojava2.kickstarter.model;

import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gojava2.kickstarter.dao.CategoriesDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-application-context.xml"})
public class CategoriesDAOTest extends CategoryStorageTest {

	@Autowired
	private CategoriesDAO categoriesDao;
	
	@Autowired
	private DataSource dataSource; 
	
	@Override
	CategoryStorage getStorage() {
		return categoriesDao;
	}
	
	@After
	public void cleanUp() {
		try(Statement statement = dataSource.getConnection().createStatement()) {
			statement.execute("DELETE FROM categories WHERE id >= 0");
		} catch (SQLException e) {
			throw new RuntimeException("Can't create statement", e);
		}
	}
}