package com.gojava2.kickstarter.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import com.gojava2.kickstarter.model.Category;

public class CategoryStorageTest {

	private CategoryStorage csHarCodedeCategory; 
	private CategoryStorage csCustomCategory;
	
	@Before
	
	public void createCategoryStorage() {
		csHarCodedeCategory = new CategoryStorage();
		csCustomCategory = new CategoryStorage(new HashSet<Category>());
	}
	
	@Test
	public void shouldListSizeNot0_whenNewCategoryStorage() {
		assertFalse("Expected that constructor for Hard-coded categories init at least 1 quote.",
					csHarCodedeCategory.getContent().size() == 0);
	}
	
	@Test
	public void shouldListIsNotNull_whenNewCategoryStorage() {
		assertFalse("Expected that list is not null.",
					csHarCodedeCategory.getContent() == null);
	}
	
	@Test
	public void shouldListContainsNewCategory_whenAddNewCategory() {
		Category quote = new Category("New category");
		csHarCodedeCategory.addContent(quote);
		assertTrue("Expected that new created category is at storage.",
					csHarCodedeCategory.getContent().contains(quote));
	}
	
	@Test
	public void shouldListIsNotNull_whenNewCustomCategoryStorage() {
		assertFalse("Expexted than list is not null when custom constructor",
				csCustomCategory.getContent() == null);
	}
	
	@Test
	public void shouldCategoryIsNotNull_whenGetSpecificCategory() {
		assertFalse("Expected that category is not null",
					csHarCodedeCategory.getSpecificContent(0) == null);
	}
}