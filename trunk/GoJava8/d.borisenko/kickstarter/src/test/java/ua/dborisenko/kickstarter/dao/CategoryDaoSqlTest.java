package ua.dborisenko.kickstarter.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class CategoryDaoSqlTest {
    private static final String CONNECTION_STRING = "jdbc:mysql://172.21.6.128:3306/kickstarter_test?user=kickstarter&password=123&useSSL=false";
    private static CategoryDaoSql categoryDao = new CategoryDaoSql();
    
    @BeforeClass
    public static void prepareDatabase() {
        categoryDao.setConnectionString(CONNECTION_STRING);
    }

    @Test
    public void getCategoryNamesTest() {
        List<String> categoryNames = new ArrayList<String>();
        categoryNames.add("testname");
        List<String> categoryNamesDb = categoryDao.getCategoryNames();
        assertThat(categoryNamesDb, is(categoryNames));
    }

    @Test(expected = RuntimeException.class)
    public void getCategoryNamesTestFail() throws SQLException {
        CategoryDaoSql categoryDaoSqlMock = spy(CategoryDaoSql.class);
        when(categoryDaoSqlMock.executeQuery(anyString())).thenReturn(null);
        //categoryDao.getCategoryNames();
    }

    @Test
    public void categoryGetByNameTest() {
        assertThat(categoryDao.getByName("testname"), notNullValue());
    }
}
