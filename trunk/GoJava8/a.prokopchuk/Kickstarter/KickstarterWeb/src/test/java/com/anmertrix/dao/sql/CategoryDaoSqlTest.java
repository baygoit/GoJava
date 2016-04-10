package com.anmertrix.dao.sql;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
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

import com.anmertrix.dao.NoResultException;
import com.anmertrix.domain.Category;

@RunWith(MockitoJUnitRunner.class)
public class CategoryDaoSqlTest {
	
	private static final String SELECT_CATEGORY = "SELECT 1";

	@Mock
	private DataSource dataSource;
	@Mock
	private Connection connection;
	@InjectMocks
	private CategoryDaoSql categoryDaoSql;

	@Test
	public void testGetCategory() throws SQLException {
		ResultSet rs = mock(ResultSet.class);
		when(rs.next()).thenReturn(true);
		when(rs.getString("name")).thenReturn("test");

		PreparedStatement ps = mock(PreparedStatement.class);
		when(ps.executeQuery()).thenReturn(rs);

		Connection connection = mock(Connection.class);
		when(connection.prepareStatement(anyString())).thenReturn(ps);

		when(dataSource.getConnection()).thenReturn(connection);

		Category category = categoryDaoSql.getCategory(10);
		assertThat(category.getId(), is(10));
		assertThat(category.getName(), is("test"));

		verify(ps).setInt(1, 10);
		verify(connection).prepareStatement(contains("id="));
		verify(connection).prepareStatement(contains("category"));
	}

	@Test(expected = NoResultException.class)
	public void testGetCategoryNotFound() throws SQLException {
		ResultSet rs = mock(ResultSet.class);

		PreparedStatement ps = mock(PreparedStatement.class);
		when(ps.executeQuery()).thenReturn(rs);

		Connection connection = mock(Connection.class);
		when(connection.prepareStatement(anyString())).thenReturn(ps);

		when(dataSource.getConnection()).thenReturn(connection);

		categoryDaoSql.getCategory(0);
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
		when(connection.prepareStatement(SELECT_CATEGORY)).thenThrow(new SQLException());
		try {
			categoryDaoSql.getCategory(1);
		} finally {
			verify(dataSource).getConnection();
		}
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
		when(connection.prepareStatement(SELECT_CATEGORY)).thenThrow(new SQLException());
		try {
			categoryDaoSql.getCategories();
		} finally {
			verify(dataSource).getConnection();
		}
	}

	@Test
	public void testGetCategoriesNotFound() throws SQLException {
		ResultSet rs = mock(ResultSet.class);

		PreparedStatement ps = mock(PreparedStatement.class);
		when(ps.executeQuery()).thenReturn(rs);

		Connection connection = mock(Connection.class);
		when(connection.prepareStatement(anyString())).thenReturn(ps);

		when(dataSource.getConnection()).thenReturn(connection);

		List<Category> categories = categoryDaoSql.getCategories();
		assertThat(categories.isEmpty(), is(true));
	}

	@Test
	public void testGetCategories() throws SQLException {
		ResultSet rs = mock(ResultSet.class);
		when(rs.next()).thenReturn(true, false);
		when(rs.getInt("id")).thenReturn(1);
		when(rs.getString("name")).thenReturn("test");

		PreparedStatement ps = mock(PreparedStatement.class);
		when(ps.executeQuery()).thenReturn(rs);

		Connection connection = mock(Connection.class);
		when(connection.prepareStatement(anyString())).thenReturn(ps);

		when(dataSource.getConnection()).thenReturn(connection);

		List<Category> categories = categoryDaoSql.getCategories();
		Category category = categories.get(0);
		assertThat(category.getId(), is(1));
		assertThat(category.getName(), is("test"));
	}

}
