package ua.home.kickstarter;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;

public class CategoriesTest {
	@Test
	public void shouldCategoriesMap_whenAddCatgegories() {
		// given
		Categories list = new Categories();
		list.add(new Category("name1"));
		list.add(new Category("name2"));

		// when
		Map<Integer, Category> categories = list.getCategories();

		// then
		assertEquals("name1name2", categories.get(1).getName() + categories.get(2).getName());
	}

	@Test
	public void shouldCategoriesMap_whenNoCategories() {
		// given
		Categories list = new Categories();

		// when
		Map<Integer, Category> categories = list.getCategories();

		// then
		assertEquals(0, categories.size());
	}
}
