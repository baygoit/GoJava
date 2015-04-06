package com.gojava2.kickstarter.model;

import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gojava2.kickstarter.dao.QuotesDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-application-context.xml"})
public class QuotesDAOTest extends QuoteStorageTest {
	
	@Autowired
	private QuotesDAO quotesDAO;
	
	@Autowired
	private DataSource dataSource; 
	
	@Override
	QuoteStorage getStorage() {
		return quotesDAO;
	}
	
	@After
	public void cleanUp() {
		try(Statement statement = dataSource.getConnection().createStatement()) {
			statement.execute("DELETE FROM quotes WHERE id >= 1");
			statement.execute("ALTER SEQUENCE quotes_id_seq RESTART WITH 1;");
			statement.execute("UPDATE quotes SET id = nextval('quotes_id_seq')");
		} catch (SQLException e) {
			throw new RuntimeException("Can't create statement");
		}
	}
}