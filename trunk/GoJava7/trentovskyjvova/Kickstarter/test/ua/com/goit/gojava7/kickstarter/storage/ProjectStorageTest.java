package ua.com.goit.gojava7.kickstarter.storage;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.domain.Project;

public class ProjectStorageTest {
	
	private ProjectStorage projectStorage = new ProjectStorage();
	private Project project = new Project("Project", 1);
	List<Project> projects = new ArrayList<>();
	
	@Before
	public void setUp() {
		projects.add(project);
		projectStorage.setProjects(projects);
	}

	@Test
	public void testEmpty() {
		projectStorage = new ProjectStorage();
		assertThat(projectStorage.getProjects().size(), is(0));
	}

	@Test
	public void testGetProjects() {
		assertThat(projectStorage.getProjects().size(), is(1));
	}

	@Test
	public void testGetNegative() {
		assertThat(projectStorage.getProject(-1), nullValue());
	}

	@Test
	public void testGet() {
		assertThat(projectStorage.getProject(1).getName(), is(project.getName()));
	}
	
	@Test
	public void testSetProjects() {
		Project project = new Project("text", 1);
		List<Project> projects = new ArrayList<>();
		projects.add(project);

		projectStorage.setProjects(projects);
		assertThat(projectStorage.getProject(1), notNullValue());
	}
	
	@Test
	public void TestGetProject() {
		List<Project> projects = new ArrayList<>(); 
		projects.add(new Project("Project 1", 334));
		projects.add(new Project("text 2", 2));
		
		projectStorage.setProjects(projects);
		assertThat(projectStorage.getProject(334).getName(), is("Project 1"));
		assertThat(projectStorage.getProject(2).getName(), is("text 2"));
	}
}
