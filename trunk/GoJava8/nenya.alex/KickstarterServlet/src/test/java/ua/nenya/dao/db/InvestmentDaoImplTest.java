package ua.nenya.dao.db;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import ua.nenya.domain.Project;
import ua.nenya.domain.Reward;

@Ignore
@RunWith(MockitoJUnitRunner.class)
public class InvestmentDaoImplTest {

	@Mock
	private JdbcTemplate jdbcTemplate;
	@InjectMocks
	private RewardDaoImpl rewardDaoImpl;

	private List<Reward> rewards;
	private Project newSongProject;

	@Before
	public void init() {
		rewards = new ArrayList<>();
		newSongProject = new Project();
		newSongProject.setName("New Song");
		Reward reward = new Reward();
		reward.setName("reward");
		rewards.add(reward);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testGetRewards() throws SQLException {
		when(jdbcTemplate.query(anyString(), new Object[] { anyString() }, Matchers.any(BeanPropertyRowMapper.class)))
				.thenReturn(rewards);

		List<Reward> testRewards = rewardDaoImpl.getRewards(1) ;
		assertThat(testRewards.get(0).getName(), is("reward"));
	}

	@Test
	public void testWriteIvestmentInProject() throws SQLException {

	}

}
