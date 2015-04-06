package com.gojava2.kickstarter.model;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public abstract class ProjectStorageTest {

	private ProjectStorage storage;
	
	@Before
	public void setUp() {
		storage = getStorage();
	}
	
	abstract ProjectStorage getStorage();
	
	@Test
	public void shouldCollectionSizeZero_whenNoProjects() {
		// when
		int expectedSize = 0;
		int actualSize = storage.getSize();
		
		// then
		assertEquals(expectedSize, actualSize);
	}
	
	 @Test
     public void shouldNoProjects_whenNoProjectsWithSameCategory() {
             // given
             Category category1 = new Category(1, "Art");
             
             Project project1 = new Project(1, "p1", "d1", 1, 1, 1, 1, "s1", "l1");
             project1.setCategory(category1);
             
             Project project2 = new Project(2, "p2", "d2", 1, 1, 1, 1, "s2", "l2");
             project2.setCategory(category1);
             
             storage.addProject(project1);
             storage.addProject(project2);
                             
             // when
             List<Project> result = storage.getProjects(new Category(3, "Sport"));
             int expectedSize = 0;
             
             // then
             assertEquals(expectedSize, result.size());
     }
	
	@Test
	public void shouldProjects_whenProjectsWithSameCategory() {
		// given
		Category category1 = new Category(1, "Art");
		Category category2 = new Category(2, "Dance");
		
		Project project1 = new Project(1, "p1", "d1", 1, 1, 1, 1, "s1", "l1");
		project1.setCategory(category1);
		
		Project project2 = new Project(2, "p2", "d2", 1, 1, 1, 1, "s2", "l2");
		project2.setCategory(category2);
		
		Project project3 = new Project(3, "p3", "d3", 1, 1, 1, 1, "s3", "l3");
		project3.setCategory(category2);
		
		storage.addProject(project1);
		storage.addProject(project2);
		storage.addProject(project3);
		
		// when
		List<Project> result = storage.getProjects(category2);
		int expectedSize = 2;
		
		// then
		assertEquals(expectedSize, result.size());
		assertEquals(project2, result.get(0));
		assertEquals(project3, result.get(1));
	}
	
	@Test
	public void shouldCurrentProjectByIndex_whenExistsCategory() {
		// given
		Category category = new Category(1, "Art");
		
		Project project = new Project(1, "p", "d", 1, 1, 1, 1, "s", "l");
		
		project.setCategory(category);
		storage.addProject(project);
		
		// when
		Project result = storage.getProject(1);
		
		// then
		assertEquals(project, result);
	}
}