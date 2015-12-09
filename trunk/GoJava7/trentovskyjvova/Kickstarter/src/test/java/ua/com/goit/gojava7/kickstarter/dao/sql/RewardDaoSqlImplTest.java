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

import ua.com.goit.gojava7.kickstarter.config.DBConnectionManager;
import ua.com.goit.gojava7.kickstarter.dao.RewardDao;
import ua.com.goit.gojava7.kickstarter.dao.sql.RewardDaoSqlImpl;
import ua.com.goit.gojava7.kickstarter.domain.Reward;

public class RewardDaoSqlImplTest {
	
	@Mock
	private Connection connection = mock(Connection.class);
	@Mock
	DBConnectionManager connectionManager = mock(DBConnectionManager.class);
	@InjectMocks
	private RewardDao rewardDaoMySqlImpl = new RewardDaoSqlImpl(connectionManager);
	
	@Test
	public void testGetReward() throws SQLException {
		PreparedStatement ps = mock(PreparedStatement.class);
		ResultSet rs = mock(ResultSet.class);
		when(connectionManager.getConnection()).thenReturn(connection);
		when(connection.prepareStatement(anyString())).thenReturn(ps);
		when(ps.executeQuery()).thenReturn(rs);
		when(rs.next()).thenReturn(true, false);
		when(rs.getString("benefit")).thenReturn("some reward benefit");
		
		Reward reward = rewardDaoMySqlImpl.getReward(1, 1);

		assertThat(reward.getBenefit(), is("some reward benefit"));
	}
	
	@Test
	public void testGetRewards() throws SQLException {
		PreparedStatement ps = mock(PreparedStatement.class);
		ResultSet rs = mock(ResultSet.class);
		when(connectionManager.getConnection()).thenReturn(connection);
		when(connection.prepareStatement(anyString())).thenReturn(ps);
		when(ps.executeQuery()).thenReturn(rs);
		when(rs.next()).thenReturn(true, false);
		when(rs.getString("benefit")).thenReturn("some reward benefit");

		List<Reward> rewards = rewardDaoMySqlImpl.getRewards(1);

		assertThat(rewards.get(0).getBenefit(), is("some reward benefit"));
	}
	
	@Test
	public void testSize() throws SQLException {
		PreparedStatement ps = mock(PreparedStatement.class);
		ResultSet rs = mock(ResultSet.class);
		when(connectionManager.getConnection()).thenReturn(connection);
		when(connection.prepareStatement(anyString())).thenReturn(ps);
		when(ps.executeQuery()).thenReturn(rs);
		when(rs.next()).thenReturn(true, false);
		when(rs.getInt("size")).thenReturn(1);

		int size = rewardDaoMySqlImpl.size(1);

		assertThat(size, is(1));
	}
	
	@Test
	public void testGetRewardById() throws SQLException {
		PreparedStatement ps = mock(PreparedStatement.class);
		ResultSet rs = mock(ResultSet.class);
		when(connectionManager.getConnection()).thenReturn(connection);
		when(connection.prepareStatement(anyString())).thenReturn(ps);
		when(ps.executeQuery()).thenReturn(rs);
		when(rs.next()).thenReturn(true, false);
		when(rs.getString("benefit")).thenReturn("some reward benefit");
		
		Reward reward = rewardDaoMySqlImpl.getReward(12);

		assertThat(reward.getId(), is(12));
	}
	
}
