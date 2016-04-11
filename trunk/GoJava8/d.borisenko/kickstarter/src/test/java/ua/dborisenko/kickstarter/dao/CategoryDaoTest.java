package ua.dborisenko.kickstarter.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ua.dborisenko.kickstarter.domain.Category;

@RunWith(MockitoJUnitRunner.class)
public class CategoryDaoTest {

    @Mock
    private DataSource dataSource;
    @InjectMocks 
    private CategoryDao categoryDao;
    
    @Test
    public void getCategoryByIdTest() throws SQLException {
        ResultSet rs =  mock(ResultSet.class);
        when(rs.getInt("id")).thenReturn(1);
        when(rs.getString("name")).thenReturn("testname");
        when(rs.next()).thenReturn(true);
        PreparedStatement statement = mock(PreparedStatement.class);
        when(statement.executeQuery()).thenReturn(rs);
        Connection connection = mock(Connection.class);
        when(connection.prepareStatement(anyString())).thenReturn(statement);
        when(dataSource.getConnection()).thenReturn(connection);
        Category category = categoryDao.getCategoryById(1);
        assertThat(category.getId(), is(1));
        assertThat(category.getName(), is("testname"));
    }

    @Test(expected = NoResultException.class)
    public void getCategoryByIdEmptyTest() throws SQLException {
        ResultSet rs =  mock(ResultSet.class);
        when(rs.next()).thenReturn(false);
        PreparedStatement statement = mock(PreparedStatement.class);
        when(statement.executeQuery()).thenReturn(rs);
        Connection connection = mock(Connection.class);
        when(connection.prepareStatement(anyString())).thenReturn(statement);
        when(dataSource.getConnection()).thenReturn(connection);
        categoryDao.getCategoryById(1);
    }
    
    @Test(expected = IllegalStateException.class)
    public void getCategoryByIdFailTest() throws SQLException {
        when(dataSource.getConnection()).thenReturn(null);
        categoryDao.getCategoryById(1);
    }

    @Test
    public void getCategoriesTest() throws SQLException {
        ResultSet rs =  mock(ResultSet.class);
        when(rs.getInt("id")).thenReturn(1);
        when(rs.getString("name")).thenReturn("testname");
        when(rs.next()).thenReturn(true,false);
        PreparedStatement statement = mock(PreparedStatement.class);
        when(statement.executeQuery()).thenReturn(rs);
        Connection connection = mock(Connection.class);
        when(connection.prepareStatement(anyString())).thenReturn(statement);
        when(dataSource.getConnection()).thenReturn(connection);
        List<Category> categories = categoryDao.getCategories();
        assertThat(categories.size(), is(1));
        assertThat(categories.get(0).getId(), is(1));
        assertThat(categories.get(0).getName(), is("testname"));
    }
    
    @Test(expected = IllegalStateException.class)
    public void getCategoriesFailTest() throws SQLException {
        when(dataSource.getConnection()).thenReturn(null);
        categoryDao.getCategories();
    }
    
    @Test
    public void getCategoryByProjectIdTest() throws SQLException {
        ResultSet rs =  mock(ResultSet.class);
        when(rs.getInt("c.id")).thenReturn(1);
        when(rs.getString("c.name")).thenReturn("testname");
        when(rs.next()).thenReturn(true);
        PreparedStatement statement = mock(PreparedStatement.class);
        when(statement.executeQuery()).thenReturn(rs);
        Connection connection = mock(Connection.class);
        when(connection.prepareStatement(anyString())).thenReturn(statement);
        when(dataSource.getConnection()).thenReturn(connection);
        Category category = categoryDao.getCategoryByProjectId(1);
        assertThat(category.getId(), is(1));
        assertThat(category.getName(), is("testname"));
    }

    @Test(expected = NoResultException.class)
    public void getCategoryByProjectIdEmptyTest() throws SQLException {
        ResultSet rs =  mock(ResultSet.class);
        when(rs.next()).thenReturn(false);
        PreparedStatement statement = mock(PreparedStatement.class);
        when(statement.executeQuery()).thenReturn(rs);
        Connection connection = mock(Connection.class);
        when(connection.prepareStatement(anyString())).thenReturn(statement);
        when(dataSource.getConnection()).thenReturn(connection);
        categoryDao.getCategoryByProjectId(1);
    }
    
    @Test(expected = IllegalStateException.class)
    public void getCategoryByProjectIdFailTest() throws SQLException {
        when(dataSource.getConnection()).thenReturn(null);
        categoryDao.getCategoryByProjectId(1);
    }
}
