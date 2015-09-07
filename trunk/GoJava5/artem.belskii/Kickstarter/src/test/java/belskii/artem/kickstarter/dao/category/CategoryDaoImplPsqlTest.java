package belskii.artem.kickstarter.dao.category;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CategoryDaoImplPsqlTest {
	CategoryDao category = new CategoryDaoImplPsql("src/test/conf/database.conf");

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCategoryDaoImplPsql() {
		assertNotNull(category);
	}

	@Test
	public void testAddCategory() {
		category.addCategory("Art");
		category.addCategory("Comics");
		category.addCategory("Crafts");
		category.addCategory("Dance");
		category.addCategory("Design");
		category.addCategory("Fashion");
		category.addCategory("Film & Video");
		category.addCategory("Food");
		category.addCategory("Games");
		category.addCategory("Journalism");
		category.addCategory("Music");
		category.addCategory("Photography");
		category.addCategory("Publishing");
		category.addCategory("Technology");
		category.addCategory("Theater");

	}

	@Test
	public void testGetCategoryList() {
		assertNotNull(category.getCategoryList());
	}

	@Test
	public void testGetCategoryNameById() {
		assertEquals("Art", category.getCategoryNameById(1));
	}

}
