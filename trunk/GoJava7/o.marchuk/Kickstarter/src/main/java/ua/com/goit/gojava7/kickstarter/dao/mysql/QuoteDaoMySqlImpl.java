package ua.com.goit.gojava7.kickstarter.dao.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

@Repository
public class QuoteDaoMySqlImpl implements QuoteDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Quote getRandomQuote() {
		return jdbcTemplate.queryForObject("SELECT text, author FROM quote order by rand() limit 1 ",
				new BeanPropertyRowMapper<Quote>(
				Quote.class));
	}

}
