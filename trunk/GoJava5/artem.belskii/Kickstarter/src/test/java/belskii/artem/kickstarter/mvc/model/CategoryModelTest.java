package belskii.artem.kickstarter.mvc.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

import belskii.artem.kickstarter.dao.category.Category;
import belskii.artem.kickstarter.dao.category.CategoryDao;
import belskii.artem.kickstarter.dao.category.CategoryDaoImplHardCoding;

public class CategoryModelTest {
	private CategoryDao categoryDao;
	ArrayList<Category> categoryesforEquals;

	@Before
	public void setUp() throws Exception {
		categoryDao = new CategoryDaoImplHardCoding();
		categoryesforEquals = new ArrayList<Category>();
		categoryesforEquals.add(new Category(0, "Art"));
		categoryesforEquals.add(new Category(1, "Comics"));
		categoryesforEquals.add(new Category(2, "Crafts"));
		categoryesforEquals.add(new Category(3, "Dance"));
		categoryesforEquals.add(new Category(4, "Design"));
		categoryesforEquals.add(new Category(5, "Fashion"));
		categoryesforEquals.add(new Category(6, "Film & Video"));
		categoryesforEquals.add(new Category(7, "Food"));
		categoryesforEquals.add(new Category(8, "Games"));
		categoryesforEquals.add(new Category(9, "Journalism"));
		categoryesforEquals.add(new Category(10, "Music"));
		categoryesforEquals.add(new Category(11, "Photography"));
		categoryesforEquals.add(new Category(12, "Publishing"));
		categoryesforEquals.add(new Category(13, "Technology"));
		categoryesforEquals.add(new Category(14, "Theater"));
	}
	
	@Test
	public void getCategoryList(){
			assertEquals(categoryDao.getCategoryNameById(10), categoryesforEquals.get(10).getCategoryName());
	}

	@Test
	public void testGetFirstCategoryFromList() {
		assertEquals(categoryesforEquals.get(0).getCategoryName(),
				categoryDao.getCategoryList().get(0).getCategoryName());
	}

	@Test
	public void testgetNonExistCategoryId() {
		assertEquals("-1", categoryDao.getCategoryNameById(1000));
	}
	
	@Test
	public void testaddCategory(){
		categoryDao.addCategory(new Category(15, "Some category"));
		assertEquals("Some category",categoryDao.getCategoryNameById(15));
	}
	


}
