package com.anmertrix.dao.sql;

import static org.hamcrest.CoreMatchers.is;
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
import org.junit.Ignore;
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

	@Ignore
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
	
	@Ignore
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

}
