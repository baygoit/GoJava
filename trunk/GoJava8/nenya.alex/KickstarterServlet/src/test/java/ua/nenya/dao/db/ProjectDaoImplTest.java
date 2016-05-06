package ua.nenya.dao.db;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

import ua.nenya.dao.ProjectDao;
import ua.nenya.domain.Category;
import ua.nenya.domain.Payment;
import ua.nenya.domain.Project;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={ "classpath:aplicationContextTest.xml"})
public class ProjectDaoImplTest {
	
	@PersistenceContext
	private EntityManager em;

	@Autowired
	private ProjectDao projectDao;
	private List<Project> projects = new ArrayList<>();
	private Project project1;
	private Project project2;
	private Category music;
	
	@Before
	public void setUp() {
		initProjects();
	}
		
	@After
	public void tearDown() {
		em.createQuery("DELETE FROM Payment").executeUpdate();
		em.createQuery("DELETE FROM Project").executeUpdate();
		em.createQuery("DELETE FROM Category").executeUpdate();
	}
	
	@Test
	public void testGetProjectsByCategoryId() {
		List<Project> testProjects = projectDao.getProjectsByCategoryId(music.getId());
		assertNotNull(testProjects);
		assertThat(testProjects.get(0).getName(), is(projects.get(0).getName()));
		assertThat(testProjects.get(1).getName(), is("song2"));
		assertThat(testProjects.get(1).getId(), is(project2.getId()));
	}

	@Test
	public void testGetProjectByProjectId(){
		Project testProject = projectDao.getProjectByProjectId(project1.getId());
		assertThat(testProject.getName(), is(project1.getName()));
	}

	@Test
	public void testIsProjectExistYes() {
		assertThat(projectDao.isProjectExist(project1.getId()), is(true));
		assertThat(projectDao.isProjectExist(project2.getId()), is(true));
	}
	
	@Test
	public void testIsProjectExistNo() {
		assertThat(projectDao.isProjectExist(100L), is(false));
	}
	
	private void initProjects() {
		Category musicCategory = new Category();
		musicCategory.setName("Music");
		music = em.merge(musicCategory);
		
		Project songProject1 = new Project();
		songProject1.setName("song1");
		songProject1.setDescription("Funny song!");
		songProject1.setNeededAmount(2000);
		songProject1.setRemainingDays(7);
		songProject1.setHistory("History");
		songProject1.setVideo("video");
		songProject1.setCategory(music);
		
		Project songProject2 = new Project();
		songProject2.setName("song2");
		songProject2.setDescription("Sad song!");
		songProject2.setNeededAmount(400);
		songProject2.setRemainingDays(3);
		songProject2.setHistory("History");
		songProject2.setVideo("video");
		songProject2.setCategory(music);
		
		project1 = em.merge(songProject1);
		project2 = em.merge(songProject2);
		
		projects.add(songProject1);
		projects.add(songProject2);
		
		Payment payment1 = new Payment();
		payment1.setAmount(100);
		payment1.setProject(project1);
		em.merge(payment1);
		
		Payment payment2 = new Payment();
		payment2.setAmount(200);
		payment2.setProject(project2);
		em.merge(payment2);
		
		Collections.sort(projects, new Comparator<Project>() {
			@Override
			public int compare(Project o1, Project o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
	}
}
