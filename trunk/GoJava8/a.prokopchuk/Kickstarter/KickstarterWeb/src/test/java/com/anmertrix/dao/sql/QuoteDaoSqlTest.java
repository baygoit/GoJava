package com.anmertrix.dao.sql;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	private static final String SELECT_QUOTE = "SELECT 1";

	@Mock
	private DataSource dataSource;
	@Mock
	private Connection connection;
	@InjectMocks
	private QuoteDaoSql quoteDaoSql;

	@After
	public void tearDown() {
		verifyNoMoreInteractions(dataSource);
		verifyNoMoreInteractions(connection);
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
	
	@Test(expected = RuntimeException.class)
	public void testGetRandomQuoteCreateStatementException() throws SQLException {
		when(connection.prepareStatement(SELECT_QUOTE)).thenThrow(new SQLException());
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

		PreparedStatement statement = mock(PreparedStatement.class);
		when(statement.executeQuery()).thenReturn(rs);

		Connection connection = mock(Connection.class);
		when(connection.prepareStatement(anyString())).thenReturn(statement);

		when(dataSource.getConnection()).thenReturn(connection);
		Quote quote = quoteDaoSql.getRandomQuote();
		String quoteText = quote.getQuoteText() + " (" + quote.getAuthor() + ")";
		assertThat(quoteText, is("quote (author)"));

		verify(dataSource).getConnection();
	}

}
