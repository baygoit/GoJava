package modelTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import com.kickstarter.dao.Interfaces.CategoryDao;
import com.kickstarter.model.Category;
import com.kickstarter.model.Project;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContextForTest.xml")
public class CategoryMappingTest {

	@Autowired
	CategoryDao categoryDao;

	@PersistenceContext
	EntityManager entityManager;

	@Before
	@Transactional
	public void setUp() throws Exception {

		Category category = new Category();
		category.setTitle("title");
		List<Project> project = new ArrayList<>();
		project.add(new Project());
        category.setProject(project);
		
		Category category2 = new Category();
		category2.setTitle("title2");
        category2.setProject(project);

		entityManager.persist(category);
		entityManager.persist(category2);

	}

	@Test
	@Transactional
	public void categoryMappingTest() {
		
		List<Project> project = new ArrayList<>();
		project.add(new Project());
		
		List<Category> results = categoryDao.getAll();
		for(Category c: results){
			System.out.println(c.getTitle() + " id : " + c.getId() + c.getProject().iterator().next().toString());
		}
		assertTrue(results.size() == 2);
		assertTrue(results.get(0).getId() == 1);
        assertTrue(categoryDao.getByNumber(1).getId() == 1);
	}
}