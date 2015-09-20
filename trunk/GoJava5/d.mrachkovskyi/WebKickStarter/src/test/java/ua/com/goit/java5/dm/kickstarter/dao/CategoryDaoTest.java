package ua.com.goit.java5.dm.kickstarter.dao;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import ua.com.goit.java5.dm.kickstarter.model.Category;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: dmrachkovskyi
 * Date: 8/12/15
 * Time: 6:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class CategoryDaoTest {

    @Test
    public void whenGetCategoriesThenReturnNotNull() {
        CategoryDao categoryDao = new CategoryDao();

        List<Category> categoryList = categoryDao.getAllCategories();

        assertNotNull("categories must not be null", categoryList);
    }

    @Test
    public void whenGetCategoriesThenReturnCategories() {
        List<Category> categoryList = getCategoriesList();
        CategoryDao categoryDao = new CategoryDao();
        categoryDao.setCategoryList(categoryList);

        List<Category> actual = categoryDao.getAllCategories();
        List<Category> expected = new ArrayList<>(categoryList);

        assertEquals(actual, expected);
    }

    private List<Category> getCategoriesList() {
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category("Category 1"));
        categoryList.add(new Category("Category 2"));
        categoryList.add(new Category("Category 3"));
        categoryList.add(new Category("Category 4"));
        categoryList.add(new Category("Category 5"));
        return categoryList;
    }
}
