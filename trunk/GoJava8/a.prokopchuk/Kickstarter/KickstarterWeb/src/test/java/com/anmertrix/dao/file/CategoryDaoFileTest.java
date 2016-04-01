package com.anmertrix.dao.file;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.anmertrix.domain.Category;
import com.anmertrix.domain.Project;
@Ignore
public class CategoryDaoFileTest {
	
	private String baseFile = "./src/test/resources/categories.json";
	
	private static CategoryDaoFile categoryDao = new CategoryDaoFile();
	
	
	@Test
	public void testSetCategoriesFileName() {
        categoryDao.setCategoriesFileName(baseFile);
        Category category = categoryDao.categories.get(0);
        assertThat(category.getName(), is("category test"));
	}
	
	@Test
	public void testGetCategory() {
        categoryDao.setCategoriesFileName(baseFile);
        Category category = categoryDao.getCategory(1);
        assertThat(category.getName(), is("category test"));
	}
	
	@Test
	public void testGetCategories() {
        categoryDao.setCategoriesFileName(baseFile);
        List<Category> categories = categoryDao.getCategories();
        Category category = categories.get(0);
        assertThat(category.getName(), is("category test"));
	}
	
	@Test
	public void testGetProjects() {
        categoryDao.setCategoriesFileName(baseFile);
        List<Project> projects =  categoryDao.getProjectsByCategoryId(1);
        Project project = projects.get(0);
        assertThat(project.getName(), is("project test"));
	}
	

}
