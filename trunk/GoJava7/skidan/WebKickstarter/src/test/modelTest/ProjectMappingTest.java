package modelTest;

import static org.junit.Assert.assertEquals;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.kickstarter.dao.Interfaces.ProjectDao;
import com.kickstarter.model.Category;
import com.kickstarter.model.Project;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContextForTest.xml")
public class ProjectMappingTest {

	@Autowired
	ProjectDao projectDao;

	@PersistenceContext
	EntityManager entityManager;

	@Before
	@Transactional
	public void setUp() throws Exception {
		Category category = new Category();
		category.setTitle("firstTitle");

		Project project = new Project();
		project.setTitle("Project1");
		project.setCategory(category);

		Project project1 = new Project();
		project1.setTitle("Project2");
		project1.setCategory(category);

		entityManager.persist(project);
		entityManager.persist(project1);

	}

	@Test
	@Transactional
	public void test() {

		assertEquals(projectDao.getAllProjectsForCategory(1).get(0).getTitle(), "Project1");
		assertEquals(projectDao.getAllProjectsForCategory(1).get(1).getTitle(), "Project2");

		assertEquals(projectDao.getOneProject(1).getTitle(), "Project1");
	}

}
