package ua.nenya.dao.memory;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class CategoryDaoMemoryImplTest {

	@Test
	public void initCategoriesTest(){
		CategoryDaoMemoryImpl cdmi = new CategoryDaoMemoryImpl();
		cdmi.setFile(new File("src/test/resources/caterories.json"));
		cdmi.initCategories();
		assertNotNull(cdmi.initCategories().get(0));
	}

}
