package ua.com.scread.kickstarter;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
		List<Category> categoriesActual = new ArrayList<Category>();
		categoriesActual.add(category);
		assertEquals(categories.getCategories(), categoriesActual);
	}
	
	@Test
	public void sholudReturnEmpty_whenEmptyCategories() {
		assertEquals(new ArrayList<Category>(), categories.getCategories());
	}
	
	@Test
	public void shouldReturnStringCategories_whenReturnCategories() {
		categories.add(category);
		String categoriesString = "[1 - Vasya]";
		assertEquals(Arrays.toString(categories.getStringCategories()), categoriesString);
	}

}
