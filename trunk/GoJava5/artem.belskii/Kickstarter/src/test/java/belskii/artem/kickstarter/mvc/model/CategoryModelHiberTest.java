package belskii.artem.kickstarter.mvc.model;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class CategoryModelHiberTest {

	@Test
	public void testAddCategory() {
		CategoryModelHiber category = new CategoryModelHiber();
		category.addCategory("New Hiber Category");
		assertTrue(!category.getCategoryNameById(1).equals(""));
	}

	@Test
	public void testGetCategoryList() {
		CategoryModelHiber category = new CategoryModelHiber();
		assertTrue(category.getCategoryList().size()>=1);
	}

	@Test
	public void testGetCategoryNameById() {
		CategoryModelHiber category = new CategoryModelHiber();
		assertTrue(!category.getCategoryNameById(1).equals(""));
	}

	@Test @Ignore
	public void testInitDemoDB() {
		fail("Not yet implemented");
	}

}
