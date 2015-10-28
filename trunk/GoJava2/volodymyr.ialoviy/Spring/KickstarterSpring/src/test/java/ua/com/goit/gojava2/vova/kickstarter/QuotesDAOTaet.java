//package ua.com.goit.gojava2.vova.kickstarter;
//
//import static org.junit.Assert.assertTrue;
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.sql.Statement;
//import javax.sql.DataSource;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import ua.com.goit.gojava2.vova.kickstarter.model.QuotesDAO;
//
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath:test-application-context.xml" })
//public class QuotesDAOTaet {
//
//	@Autowired
//	private QuotesDAO quotesDAO;
//	
//	@Autowired
//	private DataSource dataSource;
//
//	@Before
//	public void createTable(){
//		try (Connection connection = dataSource.getConnection()) {
//			Statement statement = connection.createStatement();
//			statement.execute("CREATE TABLE quotes (id_quote bigserial NOT NULL, quote text NOT NULL, CONSTRAINT quotes_pkey PRIMARY KEY (id_quote)) WITH (OIDS=FALSE ); ALTER TABLE quotes OWNER TO postgres;");
//			statement.execute("INSERT INTO quotes (quote) VALUES ('quote1');");
//			statement.execute("INSERT INTO quotes (quote) VALUES ('quote2');");
//			statement.execute("INSERT INTO quotes (quote) VALUES ('quote3');");
//		} catch (SQLException e) {
//			throw new RuntimeException("create and insert table quotes from kickstartertest DB - smth wrong", e);
//		}
//	}
//
//	@After
//	public void deleteTable(){
//		try (Connection connection = dataSource.getConnection()) {
//			Statement statement = connection.createStatement();
//			statement.execute("DROP TABLE quotes");
//		} catch (SQLException e) {
//			throw new RuntimeException("delete table quotes from kickstartertest DB - smth wrong", e);
//		}
//	}
//	
//	@Test
//	public void shouldProjectInString_whenNotProjectInString() {
//		String quote = quotesDAO.getQuote();
//		assertTrue(quote.equals("quote3") || quote.equals("quote2") || quote.equals("quote1"));
//	}
//}