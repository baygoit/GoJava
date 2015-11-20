package ua.com.goit.gojava7.kickstarter.beans;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.beans.Category;

public class CategoryTest {
	
	private String categoryName = "Film";
	private Category category;
	
	@Before
	public void setUp() throws Exception {
		category = new Category(categoryName);
	}

	@Test
	public void testCategory() {
		assertThat(category.getCategoryName(), is(categoryName));
	}

	@Test
	public void testGetCategoryName() {
		assertThat(category.getCategoryName(), is(categoryName));
	}

	@Test
	public void testSetCategoryName() {
		String name = "Movie";
		category.setCategoryName(name);
		assertThat(category.getCategoryName(), is(name));
	}

	@Test
	public void testGetUniqueID() {
		assertThat(category.getUniqueID(), is(0));
	}

	@Test
	public void testSetUniqueID() {
		int id = 1;
		category.setUniqueID(id);
		assertThat(category.getUniqueID(), is(id));
	}
}
