package ua.com.goit.gojava7.kickstarter.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ua.com.goit.gojava7.kickstarter.dao.ProjectDbDao;

@RunWith(MockitoJUnitRunner.class)
public class ProjectDbDaoTest {

	@Mock
	private ResultSet resultSet;
	
	@InjectMocks
	ProjectDbDao projectDao;
	
	@Test
	public void testReadElement() throws SQLException {
		when(resultSet.getInt("id")).thenReturn(4);		
		assertThat(projectDao.readElement(resultSet).getId(), is(4));		
	}
}
