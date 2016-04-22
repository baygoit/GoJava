package com.anmertrix.dao.sql;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
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
	@Mock
	private Connection connection;
	@Mock
    PreparedStatement preparedStatement;
	@Mock
    ResultSet resultSet;
	@InjectMocks
	private QuoteDaoSql quoteDaoSql;
	
	@Before
    public void setUp() throws SQLException {
		when(dataSource.getConnection()).thenReturn(connection);
		when(preparedStatement.executeQuery()).thenReturn(resultSet);
		when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
	}

	@After
	public void tearDown() {
	}

	@Ignore
	@Test
	public void testGetRandomQuote() throws SQLException {
		when(resultSet.getString("author")).thenReturn("author");
		when(resultSet.getString("text")).thenReturn("quote");
		Quote quote = quoteDaoSql.getRandomQuote();
		String quoteText = quote.getText() + " (" + quote.getAuthor() + ")";
		assertThat(quoteText, is("quote (author)"));
		verify(dataSource).getConnection();
	}

}
