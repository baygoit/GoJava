package ua.com.goit.gojava7.kickstarter.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class CategoryTest {

	private Category category = new Category("category");

	@Test
	public void testCategoryAndGetName() {
		assertThat(category.getName(), is("category"));
	}

	@Test
	public void testGetProjectsNoProjects() {
		assertThat(category.getProjects().size(), is(0));
	}

	@Test
	public void testSetProjects() {
		Set<Project> projects = new HashSet<Project>();
		projects.add(new Project("project name", "short description", 123L, 5));

		category.setProjects(projects);
		assertThat(category.getProjects().size(), is(1));
	}

}
