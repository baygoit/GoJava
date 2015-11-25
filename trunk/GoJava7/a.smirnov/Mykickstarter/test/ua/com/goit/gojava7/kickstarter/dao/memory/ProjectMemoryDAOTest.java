package ua.com.goit.gojava7.kickstarter.dao.memory;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.beans.Category;
import ua.com.goit.gojava7.kickstarter.beans.Project;

public class ProjectMemoryDAOTest {

	private ProjectMemoryDAO projectMemory;
	private Project project;
	private Category category;
	
	@Before
	public void setUp() throws Exception {
		projectMemory = new ProjectMemoryDAO();
		project = new Project("Project 1", "XXX", 10_000);
		project.setUniqueID(6);		
		category = new Category("Ukraine");
		category.setUniqueID(10);
		project.setCategoryID(10);
	}

	@Test
	public void testGetProjectsFromCategory() {
		projectMemory.add(project);
		assertThat(projectMemory.getProjectsFromCategory(category).size(), is(1));
		assertThat(projectMemory.getProjectsFromCategory(category).get(0).getCategoryID(), is(10));
	}

	@Test
	public void testProjectMemoryDAO() {
		assertThat(projectMemory.getSize(), is(5));
	}

	@Test
	public void testAdd() {
		projectMemory.add(project);
		assertThat(projectMemory.getSize(), is(6));
	}

	@Test
	public void testRemove() {
		projectMemory.add(project);
		assertThat(projectMemory.getAll().size(), is(6));
		
		projectMemory.remove(project);
		assertThat(projectMemory.getAll().size(), is(5));
	}

	@Test
	public void testGetAll() {
		assertThat(projectMemory.getAll().size(), is(5));
		assertThat(projectMemory.getAll().get(0).getTitle(), is("Project 1"));
		assertThat(projectMemory.getAll().get(1).getTitle(), is("Project 2"));
		assertThat(projectMemory.getAll().get(2).getTitle(), is("Project 3"));
		assertThat(projectMemory.getAll().get(3).getTitle(), is("Project 4"));
		assertThat(projectMemory.getAll().get(4).getTitle(), is("Project 5"));
	}

	@Test
	public void testGetSize() {
		assertThat(projectMemory.getSize(), is(5));
	}

}
