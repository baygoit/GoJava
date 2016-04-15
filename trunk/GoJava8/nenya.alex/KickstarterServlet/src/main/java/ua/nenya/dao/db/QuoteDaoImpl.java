package ua.nenya.dao.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ua.nenya.dao.QuoteDao;
import ua.nenya.domain.Quote;

@Repository
public class QuoteDaoImpl implements QuoteDao {
	private static final String GET_QUOTE = "SELECT name FROM quotes ORDER BY random() LIMIT(1)";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Quote getRandomQuote() {
		return jdbcTemplate.queryForObject(GET_QUOTE, new BeanPropertyRowMapper<Quote>(Quote.class));
	}

}
