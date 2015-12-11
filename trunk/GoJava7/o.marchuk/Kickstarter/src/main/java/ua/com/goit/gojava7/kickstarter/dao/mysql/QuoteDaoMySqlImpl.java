package ua.com.goit.gojava7.kickstarter.dao.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

@Repository
public class QuoteDaoMySqlImpl implements QuoteDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Quote getRandomQuote() {
		return jdbcTemplate.queryForObject("SELECT text, author FROM quote order by rand() limit 1 ", new RowMapper<Quote>() {

			@Override
			public Quote mapRow(ResultSet rs, int rowNum) throws SQLException {
				Quote quote = new Quote();
				quote.setText(rs.getString("text"));
				quote.setAuthor(rs.getString("author"));
				return quote;
			}

		});
	}

}
