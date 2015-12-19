package ua.com.goit.gojava7.kickstarter.dao.db;

import static org.junit.Assert.*;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class, loader = AnnotationConfigContextLoader.class)
public class CategoryDatabaseDaoTest{
    @Autowired
    private CategoryDatabaseDao categoryDao;
    
    @Test
    @Ignore
    public void testGetConnection() {
       try {
        assertThat(categoryDao.getConnection() != null, is(true));
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    }

    @Test
    @Ignore
    public void testSize() {
        fail("Not yet implemented");
    }

    @Test
    @Ignore
    public void testCategoryDatabaseDao() {
       assertThat("class ua.com.goit.gojava7.kickstarter.dao.db.CategoryDatabaseDao",is(this.categoryDao.getClass().toString()));
    }

    @Test
    @Ignore
    public void testCategoryDatabaseDaoDataSource() {
        fail("Not yet implemented");
    }

    @Test
    @Ignore
    public void testReadElementResultSet() {
        fail("Not yet implemented");
    }

    @Test
    @Ignore
    public void testGetCategoryById() {
        fail("Not yet implemented");
    }

    @Test
    @Ignore
    public void testAddCategory() {
        fail("Not yet implemented");
    }

    @Test
    @Ignore
    public void testGetAll() {
        fail("Not yet implemented");
    }

    @Test
    @Ignore
    public void testGetInt() {
        fail("Not yet implemented");
    }

    @Test
    @Ignore
    public void testGetByNumberInt() {
        fail("Not yet implemented");
    }

    @Test
    @Ignore
    public void testSetAllListOfCategory() {
        fail("Not yet implemented");
    }

}
