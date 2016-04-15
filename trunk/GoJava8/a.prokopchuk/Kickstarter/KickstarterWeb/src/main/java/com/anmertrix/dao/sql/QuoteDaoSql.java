package com.anmertrix.dao.sql;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.anmertrix.dao.QuoteDao;
import com.anmertrix.domain.Quote;

@Repository
public class QuoteDaoSql implements QuoteDao {

	private static final String SELECT_QUOTE = "SELECT author, text FROM quote order by rand() limit 1";

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
    private final class QuoteRowMapper implements RowMapper<Quote> {
		public Quote mapRow(ResultSet rs, int rowNum) throws SQLException {
			String author = rs.getString("author");
			String text = rs.getString("text");
			Quote quote = new Quote();
			quote.setAuthor(author);
			quote.setQuoteText(text);
			return quote;
		}
	}

	public Quote getRandomQuote() {
		
		return jdbcTemplate.queryForObject(SELECT_QUOTE, new QuoteRowMapper());
		
	}

}
