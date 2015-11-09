package ua.com.goit.gojava7.kickstarter.storage;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.domain.Category;

public class CategoryStorageTest {

	private CategoryStorage categoryStorage = new CategoryStorage();
	private Category category = new Category("Category");

	@Before
	public void setUp() {
		categoryStorage.add(category);
	}

	@Test
	public void testEmpty() {
		categoryStorage = new CategoryStorage();
		assertThat(categoryStorage.size(), is(0));
	}

	@Test
	public void testAdd() {
		assertThat(categoryStorage.size(), is(1));
	}

	@Test
	public void testGetAll() {
		assertThat(categoryStorage.getAllCategories().size(), is(1));
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testGetNegative() {
		categoryStorage.get(-1);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetMore() {
		categoryStorage.get(categoryStorage.getAllCategories().size());
	}

	@Test
	public void testGet() {
		assertThat(categoryStorage.get(0).getName(), is(category.getName()));
	}
}
