package com.kickstarter.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class DataStorageTest {
	
	private DataStorage storage;
	
	@Before
	public void setUp() {
		storage = new DataStorage();
	}
	
	@Test
	public void shouldListContainsCategory_whenAddCategory() {
		// when
		Сategory category = new Сategory("Food");
		storage.addCategory(category);
		// then
		assertTrue(storage.getCategoriesList().contains(category));
	}
	
	@Test
	public void shouldSize0_whenNoCategory() {
		// when
		int size = 0;
		// then
		assertEquals(size, storage.getSizeCategories());
	}
	
	@Test
	public void shouldGetCategoryByIndexPlus1() {
		Сategory category1 = new Сategory("Sport");
		// when
		storage.addCategory(category1);
		// then
		assertSame(category1, storage.getSpecificCategory(1));
	}	
	
	@Test
	public void shouldSizeTwo_whenCategorytwo() {
		// when
		int size = 2;
		storage.addCategory(new Сategory("Music"));
		storage.addCategory(new Сategory("Sport"));		
		// then
		assertEquals(size, storage.getSizeCategories());
	}
	
	@Test
	public void shouldEmptyProjectsList_whenNoProjects() {
		Сategory category1 = new Сategory("Sport");
		storage.addCategory(category1);
		// when
		int size = 0;
		// then
		assertEquals(size, storage.getSpecificProjects(category1).size());
	}
	
	@Test
	public void shouldistContainsCategory_whenAddCategory() {
		// when
		Сategory category = new Сategory("Music");
		Project project = new Project("Food","description","history","url",12,23,4);
		project.setСategory(category);
		storage.addProject(project);
		
		List<Project> projects = storage.getSpecificProjects(category);
		Project projectResult = storage.getProject(1);
		
		// then
		assertSame(project, projectResult);
	}
	
}