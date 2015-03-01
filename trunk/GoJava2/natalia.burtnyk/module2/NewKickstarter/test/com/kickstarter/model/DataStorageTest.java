package com.kickstarter.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

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
}