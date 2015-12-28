package ua.com.goit.gojava7.kickstarter.dao.sql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.dao.RewardDao;
import ua.com.goit.gojava7.kickstarter.domain.Reward;

@Repository
public class RewardDaoSqlImpl implements RewardDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Reward> getRewards(int projectId) {

		String sql = "SELECT id, projectId, pledge, benefit FROM reward WHERE projectId = ?";
		return jdbcTemplate.query(sql, new Integer[] { projectId }, new BeanPropertyRowMapper<Reward>(Reward.class));
	}

	@Override
	public Reward getReward(int userChoise, int projectId) {
		if (userChoise == 0) {
			return null;
		} else {
			List<Reward> reward = getRewards(projectId);
			return reward.get(userChoise - 1);
		}
	}

	@Override
	public int size(int projectId) {

		String sql = "SELECT COUNT(*) size FROM reward WHERE projectId = ?";
		return jdbcTemplate.queryForObject(sql, new Integer[] { projectId }, Integer.class);
	}

	@Override
	public Reward getReward(int rewardId) {

		String sql = "SELECT id, projectId, pledge, benefit FROM reward WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, new Integer[] { rewardId },
				new BeanPropertyRowMapper<Reward>(Reward.class));
	}

}
