package ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.domain.Quote;

public class QuotePostgreDAOTest {

    QuotePostgreDAO dao;
    List<Quote> list;

    @Before
    public void setUp() throws Exception {

        dao = new QuotePostgreDAO();
		dao.setJdbcTemplate(TestDaoFactory.setupJdbcTemplate()); 
        
        list = new ArrayList<>();
        list.add(new Quote("a1", "t1"));
        list.add(new Quote("a2", "t2"));

    }
    
    @After
    public void tearDown() throws Exception {
        dao.clear();
    }

    @Test
    public void testAddGetAll() {   
        dao.addAll(list);
        assertThat(dao.getAll(), is(list));
    }

    @Test
    public void testAddGet() {
        Quote element = new Quote("a3", "t3");
        dao.add(new Quote("a0", "t0"));
        dao.add(element);
        dao.add(new Quote("a2", "t2"));
        assertThat(dao.get(1), is(element));
    }

}
