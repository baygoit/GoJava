package ua.home.kickstarter.model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import ua.home.kickstarter.content.Category;
import ua.home.kickstarter.content.Project;
import ua.home.kickstarter.controller.ProjectsController;

public class ProjectStorageTest {
	private List<Project> pr1;
	private Category category1;
	private Category category2;
	private ProjectStorage projectStorage;

	@Before
	public void setUp() {
		projectStorage = new ProjectStorage();
		new ProjectsController(projectStorage);
		category1 = new Category("Games");
		category2 = new Category("Technology");

		pr1 = new ArrayList<Project>();
		pr1.add(new Project("FakeName1", "Fakedescription1", 34534, 34, "linksToVideo1", category1));
		pr1.add(new Project("FakeName2", "Fakedescription1", 23123, 345, "linksToVideo1", category2));
		pr1.add(new Project("FakeName3", "Fakedescription1", 34534, 67, "linksToVideo1", category2));
	}

	@Test
	public void shouldReturnReturnCategory_whenCategorySetted() {
		assertEquals("Games", pr1.get(0).getCategory().getName());
		assertEquals("Technology", pr1.get(1).getCategory().getName());
		assertEquals("Technology", pr1.get(2).getCategory().getName());
	}

	@Test
	public void shouldPutProjectsToMapByCategory_whenProjectCategorySetted() {
		Map<Category, List<Project>> sortedProjects = projectStorage.putProjectsToMap(pr1);
		assertEquals(pr1.get(0), sortedProjects.get(category1).get(0));
		assertEquals(pr1.get(1), sortedProjects.get(category2).get(0));
		assertEquals(pr1.get(2), sortedProjects.get(category2).get(1));
	}
}
