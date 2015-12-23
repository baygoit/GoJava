package ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import ua.com.goit.gojava7.kickstarter.domain.Category;

@RunWith(value=MockitoJUnitRunner.class)
public class CategoryPostgreDAOTest {
	
    CategoryPostgreDAO dao;
    
    List<Category> list;

    @Before
    public void setUp() throws Exception {
  
        dao = new CategoryPostgreDAO();
		dao.setJdbcTemplate(TestDaoFactory.setupJdbcTemplate());
        
        list = new ArrayList<>();
        list.add(new Category(1, "c1"));
        list.add(new Category(2, "c2"));      
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
        Category element = new Category(1, "t1");
        dao.add(new Category(2, "t0"));
        dao.add(element);
        dao.add(new Category(3, "t2"));
        assertThat(dao.get(1), is(element));
    }

}
