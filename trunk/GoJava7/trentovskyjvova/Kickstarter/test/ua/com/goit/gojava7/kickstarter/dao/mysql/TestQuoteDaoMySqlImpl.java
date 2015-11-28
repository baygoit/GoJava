package ua.com.goit.gojava7.kickstarter.dao.mysql;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kickstarter.domain.Quote;
import ua.com.goit.gojava7.kickstarter.exception.IODatabaseException;

public class TestQuoteDaoMySqlImpl {

	@Mock
	private Connection connection = mock(Connection.class);
	@InjectMocks
	private QuoteDao quoteDaoMySqlImpl = new QuoteDaoMySqlImpl(connection);

	@Test
	public void testGetRandomQuote() throws SQLException {
		PreparedStatement ps = mock(PreparedStatement.class);
		ResultSet rs = mock(ResultSet.class);
		when(connection.prepareStatement(anyString())).thenReturn(ps);
		when(ps.executeQuery()).thenReturn(rs);
		when(rs.next()).thenReturn(true, false);
		when(rs.getString("text")).thenReturn("text");
		when(rs.getString("author")).thenReturn("outhor 1");

		Quote quote = quoteDaoMySqlImpl.getRandomQuote();

		assertThat(quote.getAuthor(), is("outhor 1"));
	}

	@SuppressWarnings("unchecked")
	@Test(expected = IODatabaseException.class)
	public void testGetRandomQuoteException() throws SQLException {

		when(connection.prepareStatement(anyString())).thenThrow(
				SQLException.class);

		quoteDaoMySqlImpl.getRandomQuote();
		verify(connection).prepareStatement(anyString());
	}
}
