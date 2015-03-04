package ua.com.scread.kickstarter;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ua.com.scread.kickstarter.data.Category;
import ua.com.scread.kickstarter.storage.Categories;

public abstract class CategotriesTest {
    
	Categories categories = getCategories();
	Category category = new Category("Vasya");

    abstract Categories getCategories();
	
	@Test
	public void shouldBeAddedCategoty_whenAddCategory() {
		categories.add(category);
		assertEquals(categories.get(0), category);
	}
	
	@Test
	public void shouldReturnCategories_whenReturningCategories() {
		categories.add(category);
		List<Category> categoriesActual = new ArrayList<Category>();
		categoriesActual.add(category);
		assertEquals(categoriesActual, categories.getCategories());
	}
	
	@Test
	public void sholudReturnEmpty_whenEmptyCategories() {
		assertEquals(new ArrayList<Category>(), categories.getCategories());
	}
	
	@Test
	public void shouldReturnSize_whenGetSize() {
	    assertEquals(0, categories.size());
	    
	    categories.add(category);
	    
	    assertEquals(1, categories.size());
	}
}
