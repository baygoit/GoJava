package com.kickstarter.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CategoriesStorageTest {
	
	private CategoriesStorage categoriesStorage;

	@Before
	public void setUp() {
		categoriesStorage = new CategoriesStorage();
	}
	
	@Test
	public void shouldListContainsCategory_whenAddCategory() {
		Сategory category = new Сategory("Food");
		categoriesStorage.addCategory(category);
		assertTrue(categoriesStorage.getCategoriesList().contains(category));
	}
	
	@Test
	public void shouldSize0_whenNoCategory() {
		int size = 0;
		assertEquals(size, categoriesStorage.getSizeCategories());
	}
	
	@Test
	public void shouldGetCategoryByIndexPlus1() {
		Сategory category1 = new Сategory("Sport");
		categoriesStorage.addCategory(category1);
		assertSame(category1, categoriesStorage.getSpecificCategory(1));
	}	
	
	@Test
	public void shouldSizeTwo_whenCategorytwo() {
		int size = 2;
		categoriesStorage.addCategory(new Сategory("Music"));
		categoriesStorage.addCategory(new Сategory("Sport"));		
		assertEquals(size, categoriesStorage.getSizeCategories());
	}
	
}