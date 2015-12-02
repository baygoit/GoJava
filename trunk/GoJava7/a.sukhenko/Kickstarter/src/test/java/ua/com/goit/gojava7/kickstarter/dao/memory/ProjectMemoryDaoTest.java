package ua.com.goit.gojava7.kickstarter.dao.memory;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import ua.com.goit.gojava7.kickstarter.config.DataSource;
import ua.com.goit.gojava7.kickstarter.dao.DaoFactory;
import ua.com.goit.gojava7.kickstarter.dao.storage.ProjectStorage;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.User;

public class ProjectMemoryDaoTest{
	DataSource dataSource = DataSource.MEMORY;
	DaoFactory daoFactory = new DaoFactory(dataSource);
	ProjectStorage projectStorage= daoFactory.getProjectStorage();
	@Test
	public void testProjectMemoryDao() {
		assertNotNull(projectStorage);
	}

	@Test
	public void testGetByNumber() {
		int last = projectStorage.getAll().size();
		Project project = new Project();
		projectStorage.add(project);
		assertThat(projectStorage.getByNumber(last),is(project));
	}

	@Test
	public void testUpdatePledged() {
	
	}

	@Test
	public void testGetPledged() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetByCategory() {
		Category category = new Category();
		category.setCategoryId(155);
		final String testCategoryName = "TestCategoryName";
		category.setCategoryName(testCategoryName);
		Project project = new Project("TestName", "TestDescription", 901, null);
		project.setCategoryName(testCategoryName);
		List<Project> projects = Arrays.asList(project);
		projectStorage.add(project);
		projectStorage.setAll(projects);
		assertThat(projectStorage.getByCategory(testCategoryName), is(projects));
	}

	@Test
	public void testUserContributeToProject() {
		User user = new User();
		//assertThat(projectStorage.getPledged(projectName))
		projectStorage.userContributeToProject(user, 45123.0,"Project Test");
	}

	@Test
	public void testAddProject() {
		int last = projectStorage.getAll().size();
		Project project = new Project();
		projectStorage.add(project);
		assertThat(projectStorage.getByNumber(last), is(project));
	}

}
