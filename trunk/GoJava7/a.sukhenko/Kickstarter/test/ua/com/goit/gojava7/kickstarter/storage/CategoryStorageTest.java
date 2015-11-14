package ua.com.goit.gojava7.kickstarter.storage;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import ua.com.goit.gojava7.kickstarter.model.Category;

public class CategoryStorageTest {
	private CategoryStorage categoryStorage = new CategoryStorage();

	@Before
	public void addOneCategory() {
		categoryStorage.addCategory(new Category("Movie", 1));
	}

	@Test
	public void testCategoryAdd() {
		assertThat(categoryStorage.getCategories().size(), is(1));
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testGetCategories() {
		categoryStorage.getCategories().put(100500, new Category("TestCategory", 100500));
		assertThat(categoryStorage.getCategories().size(), is(1));
	}

}
