package org.goJava2.kickstarter.model;

import static org.junit.Assert.*;

import org.goJava2.kickstarter.content.Category;
import org.goJava2.kickstarter.content.Quote;
import org.junit.Test;

public class CategoryStorageTest {

	private CategoryStorage categoryStorage = new CategoryStorage(); 
	
	@Test
	public void shouldListSizeNot0_whenNewQuoteStorage() {
		categoryStorage = new CategoryStorage();
		assertFalse("Expected that constructor for Hard-coded categories init at least 1 quote.",
					categoryStorage.getContent().size() == 0);
	}
	
	@Test
	public void shouldListNotBeNull() {
		categoryStorage = new CategoryStorage();
		assertFalse("Expected that list is not null.",
					categoryStorage.getContent() == null);
	}
	
	@Test
	public void shouldListContainsNewQuote_whenAddNewQuote() {
		categoryStorage = new CategoryStorage();
		Category quote = new Category("New category");
		categoryStorage.addContent(quote);
		assertTrue("Expected that new created category is at storage.",
					categoryStorage.getContent().contains(quote));
	}
}