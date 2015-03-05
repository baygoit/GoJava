package com.kickstarter.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class DataStorageTest {
	
	private QuoteStorage quoteStorage;
	private CategoryStorage categoryStorage;
	private ProjectStorage projectStorage;
	
	@Before
	public void setUp() {
		quoteStorage = new QuoteStorage();
		categoryStorage = new CategoryStorage();
		projectStorage = new ProjectStorage ();
	}
	
	@Test
	public void shouldListContainsCategory_whenAddCategory() {
		Сategory category = new Сategory("Food");
		categoryStorage.addCategory(category);
		assertTrue(categoryStorage.getCategoriesList().contains(category));
	}
	
	@Test
	public void shouldSize0_whenNoCategory() {
		int size = 0;
		assertEquals(size, categoryStorage.getSizeCategories());
	}
	
	@Test
	public void shouldGetCategoryByIndexPlus1() {
		Сategory category1 = new Сategory("Sport");
		categoryStorage.addCategory(category1);
		assertSame(category1, categoryStorage.getSpecificCategory(1));
	}	
	
	@Test
	public void shouldSizeTwo_whenCategorytwo() {
		int size = 2;
		categoryStorage.addCategory(new Сategory("Music"));
		categoryStorage.addCategory(new Сategory("Sport"));		
		assertEquals(size, categoryStorage.getSizeCategories());
	}
	
	@Test
	public void shouldEmptyProjectsList_whenNoProjects() {
		Сategory category1 = new Сategory("Sport");
		categoryStorage.addCategory(category1);
		int size = 0;
		assertEquals(size, projectStorage.getSpecificProjects(category1).size());
	}
	
	@Test
	public void shouldTwoProjects_whenAddTwoProjects() {
		Сategory category = new Сategory("Music");
		Project project = new Project("Food","description","history","url",12,23,4);
		Project project2 = new Project("Asasas","description","history","url",45,67,900);
		
		project.setСategory(category);
		project2.setСategory(category);
		
		projectStorage.addProject(project);
		projectStorage.addProject(project2);
		
		projectStorage.getSpecificProjects(category);
		Project projectResult = projectStorage.getProject(1);
		
		assertSame(project, projectResult);
		
		int i = 2;
		int projectResult2 = projectStorage.getSizeProjectsOfCategory();
		
		assertSame(i, projectResult2);	
	}
}