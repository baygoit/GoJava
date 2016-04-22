package ua.dborisenko.kickstarter.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ua.dborisenko.kickstarter.domain.Quote;

@ContextConfiguration(locations = { "classpath:testApplicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class QuoteDaoTest {

    @Autowired
    private QuoteDao quoteDao;

    @Test
    public void getRandomTest() throws SQLException {
        Quote quote = new Quote();
        quote.setAuthor("testauthor");
        quote.setText("testtext");
        quoteDao.add(quote);
        Quote resultQuote = quoteDao.getRandom();
        assertThat(resultQuote.getAuthor(), is("testauthor"));
        assertThat(resultQuote.getText(), is("testtext"));
    }
}
