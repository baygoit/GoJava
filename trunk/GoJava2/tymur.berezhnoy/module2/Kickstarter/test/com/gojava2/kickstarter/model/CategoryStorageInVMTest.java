package com.gojava2.kickstarter.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CategoryStorageInVMTest {

	private CategoryStorageInVM storageInVM;
	
	@Before
	public void setUp() {
		storageInVM = new CategoryStorageInVM();
	}
	
	@Test
	public void shouldContainsCategory_whenAddCategories() {
		// given
		
		// when
		Category category = new Category("Art");
		storageInVM.addCategory(category);
		
		// then
		assertTrue("Expected, that collection contains new added category", 
					storageInVM.getCategories().contains(category));
	}
	
	@Test
	public void shouldZeroSize_whenNoCategories() {
		// given
		
		// when
		int expectedSize = 0;
		
		// then
		assertEquals("Expected, that collection size is 0 when no categories",
					expectedSize, storageInVM.getSize());
	}
	
	@Test
	public void shouldGetCorrectCategory_whenGetByNumberOfCategoryInConsole() {
		// given
		
		// when
		Category category1 = new Category("Art");
		Category category2 = new Category("Dance");
		
		storageInVM.addCategory(category1);
		storageInVM.addCategory(category2);
		
		// then
		assertSame(category1, storageInVM.getCategory(1));
		assertSame(category2, storageInVM.getCategory(2));
	}
}