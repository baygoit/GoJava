package ua.com.scread.kickstarter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ua.com.scread.kickstarter.Category;

public class CategoryTest {

	@Test
	public void shouldBeName_whenInputName() {
		Category category = new Category("Vasya");
		assertEquals("Vasya", category.getName());
	}

	
}
