package ua.com.goit.gojava7.kickstarter.domain;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;

public class CategoryTest extends  Assert{

	@Test
	public void testNewCategoryWithName() {
		Category category = new Category("Category");
		assertThat(category.getName(), is("Category"));
	}	
	@Test
	public void testNewEmptyCategory() {
		Category category = new Category();
		category.setName("It was empty category");
		assertThat(category.getName(), is("It was empty category"));
	}	
	
}
