package ua.dborisenko.kickstarter.dao;

import java.sql.SQLException;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class QuoteDaoTest {

    @InjectMocks 
    private QuoteDao quoteDao;
        
    @Test
	@Ignore
    public void getRandomTest() throws SQLException {
        quoteDao.getRandom();
		// verify(jdbcTemplate).queryForObject(eq(QuoteDao.GET_RANDOM_QUERY),
		// Matchers.any(QuoteRowMapper.class));
    }
}
