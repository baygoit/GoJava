package ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ua.com.goit.gojava7.kickstarter.dao.IntegrationTest;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext*.xml")
public class QuotePostgreDAOTest  implements IntegrationTest{

	@Autowired
    QuotePostgreDAO quotePostgreDAO;
    List<Quote> list;

    @Before
    public void setUp() throws Exception {
    	quotePostgreDAO.clear();
        list = new ArrayList<>();
        list.add(new Quote("a1", "t1"));
		list.add(new Quote("a2", "t2"));
		list.add(new Quote("a3", "t3"));
    }

    @Test
    public void testAddGetAll() {
    	quotePostgreDAO.addAll(list);
        assertThat(quotePostgreDAO.getAll(), is(list));
    }

    @Test
    public void testAddGet() {
        quotePostgreDAO.add(new Quote("a0", "t0"));
        quotePostgreDAO.add(new Quote("a1", "t1"));
        quotePostgreDAO.add(new Quote("a2", "t2"));
        Quote quote = quotePostgreDAO.getAll().get(0);
        assertThat(quotePostgreDAO.get(quote.getId()), is(quote));
    }
    
    @Test
    public void testGetRandom() {
        quotePostgreDAO.addAll(list);
    	Quote random = quotePostgreDAO.getRandom();
    	assertTrue(list.contains(random));
    }

}
