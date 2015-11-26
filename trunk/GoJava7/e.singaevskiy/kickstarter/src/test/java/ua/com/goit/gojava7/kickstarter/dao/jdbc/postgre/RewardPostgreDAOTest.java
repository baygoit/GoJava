package ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import ua.com.goit.gojava7.kickstarter.dao.jdbc.util.JdbcDispatcher;
import ua.com.goit.gojava7.kickstarter.domain.Reward;
import ua.com.goit.gojava7.kickstarter.util.Utils;

public class RewardPostgreDAOTest {

    List<Reward> list;
    RewardPostgreDAO dao;

    @Before
    public void setUp() throws Exception {
        Properties properties = Utils.readProperties("./kicks-files/config.properties");
        JdbcDispatcher dispatcher = new JdbcDispatcher(
                properties.getProperty("driver"),
                properties.getProperty("url"),
                properties.getProperty("user"), 
                properties.getProperty("password"));
        
        list = new ArrayList<>();
        list.add(new Reward(1, 2, "r1", 113));
        list.add(new Reward(2, 2, "r2", 44));
        
        dao = new RewardPostgreDAO(dispatcher);         
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
        assertFalse(true);
    }
    
    @SuppressWarnings("unchecked")
    @Test
    public void testException() throws Exception {
        JdbcDispatcher dispatcher = Mockito.mock(JdbcDispatcher.class);
        Mockito.when(dispatcher.getConnection()).thenThrow(SQLException.class);
        dao = new RewardPostgreDAO(dispatcher); 
        dao.clear();
        dao.addAll(list);
        dao.getAll();
        dao.getByProject(1);
    }
}
