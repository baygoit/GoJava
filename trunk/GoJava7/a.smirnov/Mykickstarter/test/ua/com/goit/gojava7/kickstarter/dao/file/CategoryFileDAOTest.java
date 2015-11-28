package ua.com.goit.gojava7.kickstarter.dao.file;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.beans.Category;

public class CategoryFileDAOTest {

	private CategoryDaoFileImpl categoryFile = new CategoryDaoFileImpl();
	private Category category = new Category();

	@Test
	public void testAdd() {
		categoryFile.add(category);
		assertThat(categoryFile.getAll().size(), is(7));
	}

	@Test
	public void testGetAll() {
		assertThat(categoryFile.getAll().size(), is(7));
	}

	@Test
	public void testGetSize() {
		assertThat(categoryFile.getSize(), is(7));
	}
}
