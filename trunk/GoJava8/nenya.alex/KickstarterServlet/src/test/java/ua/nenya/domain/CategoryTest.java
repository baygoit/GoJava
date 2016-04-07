package ua.nenya.domain;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Before;
import org.junit.Test;


public class CategoryTest {

	private Category category = new Category();
	@Before
	public void init() {

		category.setId(1);
		category.setName("Film");
	}
	@Test
	public void testGetId() {
		assertThat(category.getId(), is(1));
	}

	@Test
	public void testGetName() {
		assertThat(category.getName(), is("Film"));
	}
}
