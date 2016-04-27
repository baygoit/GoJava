package ua.dborisenko.kickstarter.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = { "classpath:testApplicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class QuoteTest {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Test
    public void mappingTest() throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            Quote quote = new Quote();
            quote.setAuthor("testauthor");
            quote.setText("testtext");
            session.save(quote);
            session.flush();
        }
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("FROM Quote");
            List<Quote> resultList = query.list();
            Quote resultQuote = resultList.get(0);
            session.flush();
            assertThat(resultQuote.getAuthor(), is("testauthor"));
            assertThat(resultQuote.getText(), is("testtext"));
        }
    }
}
