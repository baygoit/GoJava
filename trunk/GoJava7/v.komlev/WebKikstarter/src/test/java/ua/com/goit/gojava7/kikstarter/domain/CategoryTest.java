package ua.com.goit.gojava7.kikstarter.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import ua.com.goit.gojava7.kikstarter.domain.Category;

public class CategoryTest {

	@Test
	public void testCategory() {

		String name = "name";

		Category category = new Category();
		category.setName(name);
		category.setId(1);
		assertThat(category.getName(), is(name));
		assertThat(category.getId(), is(1));
		assertThat(category.toString(), is("ID: " + 1 + ", Name: " + name));
	}
}
