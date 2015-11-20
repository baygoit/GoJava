package ua.com.goit.gojava7.kickstarter.storage;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

public class CategoryStorageTest {

	private CategoryStorage categoryStorage = new CategoryStorage();
	private Category category = new Category("Category", 1);

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
	
	@Test
	public void testSetCategories() {
		Category category = new Category("text", 1);
		List<Category> categorys = new ArrayList<>();
		categorys.add(category);

		categoryStorage.setCategories(categorys);
		assertThat(categoryStorage.getCategory(1), notNullValue());
	}
	
	@Test
	public void TestGetCategory() {
		List<Category> categories = new ArrayList<>(); 
		categories.add(new Category("Category 1", 334));
		categories.add(new Category("text 2", 2));
		
		categoryStorage.setCategories(categories);
		assertThat(categoryStorage.getCategory(334).getName(), is("Category 1"));
		assertThat(categoryStorage.getCategory(2).getName(), is("text 2"));
	}
}
