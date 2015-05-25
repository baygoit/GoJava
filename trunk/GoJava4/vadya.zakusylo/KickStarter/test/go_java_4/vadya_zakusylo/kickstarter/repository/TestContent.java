package go_java_4.vadya_zakusylo.kickstarter.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestContent {

	private List<CategoryInterface> categories;

	@Before
	public void setUp() {
		categories = new ArrayList<CategoryInterface>();
	}

	@After
	public void tearDown() {
		categories.clear();
	}

	@Test
	public void testEmptyCategories() {
		assertTrue(categories.isEmpty());
	}

	@Test
	public void testAddCategories() {
		categories.add(new Category("Category1"));
		assertEquals(1, categories.size());
		categories.add(new Category("Category2"));
		assertEquals(2, categories.size());
		assertFalse(categories.isEmpty());
	}

}