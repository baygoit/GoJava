package ua.com.goit.gojava7.kickstarter.dao.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.beans.Quote;
import ua.com.goit.gojava7.kickstarter.dao.AbstractJdbcTemplate;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;

@Repository
public class QuoteDaoMysqlImpl extends AbstractJdbcTemplate implements QuoteDao {

	public void add(Quote quote) {
		String sql = "INSERT INTO quotes (text, author) VALUES (?, ?)";
		getJdbcTemplate().update(sql, new Object[] { quote.getQuoteText(), quote.getAuthor() });
	}

	public void remove(Quote quote) {
		String sql = "DELETE FROM quotes WHERE author = ?";
		getJdbcTemplate().update(sql, new Object[] { quote.getAuthor() });
	}

	public Quote getRandomQuote() {
		String sql = "SELECT text, author FROM quotes ORDER BY RAND() LIMIT 1";
		return getJdbcTemplate().queryForObject(sql, new QuoteRowMapper());
	}

	public class QuoteRowMapper implements RowMapper<Quote> {
		@Override
		public Quote mapRow(ResultSet rs, int rowNum) throws SQLException {
			Quote quote = new Quote();
			quote.setAuthor(rs.getString("author"));
			quote.setQuoteText(rs.getString("text"));
			return quote;
		}
	}
}
