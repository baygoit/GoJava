package ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Properties;

import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.beans.Quote;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.JdbcDispatcher;
import ua.com.goit.gojava7.kickstarter.dao.memory.util.Memory;
import ua.com.goit.gojava7.kickstarter.util.Utils;

public class QuotePostgreDAOTest {

    Memory mem;
    QuotePostgreDAO dao;

    @Before
    public void setUp() throws Exception {

        Properties properties = Utils.readProperties("./kicks-files/config.properties");

        JdbcDispatcher dispatcher = new JdbcDispatcher(
                properties.getProperty("driver"),
                properties.getProperty("url"),
                properties.getProperty("user"), 
                properties.getProperty("password"));
        
        dao = new QuotePostgreDAO(dispatcher);

        mem = new Memory();

        dao.clear();

    }

    @Test
    public void testAddGetAll() {
        dao.addAll(mem.getQuotes());
        assertThat(dao.getAll(), is(mem.getQuotes()));
    }

    @Test
    public void testAddGet() {
        Quote element = new Quote("a1", "t1");
        dao.add(new Quote("a0", "t0"));
        dao.add(element);
        dao.add(new Quote("a2", "t2"));
        assertThat(dao.get(1), is(element));
    }

    @Test
    public void testException() {
        Quote element = new Quote("a1", "t1");
        dao.add(element);
        dao.add(element);
    }

}
