package ua.com.goit.gojava7.kickstarter.dao.db;

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

@RunWith(MockitoJUnitRunner.class)
public class RewardDbDaoTest {

	@Mock
	private ResultSet resultSet;	
	@InjectMocks
	RewardDbDao rewardDao;
		
	@Test
	public void testReadElement() throws SQLException {
		when(resultSet.getInt("id")).thenReturn(4);		
		assertThat(rewardDao.readElement(resultSet).getId(), is(4));		
	}
}
