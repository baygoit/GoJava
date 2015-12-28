package ua.com.goit.gojava7.kickstarter.dao.sql;

import static org.mockito.Mockito.verify;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.contains;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kickstarter.dao.sql.QuoteDaoSqlImpl;

@RunWith(MockitoJUnitRunner.class)
public class QuoteDaoSqlImplTest {

	@Mock
	private JdbcTemplate jdbcTemplate;
	@InjectMocks
	private QuoteDao quoteDaoMySqlImpl = new QuoteDaoSqlImpl();
	
	@Test
	@Ignore
	public void testGetRandomQuote(){	
		quoteDaoMySqlImpl.getRandomQuote();
		verify(jdbcTemplate).queryForObject(contains("quote"), any(BeanPropertyRowMapper.class));
	}

}
