package ua.com.goit.gojava7.kickstarter.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DbDaoTest {

	protected String FIELDS = null;
	protected String TABLE = null;
	
	@Mock
	Connection connection;
	@Mock
	BasicDataSource basicDataSource;
	@Mock
	PreparedStatement preparedStatement;
	@Mock
	ResultSet resultSet;	
	
	@Test
	@Ignore
	public void testSize() throws SQLException {		
		DbDao dbDao = Mockito.mock(DbDao.class, Mockito.CALLS_REAL_METHODS);
		when(resultSet.next()).thenReturn(false);	
		//assertNotEquals(dbDao.size(), 0);
		//assertThat(dbDao.size(), is(0));
		 Assert.assertThat(dbDao.size(), is(0));
	}

}
