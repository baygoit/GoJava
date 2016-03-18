package ua.dborisenko.kickstarter.dao;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ua.dborisenko.kickstarter.domain.Quote;

public class QuoteDaoSqlTest {

    private static QuoteDaoSql quoteDao = new QuoteDaoSql();

    @Test
    public void getRandomQuoteTest() {
        assertThat(quoteDao.getRandomQuote(), notNullValue());
    }
    
    @Test
    public void getRandomQuoteTestIsRandom() {
        boolean randomFlag = false;
        Quote quote1 = quoteDao.getRandomQuote();
        for (int i = 0; i < 1000; i++) {
            if (!quote1.getText().equals(quoteDao.getRandomQuote().getText())) {
                randomFlag = true;
                break;
            }
        }
        assertTrue(randomFlag);
    }
}
