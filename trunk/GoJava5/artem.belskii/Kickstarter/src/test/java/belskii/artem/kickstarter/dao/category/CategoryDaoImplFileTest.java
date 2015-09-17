package belskii.artem.kickstarter.dao.category;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

public class CategoryDaoImplFileTest {
	CategoryDao categoryDao = new CategoryDaoImplFile();
	HashMap<Integer, String> listForEquals = new HashMap<Integer, String>();

	@Before
	public void setUp() throws Exception {
		
		listForEquals.put(0, "Art");
		listForEquals.put(1,"Comics");
		listForEquals.put(2,"Crafts");
		listForEquals.put(3,"Dance");
		listForEquals.put(4,"Design");
		listForEquals.put(5,"Fashion");
		listForEquals.put(6,"Film & Video");
		listForEquals.put(7,"Food");
		listForEquals.put(8,"Games");
		listForEquals.put(9,"Journalism");
		listForEquals.put(10,"Music");
		listForEquals.put(11,"Photography");
		listForEquals.put(12,"Publishing");
		listForEquals.put(13,"Technology");
		listForEquals.put(14,"Theater");
		
		categoryDao.initDemoDB();
	}

	@Test
	public void testGetCategoryList() {
		assertNotNull( categoryDao.getCategoryList().get(0));
	}
	
	@Test
	public void testAddCategory() {
		categoryDao.addCategory("New category");
		assertEquals("New category",categoryDao.getCategoryNameById(15));
	}

	@Test
	public void testGetCategoryNameById() {
		assertEquals("Games",categoryDao.getCategoryNameById(8));	
	}

}
