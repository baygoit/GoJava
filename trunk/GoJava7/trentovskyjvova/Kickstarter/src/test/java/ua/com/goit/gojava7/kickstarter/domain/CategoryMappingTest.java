package ua.com.goit.gojava7.kickstarter.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:H2/H2ApplicationContext*.xml")
@Category(IntegrationTest.class)
@Transactional
public class CategoryMappingTest {
	@PersistenceContext
	private EntityManager em;

	@Test
	public void testBasicUsage() {

		ua.com.goit.gojava7.kickstarter.domain.Category category1 = new ua.com.goit.gojava7.kickstarter.domain.Category();
		category1.setName("Category 1");

		ua.com.goit.gojava7.kickstarter.domain.Category category2 = new ua.com.goit.gojava7.kickstarter.domain.Category();
		category2.setName("Category 2");
		
		Project project1 = new Project();
		project1.setName("ProjectName1");
		project1.setCategory(category2);		
		
		category1.getProjects().add(project1);

		em.persist(category1);
		em.persist(category2);
		
		ua.com.goit.gojava7.kickstarter.domain.Category category = em
				.find(ua.com.goit.gojava7.kickstarter.domain.Category.class, category2.getId());

		assertThat(category.getName(), is(category2.getName()));
	}
}
