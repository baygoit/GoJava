package com.anmertrix.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
@ContextConfiguration(locations = { "classpath:testApplicationContext.xml" })
public class ProjectMappingTest {

	@PersistenceContext
	private EntityManager em;
	private Project project;
	//private Category category1;
	//private Category category2;

	@Before
	public void setUp() {
		Project project1 = new Project();
		project1.setName("Project1");
		//category1 = new Category();
		//project1.setCategory(category1);
		project1.setDescription("description1");
		project1.setFinalDate(new Date(700000000));
		project1.setHistory("history1");
		project1.setRequiredBudget(100);
		project1.setUrl("url1");
		
		Project project2 = new Project();
		project2.setName("Project2");
		//category2 = new Category();
		//project1.setCategory(category2);
		project2.setDescription("description2");
		project2.setFinalDate(new Date(800000000));
		project2.setHistory("history2");
		project2.setRequiredBudget(400);
		project2.setUrl("url2");
		
		//em.merge(category1);
		//em.merge(category2);
		em.merge(project1);
		project = em.merge(project2);
	}

	@After
	public void tearDown() {
		em.createQuery("DELETE FROM Project").executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testBasicUsage() {
		List<Project> projects = em.createQuery("FROM Project").getResultList();
		assertThat(projects.get(0).getName(), is("Project1"));
		assertThat(projects.get(0).getId(), is(1L));
		//assertThat(projects.get(0).getCategory(), is(category1));
		assertThat(projects.get(0).getDescription(), is("description1"));
		assertThat(projects.get(0).getFinalDate(), is(new Date(700000000)));
		assertThat(projects.get(0).getHistory(), is("history1"));
		assertThat(projects.get(0).getRequiredBudget(), is(100));
		assertThat(projects.get(0).getUrl(), is("url1"));
		
		assertThat(projects.get(1).getName(), is("Project2"));
		assertThat(projects.get(1).getId(), is(2L));
		//assertThat(projects.get(0).getCategory(), is(category2));
		assertThat(projects.get(1).getDescription(), is("description2"));
		assertThat(projects.get(1).getFinalDate(), is(new Date(800000000)));
		assertThat(projects.get(1).getHistory(), is("history2"));
		assertThat(projects.get(1).getRequiredBudget(), is(400));
		assertThat(projects.get(1).getUrl(), is("url2"));

		Project projectTest = em.find(Project.class, project.getId());
		assertThat(projectTest.getName(), is("Project2"));
		assertThat(projectTest.getId(), is(2L));
	}
	
}
