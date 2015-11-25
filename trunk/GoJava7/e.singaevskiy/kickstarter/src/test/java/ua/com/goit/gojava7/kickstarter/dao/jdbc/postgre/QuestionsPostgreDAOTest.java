package ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import ua.com.goit.gojava7.kickstarter.beans.Question;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.JdbcDispatcher;
import ua.com.goit.gojava7.kickstarter.util.Utils;

public class QuestionsPostgreDAOTest {

    List<Question> list;
    QuestionsPostgreDAO dao;

    @Before
    public void setUp() throws Exception {
        Properties properties = Utils.readProperties("./src/test/resources/storages/db/config.properties");
        JdbcDispatcher dispatcher = new JdbcDispatcher(
                properties.getProperty("driver"),
                properties.getProperty("url"),
                properties.getProperty("user"), 
                properties.getProperty("password"));
        
        dao = new QuestionsPostgreDAO(dispatcher); 
        
        list = new ArrayList<>();
        list.add(new Question(0, "a1", "t1"));
        list.add(new Question(1, "a2", "t2"));
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
        dao.clear();
        dao.addAll(list);
        int index = 1;
        assertThat(dao.get(index), is(list.get(index)));
    }
    
    @SuppressWarnings("unchecked")
    @Test
    public void testException() throws Exception {
        JdbcDispatcher dispatcher = Mockito.mock(JdbcDispatcher.class);
        Mockito.when(dispatcher.getConnection()).thenThrow(SQLException.class);
        dao = new QuestionsPostgreDAO(dispatcher); 
        dao.clear();
        dao.addAll(list);
        dao.getAll();
        dao.getByProject(1);
    }
}
