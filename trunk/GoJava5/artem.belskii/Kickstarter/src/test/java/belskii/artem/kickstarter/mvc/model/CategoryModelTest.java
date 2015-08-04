package belskii.artem.kickstarter.mvc.model;

import static org.junit.Assert.*;
import java.util.HashMap;
import org.junit.Before;
import org.junit.Test;
import belskii.artem.kickstarter.dao.category.CategoryDao;
import belskii.artem.kickstarter.dao.category.CategoryDaoImplHardCoding;

public class CategoryModelTest {
	private CategoryDao categoryDao;
	private HashMap<Integer, String> categoryesforEquals;

	@Before
	public void setUp() throws Exception {
		categoryesforEquals = new HashMap<Integer,String>();
		categoryesforEquals.put(0, "Art");
		categoryesforEquals.put(1, "Comics");
		categoryesforEquals.put(2, "Crafts");
		categoryesforEquals.put(3, "Dance");
		categoryesforEquals.put(4, "Design");
		categoryesforEquals.put(5, "Fashion");
		categoryesforEquals.put(6, "Film & Video");
		categoryesforEquals.put(7, "Food");
		categoryesforEquals.put(8, "Games");
		categoryesforEquals.put(9, "Journalism");
		categoryesforEquals.put(10, "Music");
		categoryesforEquals.put(11, "Photography");
		categoryesforEquals.put(12, "Publishing");
		categoryesforEquals.put(13, "Technology");
		categoryesforEquals.put(14, "Theater");
		categoryDao = new CategoryDaoImplHardCoding();
	}
	
	@Test
	public void getCategoryList(){
			assertEquals(categoryDao.getCategoryNameById(10), categoryesforEquals.get(10));
	}

	@Test
	public void testGetFirstCategoryFromList() {
		assertEquals(categoryesforEquals.get(0),
				categoryDao.getCategoryList().get(0));
	}

	@Test
	public void testgetNonExistCategoryId() {
		assertEquals("-1", categoryDao.getCategoryNameById(1000));
	}
	
	@Test
	public void testaddCategory(){
		categoryDao.addCategory("Some category");
		assertEquals("Some category",categoryDao.getCategoryNameById(15));
	}
	
}
