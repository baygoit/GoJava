package ua.com.goit.gojava7.kickstarter.DAO.dbStorage.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.DAO.AbstractQuoteStorage;
import ua.com.goit.gojava7.kickstarter.model.Quote;

@Repository
public class QuoteDbStorage extends AbstractQuoteStorage {

	private final String INSERT_QUOTES = "INSERT INTO qoutes (text, author) VALUES (?, ?)";
	private final String SELECT_RAND_QUOTE = "SELECT text, author FROM quotes ORDER BY RAND() LIMIT 1";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void add(Quote quote) {
		jdbcTemplate.batchUpdate(INSERT_QUOTES, new StatementSetter(quote));
	}

	@Override
	public Quote getRandomQuote() {
		return jdbcTemplate.queryForObject(SELECT_RAND_QUOTE, new Mapper());
	}

	@Override
	public List<Quote> getAll() {
		return null;
	}
	
	public class Mapper implements RowMapper<Quote> {

		@Override
		public Quote mapRow(ResultSet resultSet, int index) throws SQLException {
			Quote quote = new Quote();
			quote.setText(resultSet.getString("text"));
			quote.setAuthor(resultSet.getString("author"));
			return quote;
		}

	}
	
	public class StatementSetter implements BatchPreparedStatementSetter {
		
		List<Quote> quotes;
		
		public StatementSetter(Quote quote) {
			quotes = new ArrayList<>();
			quotes.add(quote);
		}
		
		@Override
		public int getBatchSize() {
			return quotes.size();
		}

		@Override
		public void setValues(PreparedStatement statement, int index) throws SQLException {
			Quote quote = quotes.get(index);
			statement.setString(1, quote.getText());
			statement.setString(2, quote.getAuthor());
		}

	}

}
