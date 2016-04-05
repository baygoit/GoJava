package com.anmertrix.dao.sql;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.anmertrix.ConnectionManager;
import com.anmertrix.domain.Quote;

@Ignore
@RunWith(MockitoJUnitRunner.class)
public class QuoteDaoSqlTest extends DaoSql {

	@Mock
	private ConnectionManager connectionManager;
	@InjectMocks
	private QuoteDaoSql quoteDaoSql;

	@After
	public void tearDown() {
		verifyNoMoreInteractions(connectionManager);
	}

	@Test(expected = RuntimeException.class)
	public void testGetRandomQuoteGetConnectionException() throws SQLException {
		when(connectionManager.getConnection()).thenThrow(new SQLException());
		try {
			quoteDaoSql.getRandomQuote();
		} finally {
			verify(connectionManager).getConnection();
		}
	}

	@Test
	public void testGetRandomQuote() throws SQLException {
		ResultSet rs = mock(ResultSet.class);
		when(rs.getString("author")).thenReturn("author");
		when(rs.getString("text")).thenReturn("quote");

		Statement statement = mock(Statement.class);
		when(statement.executeQuery(anyString())).thenReturn(rs);

		Connection connection = mock(Connection.class);
		when(connection.createStatement()).thenReturn(statement);

		when(connectionManager.getConnection()).thenReturn(connection);
		Quote quote = quoteDaoSql.getRandomQuote();
		String quoteText = quote.getQuoteText() + " (" + quote.getAuthor() + ")";
		assertThat(quoteText, is("quote (author)"));

		verify(connectionManager).getConnection();
	}

}
