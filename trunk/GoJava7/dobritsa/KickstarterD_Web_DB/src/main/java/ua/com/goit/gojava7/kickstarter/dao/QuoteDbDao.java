package ua.com.goit.gojava7.kickstarter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import ua.com.goit.gojava7.kickstarter.models.Quote;

@Component
public class QuoteDbDao extends DbDao<Quote> {
	
	private static final Logger log = LoggerFactory.getLogger(QuoteDbDao.class);	 

	private static final String TABLE = "quote";
	private static final String FIELDS = "text, author";

	public QuoteDbDao() {	
		log.info("Constructor QuoteDbDao()...");		
		super.TABLE = TABLE;
		super.FIELDS = FIELDS;
	}
	
	public QuoteDbDao(BasicDataSource basicDataSource) {
		super(basicDataSource, FIELDS, TABLE);
	}

	public Quote getRandomQuote() {
		log.info("getRandomQuote()...");	
		String query = "SELECT text, author FROM quote order by rand() limit 1 ";
		log.debug("getRandomQuote() built query: {}", query);
		
		try (Connection connection = basicDataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(query); ResultSet resultSet = ps.executeQuery()) {
			while (resultSet.next()) {
				return readElement(resultSet);
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return null;
	}

	@Override
	protected Quote readElement(ResultSet resultSet) throws SQLException {
		log.info("readElement()...");			
		Quote quote = new Quote();
		quote.setText(resultSet.getString("text"));
		quote.setAuthor(resultSet.getString("author"));
		log.debug("readElement() returned quote: {}", quote);
		return quote;
	}
}
