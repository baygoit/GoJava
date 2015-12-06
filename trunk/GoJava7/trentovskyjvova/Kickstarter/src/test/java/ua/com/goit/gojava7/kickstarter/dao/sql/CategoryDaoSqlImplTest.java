package ua.com.goit.gojava7.kickstarter.dao.sql;

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

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import ua.com.goit.gojava7.kickstarter.config.DaoProvider;
import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.dao.sql.CategoryDaoSqlImpl;
import ua.com.goit.gojava7.kickstarter.domain.Category;

public class CategoryDaoSqlImplTest {
	
	@Mock
	private Connection connection = mock(Connection.class);
	@Mock
	DaoProvider daoProvider = mock(DaoProvider.class);
	@InjectMocks
	private CategoryDao categoryDaoMySqlImpl = new CategoryDaoSqlImpl(daoProvider);
	
	@Test
	public void testGetCategory() throws SQLException {
		PreparedStatement ps = mock(PreparedStatement.class);
		ResultSet rs = mock(ResultSet.class);
		when(daoProvider.getConnection()).thenReturn(connection);
		when(connection.prepareStatement(anyString())).thenReturn(ps);
		when(ps.executeQuery()).thenReturn(rs);
		when(rs.next()).thenReturn(true, false);
		when(rs.getString("name")).thenReturn("some cotegory name");

		Category category = categoryDaoMySqlImpl.getCategory(1);

		assertThat(category.getName(), is("some cotegory name"));
	}
	
	@Test
	public void testGetCategories() throws SQLException {
		PreparedStatement ps = mock(PreparedStatement.class);
		ResultSet rs = mock(ResultSet.class);
		when(daoProvider.getConnection()).thenReturn(connection);
		when(connection.prepareStatement(anyString())).thenReturn(ps);
		when(ps.executeQuery()).thenReturn(rs);
		when(rs.next()).thenReturn(true, false);
		when(rs.getString("name")).thenReturn("some cotegory name");

		List<Category> categories = categoryDaoMySqlImpl.getCategories();

		assertThat(categories.get(0).getName(), is("some cotegory name"));
	}
	
	@Test
	public void testSize() throws SQLException {
		PreparedStatement ps = mock(PreparedStatement.class);
		ResultSet rs = mock(ResultSet.class);
		when(daoProvider.getConnection()).thenReturn(connection);
		when(connection.prepareStatement(anyString())).thenReturn(ps);
		when(ps.executeQuery()).thenReturn(rs);
		when(rs.next()).thenReturn(true, false);
		when(rs.getInt("size")).thenReturn(1);

		int size = categoryDaoMySqlImpl.size();

		assertThat(size, is(1));
	}
}
