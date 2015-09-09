package belskii.artem.kickstarter.dao.category;

import static org.junit.Assert.*;

import org.junit.Test;

public class CategoryDaoImplHiberTest {

	@Test
	public void testAddCategory() {
		CategoryDao category = new CategoryDaoImplHiber();
		category.addCategory("New Hiber Category");
		assertTrue(!category.getCategoryNameById(1).equals(""));
	}

	@Test
	public void testGetCategoryList() {
		CategoryDao category = new CategoryDaoImplHiber();
		assertTrue(category.getCategoryList().size()>1);
	}

	@Test
	public void testGetCategoryNameById() {
		CategoryDao category = new CategoryDaoImplHiber();
		assertTrue(!category.getCategoryNameById(1).equals(""));
	}

	@Test
	public void testInitDemoDB() {
		fail("Not yet implemented");
	}

}
