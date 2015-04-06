package com.gojava2.kickstarter.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
		Category category = new Category(1, "Art");
		
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
	public void shouldGetCorrectCategory_whenGetByNumber() {
		// given
		Category category1 = new Category(1, "Art");
		Category category2 = new Category(2, "Dance");
		
		// when		
		storage.addCategory(category1);
		storage.addCategory(category2);
		
		// then
		assertEquals(category1, storage.getCategory(1));
		assertEquals(category2, storage.getCategory(2));
	}
}