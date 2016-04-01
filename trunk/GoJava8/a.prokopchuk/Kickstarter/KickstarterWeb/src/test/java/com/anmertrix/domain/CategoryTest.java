package com.anmertrix.domain;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.anmertrix.domain.Category;
import com.anmertrix.domain.Project;

public class CategoryTest {

	@Test
	public void getNameCategoryTest() {
		Category category = new Category("test");
		assertTrue("test" == category.getName());
	}
	
	@Test
	public void setGetProjectTest() {
		Category category = new Category("test");
		Project project = new Project();
		category.setProject(project);
		assertTrue(project == category.getProjects().get(0));
		assertTrue(project == category.getProject(0));
	}
	
	@Test
	public void setGetNameTest() {
		Category category = new Category();
		category.setName("test2");
		assertTrue("test2" == category.getName());
	}
	
	@Test
	public void checkProjectsListTest() {
		Category category = new Category("test");
		Project project = new Project();
		category.setProject(project);
		assertTrue(1 == category.getProjects().size());
	}
	
}
