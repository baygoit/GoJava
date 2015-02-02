package ua.com.scread.kickstarter.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import ua.com.scread.kickstarter.Categories;
import ua.com.scread.kickstarter.Category;

public class CategotriesTest {
	Categories categories = new Categories();
	Category category = new Category("Vasya");
	
	@Test
	public void shouldBeAddedCategoty_whenAddCategory() {
		categories.add(category);
		assertEquals(categories.getCategory(0), category);
	}
	
	@Test
	public void shouldReturnCategories_whenReturningCategories() {
		categories.add(category);
		Categories categoriesActual = new Categories();
		categoriesActual.add(category);
		assertEquals(categories.getCategories(), categoriesActual.getCategories());
	}
	
	@Test
	public void shouldReturnStringCategories_whenReturnCategories() {
		categories.add(category);
		String[] categoriesString = {"1 - Vasya"};
		assertEquals(categories.getStringCategories(), categoriesString);
	}

}
