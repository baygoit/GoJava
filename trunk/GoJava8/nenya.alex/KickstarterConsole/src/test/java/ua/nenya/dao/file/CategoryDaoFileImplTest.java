package ua.nenya.dao.file;

import static org.junit.Assert.*;

import org.junit.Test;


public class CategoryDaoFileImplTest {
	
	@Test
	public void initCategoriesTest(){
		CategoryDaoFileImpl cdfi = new CategoryDaoFileImpl();
		cdfi.setFileName("src/test/resources/caterories.json");
		cdfi.initCategories();
		assertNotNull(cdfi.getCategories().get(0));
	}

}
