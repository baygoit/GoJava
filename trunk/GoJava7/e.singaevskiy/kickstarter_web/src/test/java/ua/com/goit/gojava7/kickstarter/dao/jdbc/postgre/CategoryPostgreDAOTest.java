package ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.dao.IntegrationTest;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre.CategoryPostgreDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class CategoryPostgreDAOTest implements IntegrationTest{
	
	@Autowired
    CategoryPostgreDAO categoryPostgreDAO;
    
    List<Category> list;

    @Before
    public void setUp() throws Exception {
    	categoryPostgreDAO.clear();
        list = new ArrayList<>();
        list.add(new Category(1, "c1"));
        list.add(new Category(2, "c2"));
        categoryPostgreDAO.addAll(list);
    }

    @Test
    public void testAddGetAll() { 
        assertThat(categoryPostgreDAO.getAll(), is(list));
    }
    
    @Test
    public void testAddGet() {
    	categoryPostgreDAO.clear();
        list.forEach(categoryPostgreDAO::add);
        Category category = list.get(0);
        assertThat(categoryPostgreDAO.get(category.getId()), is(category));
    }

}
