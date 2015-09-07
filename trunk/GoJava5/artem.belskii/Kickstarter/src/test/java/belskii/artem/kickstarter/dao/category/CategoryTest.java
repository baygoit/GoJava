package belskii.artem.kickstarter.dao.category;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CategoryTest {
	private Category testCategory;
	@Before
	public void setUp() throws Exception {
		testCategory = new Category(100, "some Category");
	}

	@Test
	public void testGetCategoryId() {
		assertEquals(100, testCategory.getCategoryId());
	}

	@Test
	public void testUpdateCategoryId() {
		testCategory.updateCategoryId(101);
		assertEquals(101, testCategory.getCategoryId());
	}

	@Test
	public void testGetCategoryName() {
		assertEquals("some Category", testCategory.getCategoryName());
	}

}
