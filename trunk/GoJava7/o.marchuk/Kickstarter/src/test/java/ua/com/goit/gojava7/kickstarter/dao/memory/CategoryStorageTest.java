package ua.com.goit.gojava7.kickstarter.dao.memory;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.domain.Category;

public class CategoryStorageTest {

	private CategoryDaoMemoryImpl categoryDaoMemoryImpl = new CategoryDaoMemoryImpl();

	@Before
	public void setUp() {
		List<Category> categories = new ArrayList<Category>();
		categories.add(new Category());
		categoryDaoMemoryImpl.setCategories(categories);
	}

	@Test
	public void testEmpty() {
		categoryDaoMemoryImpl = new CategoryDaoMemoryImpl();
		assertThat(categoryDaoMemoryImpl.count(), is(0));
	}

	@Test
	public void testAdd() {
		assertThat(categoryDaoMemoryImpl.count(), is(1));
	}

	@Test
	public void testGetAll() {
		assertThat(categoryDaoMemoryImpl.getAll().size(), is(1));
	}

}
