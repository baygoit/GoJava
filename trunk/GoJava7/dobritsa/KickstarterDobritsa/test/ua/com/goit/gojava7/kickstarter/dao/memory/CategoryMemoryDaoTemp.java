package ua.com.goit.gojava7.kickstarter.dao.memory;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.domain.Category;

public class CategoryMemoryDaoTemp {
	List<Category> categories = new ArrayList<>();
	CategoryMemoryDao categoryStorage;

	@Before
	public void setUp() {
		Category category1 = new Category();
		category1.setName("TestCategory1");
		Category category2 = new Category();
		category2.setName("TestCategory2");
		categories.add(category1);
		categories.add(category2);
		categoryStorage = new CategoryMemoryDao(categories);
	}

	@Test
	public void testGetByNumber() {
		categoryStorage.getByNumber(1);
		assertThat(categoryStorage.getByNumber(1).getName(), is("TestCategory1"));
	}

}
