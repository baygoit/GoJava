package ua.nenya.dao.db;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;


import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ua.nenya.dao.QuoteDao;
import ua.nenya.domain.Quote;



@ContextConfiguration(locations={ "classpath:aplicationContextTest.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class QuoteDaoDbImplTest{

	private EmbeddedDatabase db;
	@Autowired
	private QuoteDao quoteDao;
	
	@Before
	public void setUp() {
		db = new EmbeddedDatabaseBuilder()
	    		.setType(EmbeddedDatabaseType.H2)
	    		.addScript("/createQuote.sql")
	    		.addScript("/insertQuote.sql")
	    		.build();
	}

	@After
	public void tearDown() {
		db = new EmbeddedDatabaseBuilder()
	    		.setType(EmbeddedDatabaseType.H2)
	    		.addScript("/deleteQuote.sql")
	    		.build();
	}
	
	
	@Test
	public void testGetRandomQuote() throws SQLException {
		assertNotNull(quoteDao.getRandomQuote());
	}

}
