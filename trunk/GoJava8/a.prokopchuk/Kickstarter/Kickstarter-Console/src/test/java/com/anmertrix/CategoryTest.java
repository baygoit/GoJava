package com.anmertrix;

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
	
}
