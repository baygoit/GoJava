package ua.com.goit.gojava7.kickstarter.dao.memory;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;

import ua.com.goit.gojava7.kickstarter.config.DataSource;
import ua.com.goit.gojava7.kickstarter.dao.DaoFactory;
import ua.com.goit.gojava7.kickstarter.dao.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.domain.Category;

public class CategoryMemoryDaoTest{
	DataSource		dataSource		= DataSource.MEMORY;
	DaoFactory		daoFactory		= new DaoFactory(dataSource);
	CategoryStorage	categoryStorage	= daoFactory.getCategoryStorage();

	@Test
	public void testCategoryMemoryDao() {
		assertThat(categoryStorage, is(daoFactory.getCategoryStorage()));
	}

	@Test
	public void testGetByNumber() {
		Category category = new Category();
		categoryStorage.add(category);
		assertNotNull(categoryStorage.getByNumber(0));
	}

	@Test
	public void testGetCategoryById() {
		Category category = new Category();
		category.setCategoryId(15);
		category.setCategoryName("testCategory");
		categoryStorage.add(category);
		assertThat(categoryStorage.getCategoryById(15), is(category));
	}

}
