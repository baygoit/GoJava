package ua.nenya.dao.db;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.is;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.sql.DataSource;

import ua.nenya.domain.Quote;

@RunWith(MockitoJUnitRunner.class)
public class QuoteDaoDbImplTest {
	

	@Mock
	private DataSource dataSource;
	@Mock
	private Quote quote;
	
	@InjectMocks
	private QuoteDaoImpl quoteDao;
	
	@After
	public void tearDown() {
		verifyNoMoreInteractions(dataSource);
	}

	@Test
	public void testGetRandomQuote() throws SQLException {
		
		ResultSet rs = mock(ResultSet.class);
		when(rs.getString("quote")).thenReturn("Some quote");

		Statement statement = mock(Statement.class);
		when(statement.executeQuery(anyString())).thenReturn(rs);

		Connection connection = mock(Connection.class);
		when(connection.createStatement()).thenReturn(statement);

		when(dataSource.getConnection()).thenReturn(connection);
		
		Quote quote = quoteDao.getRandomQuote(new Random());
		
		String quoteText = quote.getName();
		assertEquals("Some quote", quoteText);
		assertThat(quoteText, is("Some quote"));
		verify(dataSource).getConnection();
		
	}

}
