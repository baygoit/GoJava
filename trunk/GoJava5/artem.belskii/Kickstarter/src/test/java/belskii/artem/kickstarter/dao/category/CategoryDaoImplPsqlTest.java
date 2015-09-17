package belskii.artem.kickstarter.dao.category;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CategoryDaoImplPsqlTest {
	final Logger logger = LoggerFactory.getLogger(CategoryDaoImplPsqlTest.class);
	private CategoryDao category = new CategoryDaoImplPsql("conf/testDatabase.conf");

	@Before
	public void setUp() throws Exception {
		category.initDemoDB();
	}

	@Test
	public void testCategoryDaoImplPsql() {
		assertNotNull(category);
	}

	@Test
	public void testAddCategory() {
		int size=category.getCategoryList().size();
		category.addCategory("NewTestCategory");
		assertEquals("NewTestCategory",category.getCategoryNameById(size+1));
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
