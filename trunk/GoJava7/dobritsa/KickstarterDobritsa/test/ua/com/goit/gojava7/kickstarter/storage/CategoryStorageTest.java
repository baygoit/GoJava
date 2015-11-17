package ua.com.goit.gojava7.kickstarter.storage;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.domain.Category;

public class CategoryStorageTest {

	CategoryStorage categoryStorage = new CategoryStorage();
	
	@Test
	public void testGetifEmpty() {
		assertNull(categoryStorage.get(0));	
	}
	
	@Test
	public void testGet() {
		categoryStorage.add(new Category("Something"));
		assertThat(categoryStorage.get(0).getName(), is("Something"));	
	}
	
	
	
}
