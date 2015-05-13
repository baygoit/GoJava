package kickstarter.engine;

import static org.junit.Assert.*;
import kickstarter.engine.Category;

import org.junit.Test;

public class CategoryTest {
	
	@Test
	public void shouldNextId_whenCreateNew() {
		Category firstCategory = new Category("Name");
		int firstId = firstCategory.getId();
		
		for (int i = ++firstId; i < 10 + firstId; i++, firstId++) {
			Category currentCategory = new Category("Name"+i);
			assertEquals(i, currentCategory.getId());
		}
	}

	@Test
	public void shouldStringName_whenStringName() {
		Category category = new Category("Name");
		assertEquals("Name", category.getName());
	}

}
