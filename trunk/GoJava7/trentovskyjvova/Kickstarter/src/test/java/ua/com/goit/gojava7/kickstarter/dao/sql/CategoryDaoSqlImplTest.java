package ua.com.goit.gojava7.kickstarter.dao.sql;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:H2/H2ApplicationContext*.xml")
@Transactional
public class CategoryDaoSqlImplTest {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private CategoryDao categoryDao;
    
    @Test
	public void testGetCategoriesEmpty(){
    	assertThat(categoryDao.getCategories().isEmpty(), is(true));
    }
	
	@Test
	public void testGetCategory() {
		
		ua.com.goit.gojava7.kickstarter.domain.Category category1 = new ua.com.goit.gojava7.kickstarter.domain.Category();
		category1.setName("Category 1");

		ua.com.goit.gojava7.kickstarter.domain.Category category2 = new ua.com.goit.gojava7.kickstarter.domain.Category();
		category2.setName("Category 2");
		
		em.persist(category1);
		em.persist(category2);
		
		ua.com.goit.gojava7.kickstarter.domain.Category category = categoryDao.getCategory(category2.getId());
		
		assertThat(category.getName(), is("Category 2"));
	}

	@Test
	public void testGetCategories() {
		
		ua.com.goit.gojava7.kickstarter.domain.Category category1 = new ua.com.goit.gojava7.kickstarter.domain.Category();
		category1.setName("Category 1");

		ua.com.goit.gojava7.kickstarter.domain.Category category2 = new ua.com.goit.gojava7.kickstarter.domain.Category();
		category2.setName("Category 2");
		
		em.persist(category1);
		em.persist(category2);

		assertThat(categoryDao.getCategories().size(), is(2));
	}

}
