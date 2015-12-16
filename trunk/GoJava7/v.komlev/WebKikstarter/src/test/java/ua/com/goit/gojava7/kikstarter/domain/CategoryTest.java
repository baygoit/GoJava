package ua.com.goit.gojava7.kikstarter.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import ua.com.goit.gojava7.kikstarter.domain.Category;

public class CategoryTest {

	@Test
	public void testCategory() {

		String name = "name";

		Category category = new Category(1, name);
		category.setName(name);
		category.setUniqueID(1);
		assertThat(category.getName(), is(name));
		assertThat(category.getUniqueID(), is(1));
		assertThat(category.toString(), is("ID: " + 1 + ", Name: " + name));
	}
}
