package ua.com.goit.gojava7.kickstarter.dao.memory;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.domain.Category;

public class CategoryMemoryDaoTemp {

	CategoryMemoryDao categoryStorage = new CategoryMemoryDao();
	List<Category> categories = new ArrayList<>();		
	
	@Before
	public void setUp() {
		categories.add(new Category("SomeName"));
		categoryStorage.setCategories(categories);
	}
	
	@Test
	public void testGet() {		
		assertThat(categoryStorage.get(0).getName(), is("SomeName"));	
	}
	
	@Test
	public void testSize() {
		assertThat(categoryStorage.size(), is(1));
	}
	
	@Test
	public void testGetCategories() {
		assertThat(categoryStorage.getAll().get(0).getName(), is("SomeName"));
	}
	
		
	
	
}
