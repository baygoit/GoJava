package ua.dborisenko.kickstarter.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(locations = { "classpath:testApplicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class QuoteTest {
    @PersistenceContext
    private EntityManager em;

    @Test
    public void mappingTest() throws SQLException {
        Quote quote = new Quote();
        quote.setAuthor("testauthor");
        quote.setText("testtext");
        em.persist(quote);
        em.clear();
        int id = quote.getId();
        Quote resultQuote = em.find(Quote.class, id);
        assertThat(resultQuote.getAuthor(), is("testauthor"));
        assertThat(resultQuote.getText(), is("testtext"));
    }
}
