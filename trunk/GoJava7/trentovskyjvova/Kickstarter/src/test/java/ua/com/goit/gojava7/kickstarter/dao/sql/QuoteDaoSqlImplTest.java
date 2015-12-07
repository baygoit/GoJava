package ua.com.goit.gojava7.kickstarter.dao.sql;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.anyString;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import ua.com.goit.gojava7.kickstarter.config.DBConnectionManager;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kickstarter.dao.sql.QuoteDaoSqlImpl;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

public class QuoteDaoSqlImplTest {

	@Mock
	private Connection connection = mock(Connection.class);
	@Mock
	DBConnectionManager connectionManager = mock(DBConnectionManager.class);
	@InjectMocks
	private QuoteDao quoteDaoMySqlImpl = new QuoteDaoSqlImpl(connectionManager);

	@Test
	public void testGetRandomQuote() throws SQLException {
		PreparedStatement ps = mock(PreparedStatement.class);
		ResultSet rs = mock(ResultSet.class);
		when(connectionManager.getConnection()).thenReturn(connection);
		when(connection.prepareStatement(anyString())).thenReturn(ps);
		when(ps.executeQuery()).thenReturn(rs);
		when(rs.next()).thenReturn(true, false);
		when(rs.getString("text")).thenReturn("text");
		when(rs.getString("author")).thenReturn("outhor 1");

		Quote quote = quoteDaoMySqlImpl.getRandomQuote();

		assertThat(quote.getAuthor(), is("outhor 1"));
	}

/*	@Test(expected = SQLException.class)
	public void testGetRandomQuoteException() throws SQLException {
		
		when(daoProvider.open()).thenReturn(connection);
		when(connection.prepareStatement(anyString())).thenThrow(
				SQLException.class);

		quoteDaoMySqlImpl.getRandomQuote();
		verify(connection).prepareStatement(anyString());
	}*/
}
