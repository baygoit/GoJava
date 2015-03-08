package com.kickstarter.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public abstract class CategoriesTest {
	
	private Categories categories;

	@Before
	public void setUp() {
		categories = getCategories();
	}
	
	abstract Categories getCategories();

	@Test
	public void shouldListContainsCategory_whenAddCategory() {
		Сategory category = new Сategory("Food");
		categories.add(category);
		assertTrue(categories.getCategories().contains(category));
	}
	
	@Test
	public void shouldSize0_whenNoCategory() {
		int size = 0;
		assertEquals(size, categories.size());
	}
	
	@Test
	public void shouldGetCategoryByIndexPlus1() {
		Сategory category1 = new Сategory("Sport");
		categories.add(category1);
		assertSame(category1, categories.get(1));
	}	
	
	@Test
	public void shouldSizeTwo_whenCategorytwo() {
		int size = 2;
		categories.add(new Сategory("Music"));
		categories.add(new Сategory("Sport"));		
		assertEquals(size, categories.size());
	}
	
}