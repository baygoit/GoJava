package com.anmertrix.dao.file;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

import com.anmertrix.domain.Category;

public class CategoryDaoFileTest {
	
	private String baseFile = "./src/test/resources/categories.json";
	
	private static CategoryDaoFile categoryDao = new CategoryDaoFile();
	
	@Test
	public void testGetCategories() {
        categoryDao.setCategoriesFileName(baseFile);
        categoryDao.initData();
        Category category = categoryDao.categories.get(0);
        assertThat(category.getName(), is("Test Category"));
	}

}
