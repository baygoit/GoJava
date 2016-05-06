package ua.nenya.domain;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import static org.hamcrest.CoreMatchers.is;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:aplicationContextTest.xml" })
public class ProjectMapingTest {

	@PersistenceContext
	private EntityManager em;
	private Project p;
	private Category c;
	
	@Before
	public void setUp() {
		Category category = new Category();
		category.setName("Category");
		c = em.merge(category);
		
		Project project = new Project();
		project.setDescription("description");
		project.setHistory("history");
		project.setName("project");
		project.setNeededAmount(100);
		project.setRemainingDays(7);
		project.setVideo("video");
		project.setCategory(c);
		p = em.merge(project);
	}
	
	@After
	public void tearDown() {
		em.createQuery("DELETE FROM Project").executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testProjectUsage1() {
		Query query = em.createQuery("FROM Project");
		List<Project> projects = query.getResultList();
		assertThat(projects.get(0).getDescription(), is("description"));
		assertThat(projects.get(0).getHistory(), is("history"));
		assertThat(projects.get(0).getName(), is("project"));
		assertThat(projects.get(0).getNeededAmount(), is(100));
		assertThat(projects.get(0).getRemainingDays(), is(7));
		assertThat(projects.get(0).getVideo(), is("video"));

		Project projectTest = em.find(Project.class, p.getId());
		assertThat(projectTest.getDescription(), is("description"));
		assertThat(projectTest.getHistory(), is("history"));
		assertThat(projectTest.getName(), is("project"));
		assertThat(projectTest.getNeededAmount(), is(100));
		assertThat(projectTest.getRemainingDays(), is(7));
		assertThat(projectTest.getVideo(), is("video"));
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testProjectUsage2() {
		Query query = em.createNamedQuery("Project.getByCategoryId");
		query.setParameter("categoryId", c.getId());
		List<Project> projects = query.getResultList();
		assertThat(projects.get(0).getDescription(), is("description"));
		assertThat(projects.get(0).getHistory(), is("history"));
		assertThat(projects.get(0).getName(), is("project"));
		assertThat(projects.get(0).getNeededAmount(), is(100));
		assertThat(projects.get(0).getRemainingDays(), is(7));
		assertThat(projects.get(0).getVideo(), is("video"));
	}
	
	@Test
	public void testProjectUsage3() {
		Query query = em.createNamedQuery("Project.Count");
		query.setParameter("projectId", p.getId());
		long count = (long) query.getSingleResult();
		assertThat(count, is(1L));
	}

}
