package ua.com.goit.gojava7.kickstarter.dao.memory;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.beans.Category;

public class CategoryMemoryDAOTest {

	private CategoryDaoMemoryImpl categoryMemory = new CategoryDaoMemoryImpl();
	Category category = new Category();

	@Test
	public void testCategoryMemoryDAO() {
		assertThat(categoryMemory.getSize(), is(5));
	}

	@Test
	public void testAdd() {
		categoryMemory.add(category);
		assertThat(categoryMemory.getSize(), is(6));
	}

	@Test
	public void testRemove() {
		categoryMemory.add(category);
		assertThat(categoryMemory.getSize(), is(6));
		
		categoryMemory.remove(category);
		assertThat(categoryMemory.getSize(), is(5));
	}

	@Test
	public void testGetAll() {
		assertThat(categoryMemory.getAll().size(), is(5));
		assertThat(categoryMemory.getAll().get(0).getName(), is("Arts"));
		assertThat(categoryMemory.getAll().get(1).getName(), is("Sports"));
		assertThat(categoryMemory.getAll().get(2).getName(), is("Culture"));
		assertThat(categoryMemory.getAll().get(3).getName(), is("Food"));
	}

	@Test
	public void testGetSize() {
		assertThat(categoryMemory.getAll().size(), is(5));
	}
}
