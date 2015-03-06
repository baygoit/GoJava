package com.kickstarter.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import org.junit.Before;
import org.junit.Test;

public class ProgectsStorageTest {
	
	private ProjectsStorage projectsStorage;
	
	@Before
	public void setUp() {
		projectsStorage = new ProjectsStorage ();
	}
	
	@Test
	public void shouldEmptyProjectsList_whenNoProjects() {
		Сategory category1 = new Сategory("Sport");
		int size = 0;
		assertEquals(size, projectsStorage.getSpecificProjects(category1).size());
	}
	
	@Test
	public void shouldTwoProjects_whenAddTwoProjects() {
		Сategory category = new Сategory("Music");
		Project project = new Project("Food","description","history","url",12,23,4);
		Project project2 = new Project("Asasas","description","history","url",45,67,900);
		
		project.setСategory(category);
		project2.setСategory(category);
		
		projectsStorage.addProject(project);
		projectsStorage.addProject(project2);
		
		projectsStorage.getSpecificProjects(category);
		Project projectResult = projectsStorage.getProject(1);
		
		assertSame(project, projectResult);
		
		int i = 2;
		int projectResult2 = projectsStorage.getSizeProjectsOfCategory();
		
		assertSame(i, projectResult2);	
	}

}
