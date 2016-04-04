package ua.dborisenko.kickstarter.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Ignore;
import org.junit.Test;

import com.mysql.jdbc.Statement;

import ua.dborisenko.kickstarter.domain.Quote;

@Ignore
public class QuoteDaoSqlTest {

    @Test
    public void getRandomQuoteTest() throws SQLException {
        ResultSet rs = mock(ResultSet.class);
        when(rs.getString("author")).thenReturn("testauthor");
        when(rs.getString("text")).thenReturn("testtext");
        Statement statement = mock(Statement.class);
        when(statement.executeQuery(anyString())).thenReturn(rs);
        Connection connection = mock(Connection.class);
        when(connection.createStatement()).thenReturn(statement);
        QuoteDao quoteDao = spy(QuoteDao.class);
        when(quoteDao.getConnection()).thenReturn(connection);
        Quote quote = quoteDao.getRandomQuote();
        assertThat(quote.getAuthor(), is("testauthor"));
        assertThat(quote.getText(), is("testtext"));
    }

    @Test(expected = IllegalStateException.class)
    public void getRandomQuoteTestFail() throws SQLException {
        QuoteDao quoteDao = spy(QuoteDao.class);
        when(quoteDao.getConnection()).thenReturn(null);
        quoteDao.getRandomQuote();
    }
}
