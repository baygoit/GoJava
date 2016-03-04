package ua.dborisenko.kickstarter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DataSourceProjectCategoryTest {

    private static ProjectCategory category = new ProjectCategory();
    
    @Before
    public void prepareDataSource() {
        DataSource.allProjectCategories.clear();
        category.setId(1);
        category.setName("test name");
    }
    
    @Test
    public void addTest() {
        DataSourceProjectCategory.add(category);
        boolean isCategoryExists = false;
        for (ProjectCategory currentCategory : DataSource.allProjectCategories) {
            if (1 == currentCategory.getId()) {
                isCategoryExists = true;
                break;
            }
        }
        assertTrue(isCategoryExists);
    }

    @Test
    public void updateTest() {
        DataSourceProjectCategory.add(category);
        ProjectCategory changedCategory = new ProjectCategory();
        changedCategory.setId(category.getId());
        changedCategory.setName("changed name");
        DataSourceProjectCategory.update(changedCategory);
        boolean isCategoryExists = false;
        for (ProjectCategory currentCategory : DataSource.allProjectCategories) {
            if (currentCategory.getName().equals("changed name")) {
                isCategoryExists = true;
                break;
            }
        }
        assertTrue(isCategoryExists);
    }
    
    @Test
    public void deleteTest() {
        DataSourceProjectCategory.add(category);
        DataSourceProjectCategory.delete(category);
        for (ProjectCategory currentCategory : DataSource.allProjectCategories) {
            if (1 == currentCategory.getId()) {
                fail("Category is still exists.");
            }
        }
    }
    
    @Test
    public void getByNameExistsTest() {
        DataSourceProjectCategory.add(category);
        assertEquals(category.getName(), DataSourceProjectCategory.getByName(category.getName()).getName());
    }
    
    @Test
    public void getByNameNotExistsTest() {
        assertTrue(0 == DataSourceProjectCategory.getByName("wrong name").getId());
    }
    
    
    @Test
    public void getByIdExistsTest() {
        DataSourceProjectCategory.add(category);
        assertEquals(category.getName(), DataSourceProjectCategory.getById(category.getId()).getName());
    }
    
    @Test
    public void getByIdNotExistsTest() {
        assertTrue(0 == DataSourceProjectCategory.getById(42).getId());
    }
}
