package org.goJava2.kickstarter.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;

import org.goJava2.kickstarter.content.Category;
import org.junit.Test;

public class CategoryStorageTest {

	private CategoryStorage categoryStorage; 
	
	@Test
	public void shouldListSizeNot0_whenNewCategoryStorage() {
		categoryStorage = new CategoryStorage();
		assertFalse("Expected that constructor for Hard-coded categories init at least 1 quote.",
					categoryStorage.getContent().size() == 0);
	}
	
	@Test
	public void shouldListIsNotNull_whenNewCategoryStorage() {
		categoryStorage = new CategoryStorage();
		assertFalse("Expected that list is not null.",
					categoryStorage.getContent() == null);
	}
	
	@Test
	public void shouldListContainsNewCategory_whenAddNewCategory() {
		categoryStorage = new CategoryStorage();
		Category quote = new Category("New category");
		categoryStorage.addContent(quote);
		assertTrue("Expected that new created category is at storage.",
					categoryStorage.getContent().contains(quote));
	}
	
	@Test
	public void shouldListIsNotNull_whenNewCustomCategoryStorage() {
		categoryStorage = new CategoryStorage(new HashSet<Category>());
		assertFalse("Expexted than list is not null when custom constructor",
					categoryStorage.getContent() == null);
	}
	
	@Test
	public void shouldCategoryIsNotNull_whenGetSpecificCategory() {
		categoryStorage = new CategoryStorage();
		assertFalse("Expected that category is not null",
					categoryStorage.getSpecificContent(0) == null);
	}
}