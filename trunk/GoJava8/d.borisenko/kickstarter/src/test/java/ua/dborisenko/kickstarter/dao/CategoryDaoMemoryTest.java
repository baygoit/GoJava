package ua.dborisenko.kickstarter.dao;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import ua.dborisenko.kickstarter.domain.Category;
import ua.dborisenko.kickstarter.domain.Investment;
import ua.dborisenko.kickstarter.domain.Project;

public class CategoryDaoMemoryTest {

    private static CategoryDaoMemory categoryDao = new CategoryDaoMemory();

    @BeforeClass
    public static void prepareData() {
        categoryDao.fillData();
    }
    
    @Test
    public void getByNameTest() {
        assertThat(categoryDao.getCategoryById(1), notNullValue());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void getByNameTestWrong() {
        categoryDao.getCategoryById(999);
    }
    
    @Test
    public void getCategoriesTest() { 
        List<Category> categoryNames = categoryDao.getCategories();
        assertTrue(categoryNames.size() > 0);
    }
}
