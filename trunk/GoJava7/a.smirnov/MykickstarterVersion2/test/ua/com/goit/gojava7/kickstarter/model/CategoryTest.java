package ua.com.goit.gojava7.kickstarter.model;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Set;

import org.junit.Test;

public class CategoryTest {

	Category category = new Category("Movie");
	Project project1 = new Project("Football game", "The best game in the world", 10_000);
	Project project2 = new Project("Baseball game", "The worst game in the world", 12_000);
	
	@Test
	public void testCategory() {
		assertThat(category.getName(), is("Movie"));
	}

	@Test
	public void testGetName() {
		assertThat(category.getName(), is("Movie"));
	}

	@Test
	public void testSetName() {
		category.setName("Film");
		assertThat(category.getName(), is("Film"));
	}

	@Test
	public void testAddProjectToCategory() {
		category.addProjectToCategory(project1);
		category.addProjectToCategory(project2);
		assertThat(category.getAllProjectsFromCategory().size(), is(2));
	}

	@Test
	public void testDeleteProjectToCategory() {
		category.addProjectToCategory(project1);
		category.addProjectToCategory(project2);
		
		category.deleteProjectToCategory(project1);
		category.deleteProjectToCategory(project2);
		assertThat(category.getAllProjectsFromCategory().isEmpty(), is(true));
	}

	@Test
	public void testGetAllProjectsFromCategory() {
		category.addProjectToCategory(project1);
		category.addProjectToCategory(project2);
		Set<Project> projects = category.getAllProjectsFromCategory();
		assertThat(projects.size(), is(2));
	}

	@Test
	public void testCompareTo() {
		Category category2 = new Category("Sports");
		int result = category.getName().compareTo(category2.getName());
		assertThat(result == 0, is(false));
	}
}
