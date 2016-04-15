package ua.dborisenko.kickstarter.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;

import ua.dborisenko.kickstarter.dao.QuoteDao.QuoteRowMapper;
import ua.dborisenko.kickstarter.domain.Quote;

@RunWith(MockitoJUnitRunner.class)
public class QuoteDaoTest {

    @Mock
    private JdbcTemplate jdbcTemplate;
    @InjectMocks 
    private QuoteDao quoteDao;
        
    @Test
    public void mapRowTest() throws SQLException  {
        ResultSet rs = mock(ResultSet.class);
        when(rs.getInt("id")).thenReturn(111);
        when(rs.getString("author")).thenReturn("testauthor");
        when(rs.getString("text")).thenReturn("testtext");
        QuoteRowMapper mapper = quoteDao.new QuoteRowMapper();
        Quote quote = mapper.mapRow(rs, 1);
        assertThat(quote.getId(), is(111));
        assertThat(quote.getAuthor(), is("testauthor"));
        assertThat(quote.getText(), is("testtext"));
    }
    
    @Test
    public void getRandomTest() throws SQLException {
        quoteDao.getRandom();
        verify(jdbcTemplate).queryForObject(eq(QuoteDao.GET_RANDOM_QUERY), Matchers.any(QuoteRowMapper.class));
    }
}
