package ua.com.goit.gojava7.kickstarter.beans;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.beans.Category;

public class CategoryTest {
	
	private String categoryName = "Film";
	private int categoryID = 1;
	private Category category = new Category();
	
	@Before
	public void setUp() throws Exception {
		category.setName(categoryName);
		category.setUniqueID(categoryID);
	}

	@Test
	public void testCategory() {
		Category myCategory = new Category();
		assertThat(myCategory.getName().length(), is (0));
		assertThat(myCategory.getUniqueID(), is(0));
	}

	@Test
	public void testGetCategoryName() {
		assertThat(category.getName(), is(categoryName));
	}

	@Test
	public void testSetCategoryName() {
		String name = "Movie";
		category.setName(name);
		assertThat(category.getName(), is(name));
	}

	@Test
	public void testGetUniqueID() {
		assertThat(category.getUniqueID(), is(categoryID));
	}

	@Test
	public void testSetUniqueID() {
		int id = 2;
		category.setUniqueID(id);
		assertThat(category.getUniqueID(), is(id));
	}
}
