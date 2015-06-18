package kickstarter.model.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CategoryTest {
	@Test
	public void shouldGetTheSameCategory_whenNewCategory() {
		Category category = new Category(4, "test Category");
		assertEquals(4, category.getId());
		assertEquals("test Category", category.getName());
	}
}
