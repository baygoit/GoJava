package ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ua.com.goit.gojava7.kickstarter.domain.Question;

@RunWith(MockitoJUnitRunner.class)
public class QuestionsPostgreDAOTest {

    List<Question> list;
    QuestionPostgreDAO dao;
    
    @Mock
    Connection connection;

    @Before
    public void setUp() throws Exception {
        dao = new QuestionPostgreDAO();
		dao.setJdbcTemplate(TestDaoFactory.setupJdbcTemplate()); 
        
        list = new ArrayList<>();
        list.add(new Question(0, "a1", "t1"));
        list.add(new Question(0, "a2", "t2"));
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
        list.forEach(dao::add);
        int index = 1;
        assertThat(dao.get(index), is(list.get(index)));
    }
}
