package com.kickstarter.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

public abstract class ProjectsTest {
	
	private Projects projects;
	
	@Before
	public  void setUp() {
		projects = getProjects ();
	}
	
	abstract Projects getProjects();
	
	@Test
	public void shouldEmptyProjectsList_whenNoProjects() {
		Сategory category1 = new Сategory("Sport");
		int size = 0;
		assertEquals(size, projects.getProjects(category1).size());
	}
	
	@Test
	public void shouldTwoProjects_whenAddTwoProjects() {
		Сategory category = new Сategory("Music");
		Project project = new Project("Food","description","history","url",12,23,4);
		Project project2 = new Project("Asasas","description","history","url",45,67,900);
		
		project.setСategory(category);
		project2.setСategory(category);
		
		projects.add(project);
		projects.add(project2);
		
		projects.getProjects(category);
		Project projectResult = projects.get(1);
		
		assertSame(project, projectResult);
		
		int i = 2;
		int projectResult2 = projects.getSize();
		
		assertSame(i, projectResult2);	
	}

}
