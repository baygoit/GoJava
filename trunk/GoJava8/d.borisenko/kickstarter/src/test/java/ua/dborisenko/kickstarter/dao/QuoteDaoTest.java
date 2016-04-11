package ua.dborisenko.kickstarter.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ua.dborisenko.kickstarter.domain.Quote;

@RunWith(MockitoJUnitRunner.class)
public class QuoteDaoTest {

    @Mock
    private DataSource dataSource;
    @InjectMocks 
    private QuoteDao quoteDao;
    
    @Test
    public void getRandomQuoteTest() throws SQLException {
        ResultSet rs =  mock(ResultSet.class);
        when(rs.next()).thenReturn(true);
        when(rs.getString("author")).thenReturn("testauthor");
        when(rs.getString("text")).thenReturn("testtext");
        PreparedStatement statement = mock(PreparedStatement.class);
        when(statement.executeQuery()).thenReturn(rs);
        Connection connection = mock(Connection.class);
        when(connection.prepareStatement(anyString())).thenReturn(statement);
        when(dataSource.getConnection()).thenReturn(connection);
        Quote quote = quoteDao.getRandomQuote();
        assertThat(quote.getAuthor(), is("testauthor"));
        assertThat(quote.getText(), is("testtext"));
    }
    
    @Test
    public void getRandomQuoteEmptyTest() throws SQLException {
        ResultSet rs =  mock(ResultSet.class);
        when(rs.next()).thenReturn(false);
        PreparedStatement statement = mock(PreparedStatement.class);
        when(statement.executeQuery()).thenReturn(rs);
        Connection connection = mock(Connection.class);
        when(connection.prepareStatement(anyString())).thenReturn(statement);
        when(dataSource.getConnection()).thenReturn(connection);
        Quote quote = quoteDao.getRandomQuote();
        assertThat(quote.getAuthor(), is(nullValue()));
        assertThat(quote.getText(), is(nullValue()));
    }

    @Test(expected = IllegalStateException.class)
    public void getRandomQuoteTestFail() throws SQLException {
        when(dataSource.getConnection()).thenReturn(null);
        quoteDao.getRandomQuote();
    }

}
