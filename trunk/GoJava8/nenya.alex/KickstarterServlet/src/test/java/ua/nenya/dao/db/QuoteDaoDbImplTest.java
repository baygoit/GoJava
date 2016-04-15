package ua.nenya.dao.db;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Matchers.anyString;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyObject;

import static org.mockito.Mockito.when;

import java.sql.SQLException;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import ua.nenya.domain.Quote;

@RunWith(MockitoJUnitRunner.class)
public class QuoteDaoDbImplTest {

	@Mock
	private JdbcTemplate jdbcTemplate;

	@InjectMocks
	private QuoteDaoImpl quoteDao;

	@SuppressWarnings("unchecked")
	@Test
	public void testGetRandomQuote() throws SQLException {
		Quote quote = new Quote();
		quote.setName("Some quote");

		when(jdbcTemplate.queryForObject(anyString(), (RowMapper<Quote>) anyObject())).thenReturn(quote);
		Quote testQuote = quoteDao.getRandomQuote();
		assertThat(testQuote.getName(), is("Some quote"));

	}

}
