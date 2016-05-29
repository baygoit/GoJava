package com.sandarovich.kickstarter.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@Transactional(propagation = Propagation.REQUIRES_NEW)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContextTest.xml"})

public class QuoteMappingTest {

    @PersistenceContext
    private EntityManager em;
    private Quote quote;

    @Before
    public void init() {
        Quote quote1 = new Quote();
        quote1.setId(1);
        quote1.setAuthor("1A");
        quote1.setText("1A_TEXT");
        Quote quote2 = new Quote();
        quote2.setId(2);
        quote2.setAuthor("2A");
        quote2.setText("2A_TEXT");
        em.merge(quote1);
        this.quote = em.merge(quote2);

    }

//    @After
//    public void tearDown() {
//        em.createQuery("DELETE FROM Quote").executeUpdate();
//    }

    @Test
    public void testQuoteMapping() {
        List<Quote> quotes = em.createQuery("FROM Quote").getResultList();
        assertThat(quotes.get(0).getId(), is(1));
        assertThat(quotes.get(0).getAuthor(), is("1A"));
        assertThat(quotes.get(0).getText(), is("1A_TEXT"));

        assertThat(quotes.get(1).getId(), is(2));
        assertThat(quotes.get(1).getAuthor(), is("2A"));
        assertThat(quotes.get(1).getText(), is("2A_TEXT"));


        Quote quote = em.find(Quote.class, this.quote.getId());
        assertThat(quote.getId(), is(2));
        assertThat(quote.getAuthor(), is("2A"));
        assertThat(quote.getText(), is("2A_TEXT"));
    }

}
