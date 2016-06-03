package ua.nenya.service.impl;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ua.nenya.domain.Project;
import ua.nenya.service.ProjectService;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:aplicationContextTest.xml"})
public class ProjectServiceImplTest {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private ProjectService projectService;
	
	private Project project1;
	private Project project2;
	
	@Before
	public void setUp() {
		initProjects();
	}
		
	@After
	public void tearDown() {
		em.createQuery("DELETE FROM Payment").executeUpdate();
		em.createQuery("DELETE FROM Reward").executeUpdate();
		em.createQuery("DELETE FROM Project").executeUpdate();
		em.createQuery("DELETE FROM Category").executeUpdate();
	}
	
	@Test
	public void testIsProjectExistYes() {
		assertThat(projectService.isProjectExistById(project1.getId()), is(true));
		assertThat(projectService.isProjectExistById(project2.getId()), is(true));
	}
	
	@Test
	public void testIsProjectExistNo() {
		assertThat(projectService.isProjectExistById(100L), is(false));
	}

	private void initProjects() {
		
		Project songProject1 = new Project();
		songProject1.setName("song1");
		songProject1.setDescription("Funny song!");
		songProject1.setNeededAmount(2000);
		songProject1.setRemainingDays(7);
		songProject1.setHistory("History");
		songProject1.setVideo("video");
		
		Project songProject2 = new Project();
		songProject2.setName("song2");
		songProject2.setDescription("Sad song!");
		songProject2.setNeededAmount(400);
		songProject2.setRemainingDays(3);
		songProject2.setHistory("History");
		songProject2.setVideo("video");
		
		project1 = em.merge(songProject1);
		project2 = em.merge(songProject2);
		
	}
}
