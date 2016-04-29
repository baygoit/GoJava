package ua.nenya.dao.db;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ua.nenya.dao.ProjectDao;
import ua.nenya.domain.Project;
@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={ "classpath:aplicationContextTest.xml"})
public class ProjectDaoImplTest {
	

	private static EmbeddedDatabase db;
	@Autowired
	private ProjectDao projectDao;
	private static List<Project> projects = new ArrayList<>();
	private static Project songProject2;
	
	@BeforeClass
	public static void setUp() {
		initProjects();
		db = new EmbeddedDatabaseBuilder()
	    		.setType(EmbeddedDatabaseType.H2)
	    		.addScript("/createProject.sql")
	    		.addScript("/insertProject.sql")
	    		.build();
	}
	@AfterClass
	public static void tearDown() {
		db = new EmbeddedDatabaseBuilder()
	    		.setType(EmbeddedDatabaseType.H2)
	    		.addScript("/deleteProject.sql")
	    		.build();
	}
	
	@Test
	public void testGetProjects() {

		Collections.sort(projects, new Comparator<Project>() {
			@Override
			public int compare(Project o1, Project o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		
		List<Project> testProjects = projectDao.getProjectsByCategoryId(10);
		assertNotNull(testProjects);
		assertThat(testProjects.get(0).getName(), is(projects.get(0).getName()));
	}

	@Test
	public void testGetProject(){
		Project testProject = projectDao.getProjectByProjectId(2);
		assertThat(testProject.getName(), is(songProject2.getName()));
	}

	@Test
	public void testIsProjectExistYes() {
		assertThat(projectDao.isProjectExist(2), is(true));
	}
	
	@Test
	public void testIsProjectExistNo() {
		assertThat(projectDao.isProjectExist(12), is(false));
	}

	
	
	private static void initProjects() {
		Project songProject1 = new Project();
		songProject1.setId(1);
		songProject1.setName("song1");
		songProject1.setDescription("Funny song!");
		songProject1.setNeededAmount(2000);
		songProject1.setRemainingDays(7);
		songProject1.setHistory("History");
		songProject1.setVideo("video");
		
		songProject2 = new Project();
		songProject2.setId(2);
		songProject2.setName("song2");
		songProject2.setDescription("Sad song!");
		songProject2.setNeededAmount(400);
		songProject2.setRemainingDays(3);
		songProject2.setHistory("History");
		songProject2.setVideo("video");
		
		projects.add(songProject1);
		projects.add(songProject2);
	}
}
