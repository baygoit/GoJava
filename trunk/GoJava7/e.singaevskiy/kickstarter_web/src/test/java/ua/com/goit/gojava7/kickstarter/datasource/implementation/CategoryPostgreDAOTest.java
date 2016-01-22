package ua.com.goit.gojava7.kickstarter.datasource.implementation;

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
import ua.com.goit.gojava7.kickstarter.datasource.IntegrationTest;
import ua.com.goit.gojava7.kickstarter.datasource.implementation.CategoryPostgreDAO;

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
        Category category1 = new Category();
        category1.setName("c1");
        Category category2 = new Category();
        category2.setName("c2");
		list.add(category1);
		list.add(category2);
    }

    @Test
    public void testAddGetAll() { 
    	categoryPostgreDAO.addAll(list);
        assertThat(categoryPostgreDAO.getAll(), is(list));
    }
    
    @Test
    public void testAddGet() {
        list.forEach(categoryPostgreDAO::add);
        Category category = list.get(0);
        assertThat(categoryPostgreDAO.get(category.getId()), is(category));
    }

}
