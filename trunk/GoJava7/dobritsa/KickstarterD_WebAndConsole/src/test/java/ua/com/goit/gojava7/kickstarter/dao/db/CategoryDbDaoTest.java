package ua.com.goit.gojava7.kickstarter.dao.db;

import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CategoryDbDaoTest {

	@Mock
	private ResultSet resultSet;
	@Mock
	BasicDataSource basicDataSource;
	@InjectMocks
	CategoryDbDao categoryDao;

	@Test
	public void testReadElement() throws SQLException {
		when(resultSet.getInt("id")).thenReturn(4);		
		assertThat(categoryDao.readElement(resultSet).getId(), is(4));	
	}
}
