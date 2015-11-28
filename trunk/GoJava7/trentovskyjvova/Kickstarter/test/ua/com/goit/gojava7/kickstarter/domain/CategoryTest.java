package ua.com.goit.gojava7.kickstarter.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CategoryTest {

	@Test
	public void testCategoryAndGetName() {
		Category category = new Category();
		category.setId(1);
		category.setName("category");
		assertThat(category.getId(), is(1));
		assertThat(category.getName(), is("category"));
	}

}
