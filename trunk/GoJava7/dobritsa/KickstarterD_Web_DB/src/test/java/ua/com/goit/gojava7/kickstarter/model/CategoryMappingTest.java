package ua.com.goit.gojava7.kickstarter.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/H2/H2ApplicationContext*.xml")
@Transactional
public class CategoryMappingTest {

	@PersistenceContext
	private EntityManager em;

	@Test
	public void testBasicUsage() {

		Category category1 = new Category();
		category1.setName("TestCategory 1");

		Category category2 = new Category();
		category2.setName("TestCategory 2");
		
		Project project1 = new Project();
		project1.setName("TestName1");
		project1.setDescription("TestDescription1");
		project1.setGoal(100L);
		project1.setDaysToGo(1L);
		project1.setHistory("TestHistory1");
		project1.setLink("TestLink1");
		project1.setCategory(category1);		
		
		category1.getProjects().add(project1);

		em.persist(category1);
		em.persist(category2);

		System.out.println("\n-----Get by id = 1-----");
		Category category = em.find(Category.class, 1L);;
		System.out.println(category);

//		System.out.println("\n-----Get list of categories-----");
//		List<Category> categories = (List<Category>) session.createQuery("from Category q").list();
//		for (Category resultCategory : categories) {
//			System.out.println(resultCategory);
//		}

	}
}
