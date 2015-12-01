package ua.com.goit.gojava7.kickstarter.storage;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.domain.Category;

import static org.hamcrest.CoreMatchers.is;

public class CategoryStorageTest {
	private CategoryStorage categoryStorage = new CategoryStorage();
	Category cat = new Category("Movie", 1);
	@Before
	public void addOneCategory() {
		
		categoryStorage.addCategory(cat);
	}

	@Test
	public void testCategoryAdd() {
		assertThat(categoryStorage.getCategories().size(), is(1));
	}

	@Test
	public void testGetCategories() {
		categoryStorage.getCategories().add(new Category("TestCategory", 100500));
		assertThat(categoryStorage.getCategories().size(), is(2));
	}
	
	@Test
	public void testGetCateoryById(){
		assertThat(categoryStorage.getCategoryById(1),is(cat));
		
		
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testException(){
		categoryStorage.getCategoryById(0);
	}
	public void testSetCategories(){
		List<Category> categories = new ArrayList<>();
		categoryStorage.setCategories(categories);
		assertThat(categoryStorage.getCategories(),is(categories));
	}
	
	@Test
	public void testSize(){
		assertThat(categoryStorage.size(),is(1));
	}
	
}
