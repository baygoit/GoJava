package ua.com.goit.gojava7.kickstarter.storage;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.model.Category;

public class CategoriesStorageTest {
	CategoriesStorage categoriesStorage = new CategoriesStorage();
	Category category = new Category("AAA");
	
	@Before
	public void setUp() {
		categoriesStorage.addCategory(category);
	}

	@Test
	public void testGetAllCategories() {
		assertThat(categoriesStorage.getAllCategories().size(), is(1));
	}

	@Test
	public void testEmpty() {
		categoriesStorage = new CategoriesStorage();
		assertThat(categoriesStorage.getAllCategories().size(), is(0));
	}
	
	@Test
	public void testAddCategory() {
		assertThat(categoriesStorage.getAllCategories().size(), is(1));
	}
	
	@Test
	public void testDeleteCategory() {
		Category category1 = new Category("BBB");
		categoriesStorage.addCategory(category1);
		
		categoriesStorage.deleteCategory(category);
		assertThat(categoriesStorage.getAllCategories().size(), is(1));
	}

}
