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
public class ProjectMappingTest {
	@PersistenceContext
	private EntityManager em;

	@Test
	public void testBasicUsage() {

		ua.com.goit.gojava7.kickstarter.domain.Category category1 = new ua.com.goit.gojava7.kickstarter.domain.Category();
		category1.setName("TestCategory 1");
		
		Project project1 = new Project();
		project1.setName("Project 1");
		project1.setCategory(category1);
		
		Project project2 = new Project();
		project2.setName("Project 2");
		project1.setCategory(category1);
		
		em.persist(project1);
		em.persist(project2);

		Project project = em.find(Project.class, project1.getId());

		assertThat(project.getName(), is(project1.getName()));
		assertThat(project.getCategory(), is(category1));
	}
}