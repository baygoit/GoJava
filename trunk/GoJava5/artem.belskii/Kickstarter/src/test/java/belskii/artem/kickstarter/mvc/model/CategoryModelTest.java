package belskii.artem.kickstarter.mvc.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

import belskii.artem.kickstarter.dao.Category;
import belskii.artem.kickstarter.dao.CategoryDao;
import belskii.artem.kickstarter.dao.CategoryDaoImplHardCoding;

public class CategoryModelTest {
	private CategoryDao categoryDao;
	ArrayList<Category> categoryesforEquals;

	@Before
	public void setUp() throws Exception {
		categoryDao = new CategoryDaoImplHardCoding();
		categoryesforEquals = new ArrayList<Category>();
		Category category1 = new Category(0, "Art");
		categoryesforEquals.add(category1);
	}

	@Test
	public void testGetFirstCategoryFromList() {
		assertEquals(categoryesforEquals.get(0).getCategoryName(),
				categoryDao.getCategoryList().get(0).getCategoryName());
	}

	@Test
	public void getNonExistCategoryId() {
		assertEquals("-1", categoryDao.getCategoryById(1000));

	}

}
