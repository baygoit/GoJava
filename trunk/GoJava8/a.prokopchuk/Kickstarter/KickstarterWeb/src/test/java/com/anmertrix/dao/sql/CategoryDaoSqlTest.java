package com.anmertrix.dao.sql;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.anmertrix.domain.Category;

@RunWith(MockitoJUnitRunner.class)
public class CategoryDaoSqlTest {

	@Mock
	private DataSource dataSource;
	@Mock
	private Connection connection;
	@Mock
    PreparedStatement preparedStatement;
	@Mock
    ResultSet resultSet;
	@InjectMocks
	private CategoryDaoSql categoryDaoSql;
	
	@Before
    public void setUp() throws SQLException {
		when(dataSource.getConnection()).thenReturn(connection);
		when(preparedStatement.executeQuery()).thenReturn(resultSet);
		when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
	}

	@Test
	public void testGetCategory() throws SQLException {
		when(resultSet.next()).thenReturn(true);
		when(resultSet.getString("name")).thenReturn("test");

		Category category = categoryDaoSql.getCategory(10);
		assertThat(category.getId(), is(10));
		assertThat(category.getName(), is("test"));

		verify(preparedStatement).setInt(1, 10);
		verify(connection).prepareStatement(contains("id="));
		verify(connection).prepareStatement(contains("category"));
	}

	@Test
	public void testGetCategoryNotFound() throws SQLException {
		assertThat(categoryDaoSql.getCategory(0), is(nullValue()));
	}
	
	@Test(expected = RuntimeException.class)
	public void testGetCategoryGetConnectionException() throws SQLException {
		when(dataSource.getConnection()).thenThrow(new SQLException());
		try {
			categoryDaoSql.getCategory(1);
		} finally {
			verify(dataSource).getConnection();
		}
	}
	
	@Test(expected = RuntimeException.class)
	public void testGetCategoryCreateStatementException() throws SQLException {
		when(connection.prepareStatement(anyString())).thenThrow(new SQLException());
		try {
			categoryDaoSql.getCategory(1);
		} finally {
			verify(dataSource).getConnection();
		}
	}
	
	@Test(expected = RuntimeException.class)
	public void testGetCategryGetResultSetException() throws SQLException {
		when(preparedStatement.executeQuery()).thenThrow(new SQLException());
		try {
			categoryDaoSql.getCategory(1);
		} finally {
			verify(dataSource).getConnection();
		}
	}
	
	@Test
	public void testGetCategories() throws SQLException {
		when(resultSet.next()).thenReturn(true, false);
		when(resultSet.getInt("id")).thenReturn(1);
		when(resultSet.getString("name")).thenReturn("test");
		List<Category> categories = categoryDaoSql.getCategories();
		Category category = categories.get(0);
		assertThat(category.getId(), is(1));
		assertThat(category.getName(), is("test"));
	}
	
	@Test(expected = RuntimeException.class)
	public void testGetCategiesGetConnectionException() throws SQLException {
		when(dataSource.getConnection()).thenThrow(new SQLException());
		try {
			categoryDaoSql.getCategories();
		} finally {
			verify(dataSource).getConnection();
		}
	}
	
	@Test(expected = RuntimeException.class)
	public void testGetCategiesCreateStatementException() throws SQLException {
		when(connection.prepareStatement(anyString())).thenThrow(new SQLException());
		try {
			categoryDaoSql.getCategories();
		} finally {
			verify(dataSource).getConnection();
		}
	}

	@Test
	public void testGetCategoriesNotFound() throws SQLException {
		List<Category> categories = categoryDaoSql.getCategories();
		assertThat(categories.isEmpty(), is(true));
	}

	@Test(expected = RuntimeException.class)
	public void testGetCategriesGetResultSetException() throws SQLException {
		when(preparedStatement.executeQuery()).thenThrow(new SQLException());
		try {
			categoryDaoSql.getCategories();
		} finally {
			verify(dataSource).getConnection();
		}
	}

}
