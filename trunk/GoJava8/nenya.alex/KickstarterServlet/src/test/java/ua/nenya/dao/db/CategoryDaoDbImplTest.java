package ua.nenya.dao.db;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import ua.nenya.domain.Category;

@RunWith(MockitoJUnitRunner.class)
public class CategoryDaoDbImplTest {

	@Mock
	private DataSource dataSource;
	@InjectMocks
	private CategoryDaoImpl categoryDaoImpl; 


	@Test
	public void testGetCategories() throws SQLException {

		ResultSet rs = mock(ResultSet.class);
		when(rs.next()).thenReturn(true).thenReturn(true).thenReturn(false);
		when(rs.getString("category_name")).thenReturn("Music").thenReturn("Film");
		

		PreparedStatement statement = mock(PreparedStatement.class);
		when(statement.executeQuery()).thenReturn(rs);

		Connection connection = mock(Connection.class);
		when(connection.prepareStatement(anyString())).thenReturn(statement);

		when(dataSource.getConnection()).thenReturn(connection);

		
		List<Category> categoriesFromMethod = categoryDaoImpl.getCategories();

		assertThat(categoriesFromMethod.get(0).getName(), is("Music"));
		assertThat(categoriesFromMethod.get(1).getName(), is("Film"));
		verify(dataSource).getConnection();

	}

	
}
