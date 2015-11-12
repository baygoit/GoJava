package ua.com.goit.gojava7.kickstarter.domain;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;

public class CategoryTest extends  Assert{

	@Test
	public void testCategoryAndGetName() {
		Category category = new Category("category");
		assertThat(category.getName(), is("category"));
	}	
}
