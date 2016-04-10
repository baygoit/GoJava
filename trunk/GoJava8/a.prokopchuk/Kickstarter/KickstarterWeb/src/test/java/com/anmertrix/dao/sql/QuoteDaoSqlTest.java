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

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.anmertrix.domain.Quote;

@RunWith(MockitoJUnitRunner.class)
public class QuoteDaoSqlTest {

	@Mock
	private DataSource dataSource;
	@InjectMocks
	private QuoteDaoSql quoteDaoSql;

	@After
	public void tearDown() {
		verifyNoMoreInteractions(dataSource);
	}

	@Test(expected = RuntimeException.class)
	public void testGetRandomQuoteGetConnectionException() throws SQLException {
		when(dataSource.getConnection()).thenThrow(new SQLException());
		try {
			quoteDaoSql.getRandomQuote();
		} finally {
			verify(dataSource).getConnection();
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

		when(dataSource.getConnection()).thenReturn(connection);
		Quote quote = quoteDaoSql.getRandomQuote();
		String quoteText = quote.getQuoteText() + " (" + quote.getAuthor() + ")";
		assertThat(quoteText, is("quote (author)"));

		verify(dataSource).getConnection();
	}

}
