package ua.com.goit.gojava7.kickstarter.storage;

import static org.junit.Assert.*;

import org.junit.Before;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.domain.Category;

public class CategoryStorageTest {

	private CategoryStorage categoryStorage = new CategoryStorage();
	private Category category = new Category("Category");
	
	@Before
	public void setup() {
		categoryStorage.addCategory(category);
	}
	
	@Test
	public void testEmpty() {
		categoryStorage = new CategoryStorage();
		assertThat(categoryStorage.size(), is(0));
	}

	@Test
	public void testGet() {
		assertThat(categoryStorage.getCategory(0), is(category));
	}
	
	@Test
	public void testAdd() {
		assertThat(categoryStorage.size(), is(1));
	}
	
	@Test
	public void testGetAll() {
		assertThat(categoryStorage.getAllCategories().size(), is(1));
	}
	
	
}
