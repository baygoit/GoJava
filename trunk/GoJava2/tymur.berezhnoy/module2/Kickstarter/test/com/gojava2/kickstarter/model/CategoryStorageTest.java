package com.gojava2.kickstarter.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public abstract class CategoryStorageTest {

	private CategoryStorage storage;
	
	@Before
	public void setUp() {
		storage = getStorage();
	}
	
	abstract CategoryStorage getStorage();
	
	@Test
	public void shouldContainsCategory_whenAddCategories() {
		// given
		Category category = new Category("Art");
		
		// when
		storage.addCategory(category);
		
		// then
		assertTrue("Expected, that collection contains new added category", 
					storage.getCategories().contains(category));
	}
	
	@Test
	public void shouldZeroSize_whenNoCategories() {
		// when
		int expectedSize = 0;
		
		// then
		assertEquals("Expected, that collection size is 0 when no categories",
					expectedSize, storage.getSize());
	}
	
	@Test
	public void shouldGetCorrectCategory_whenGetByNumberOfCategoryInConsole() {
		// given
		Category category1 = new Category("Art");
		Category category2 = new Category("Dance");
		
		// when		
		storage.addCategory(category1);
		storage.addCategory(category2);
		
		// then
		assertSame(category1, storage.getCategory(1));
		assertSame(category2, storage.getCategory(2));
	}
}