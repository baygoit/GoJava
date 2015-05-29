package go_java_4.vadya_zakusylo.kickstarter.repository;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCategory {

	private CategoryInterface category;

	@Before
	public void setUp() {
		category = new Category("Category1");
	}

	@After
	public void tearDown() {
		category = null;
	}

	@Test
	public void testGetName() {
		assertEquals("Category1", category.getName());
	}

}
