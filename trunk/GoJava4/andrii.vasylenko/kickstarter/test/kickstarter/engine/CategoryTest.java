package kickstarter.engine;

import static org.junit.Assert.*;
import kickstarter.engine.Category;

import org.junit.Test;

public class CategoryTest {
	
	@Test
	public void shouldNextId_whenCreateNew() {
		int firstId = new Category("Name").getId();
		
		for (int i = ++firstId; i < 10 + firstId; i++) {
			Category category = new Category("Name"+i);
			assertEquals(i, category.getId());
			Data data = category;
			assertEquals(i, data.getId());
		}
	}

	@Test(expected=IllegalArgumentException.class)
	public void shouldException_whenNullName() throws IllegalArgumentException {
		new Category(null);
	}

	@Test
	public void shouldStringName_whenStringName() {
		Category category = new Category("Name");
		assertEquals("Name", category.getName());
	}

}
