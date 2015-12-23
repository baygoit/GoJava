package ua.com.goit.gojava7.kickstarter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.models.Quote;

@Repository
public class QuoteDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final Logger log = LoggerFactory.getLogger(QuoteDao.class);
	
	public QuoteDao() {
		log.info("Constructor QuoteDao()...");
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}	

	public Quote getRandomQuote() {
		log.info("<Quote> getRandomQuote()...");
		String query = "SELECT text, author FROM quote order by rand() limit 1 ";
		return jdbcTemplate.queryForObject(query, new QuoteMapper());
	}

	public Quote get(int index) {
		log.info("<Quote> get({})...", index);
		String query = "select text, author from quote where id = ?";
		return jdbcTemplate.queryForObject(query, new Object[] { index }, new QuoteMapper());
	}

	private final class QuoteMapper implements RowMapper<Quote> {
		public Quote mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			log.info("QuoteMapper()...");
			Quote quote = new Quote();
			quote.setText(resultSet.getString("text"));
			quote.setAuthor(resultSet.getString("author"));
			log.debug("QuoteMapper() returned quote: {}", quote);
			return quote;
		}
	}
}
