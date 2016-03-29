package ua.nenya.dao.db;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import ua.nenya.project.Quote;
import ua.nenya.util.ConnectionManager;

@RunWith(MockitoJUnitRunner.class)
public class QuoteDaoDbImplTest {
	
	@Mock
	private ConnectionManager connectionManager;
	
	@Mock
	private Quote quote;
	
	@InjectMocks
	private QuoteDaoDbImpl quoteDao;
	


	@Test
	public void testGetRandomQuote() throws SQLException {
		
		ResultSet rs = mock(ResultSet.class);
		when(rs.getString("quote")).thenReturn("Some quote");

		Statement statement = mock(Statement.class);
		when(statement.executeQuery(anyString())).thenReturn(rs);

		Connection connection = mock(Connection.class);
		when(connection.createStatement()).thenReturn(statement);

		when(connectionManager.getConnection()).thenReturn(connection);
		
		Quote quote = new QuoteDaoDbImpl(connectionManager).getRandomQuote(new Random());
		
		String quoteText = quote.getName();
		assertEquals("Some quote", quoteText);
		verify(connectionManager).getConnection();
		
	}

}
