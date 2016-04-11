package com.anmertrix.dao.sql;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.never;

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

import com.anmertrix.domain.Reward;

@RunWith(MockitoJUnitRunner.class)
public class RewardDaoSqlTest {
	
	@Mock
	private DataSource dataSource;
	@Mock
	private Connection connection;
	@Mock
    PreparedStatement preparedStatement;
	@Mock
    ResultSet resultSet;
	@InjectMocks
	private RewardDaoSql rewardDaoSql;
	
	@Before
    public void setUp() throws SQLException {
		when(dataSource.getConnection()).thenReturn(connection);
		when(preparedStatement.executeQuery()).thenReturn(resultSet);
		when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
	}	

	@Test
	public void testGetRewards() throws SQLException {
		when(resultSet.next()).thenReturn(true, false);
		when(resultSet.getInt("id")).thenReturn(1);
		when(resultSet.getString("name")).thenReturn("test name");
		when(resultSet.getInt("amount")).thenReturn(10);
		when(resultSet.getString("description")).thenReturn("test description");

		List<Reward> rewards = rewardDaoSql.getRewards();
		Reward reward = rewards.get(0);
		assertThat(reward.getId(), is(1));
		assertThat(reward.getName(), is("test name"));
		assertThat(reward.getAmount(), is(10));
		assertThat(reward.getDescription(), is("test description"));
		
		verify(connection).prepareStatement(contains("SELECT id, name, amount, description FROM reward"));
		
		assertThat(rewards.isEmpty(), is(false));
		assertThat(rewards.size(), is(1));
		
		verify(resultSet, times(2)).next();
		verify(resultSet, times(2)).getInt(anyString());
		verify(resultSet, times(2)).getString(anyString());
		verify(dataSource, times(1)).getConnection();
		verify(connection, times(1)).prepareStatement(anyString());
		verify(preparedStatement, times(1)).executeQuery();
		
		verify(connection).close();
		verify(preparedStatement).close();
		verify(resultSet).close();
		
	}
	
	@Test
	public void testGetRewardsNotFound() throws SQLException {
		List<Reward> rewards = rewardDaoSql.getRewards();
		assertThat(rewards.isEmpty(), is(true));
		
		verify(connection).close();
		verify(preparedStatement).close();
		verify(resultSet).close();
	}
	
	@Test(expected = RuntimeException.class)
	public void testGetRewardsGetConnectionException() throws SQLException {
		when(dataSource.getConnection()).thenThrow(new SQLException());
		try {
			rewardDaoSql.getRewards();
		} finally {
			verify(dataSource).getConnection();
		}
		verify(preparedStatement, never()).executeQuery();
		verify(connection).close();
		verify(preparedStatement).close();
		verify(resultSet).close();
	}
	
	@Test(expected = RuntimeException.class)
	public void testGetRewardsCreateStatementException() throws SQLException {
		when(connection.prepareStatement(anyString())).thenThrow(new SQLException());
		try {
			rewardDaoSql.getRewards();
		} finally {
			verify(dataSource).getConnection();
			verify(connection).close();
		}
		verify(preparedStatement).close();
		verify(resultSet).close();
	}
	
	@Test(expected = RuntimeException.class)
	public void testGetRewardsGetResultSetException() throws SQLException {
		when(preparedStatement.executeQuery()).thenThrow(new SQLException());
		try {
			rewardDaoSql.getRewards();
		} finally {
			verify(dataSource).getConnection();
			verify(connection).close();
			verify(preparedStatement).close();	
		}
		verify(resultSet).close();
	}
	
}
