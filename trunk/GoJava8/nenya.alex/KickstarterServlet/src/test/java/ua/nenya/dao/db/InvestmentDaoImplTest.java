package ua.nenya.dao.db;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


import ua.nenya.domain.Project;
import ua.nenya.domain.Reward;

@RunWith(MockitoJUnitRunner.class)
public class InvestmentDaoImplTest {

	@Mock
	private DataSource dataSource;
	@InjectMocks
	private InvestmentDaoImpl investmentDaoImpl; 

	
	private Project newSongProject;

	@Before
	public void init() {
		List<Reward> rewards = new ArrayList<>();
		newSongProject = new Project();
		newSongProject.setName("New Song");
		Reward reward = new Reward();
		reward.setName("reward");
		rewards.add(reward);
	}

	
	
	@Test
	public void testGetRewards() throws SQLException {

		ResultSet rs = mock(ResultSet.class);
		when(rs.next()).thenReturn(true).thenReturn(false);
		when(rs.getString("name")).thenReturn("reward");
		

		PreparedStatement statement = mock(PreparedStatement.class);
		when(statement.executeQuery()).thenReturn(rs);

		Connection connection = mock(Connection.class);
		when(connection.prepareStatement(anyString())).thenReturn(statement);

		when(dataSource.getConnection()).thenReturn(connection);

		List<Reward> rewardsFromMethod = investmentDaoImpl.getRewards(newSongProject.getName());

		assertThat(rewardsFromMethod.get(0).getName(), is("reward"));
		verify(dataSource).getConnection();
	}
	
	@Test
	public void testWriteIvestmentInProject() throws SQLException {

		ResultSet rs = mock(ResultSet.class);
		PreparedStatement statement = mock(PreparedStatement.class);
		when(statement.executeQuery()).thenReturn(rs);

		Connection connection = mock(Connection.class);
		when(connection.prepareStatement(anyString())).thenReturn(statement);

		when(dataSource.getConnection()).thenReturn(connection);

		investmentDaoImpl.writeIvestmentInProject("New Song", 123);

		verify(dataSource, times(2)).getConnection();
	}
	
	
}
