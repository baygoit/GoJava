package ua.com.scread.kickstarter.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ua.com.scread.kickstarter.Category;

public class CategoryTest {

	@Test
	public void shouldBeName_whenInputName() {
		String expected = "Vasya";
		Category category = new Category("Vasya");
		assertEquals(expected, category.getName());
	}

	
}
