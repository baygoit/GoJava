package ua.com.goit.gojava7.kickstarter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.models.Reward;

@Repository
public class RewardDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final Logger log = LoggerFactory.getLogger(RewardDao.class);

	public RewardDao() {
		log.info("Constructor RewardDao()...");
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Reward> getByProject(Long projectId) {
		log.info("<rewards> getByProject({})...", projectId);
		String query = "SELECT id, amount, reward, project_id FROM reward WHERE project_id = ?";
		return jdbcTemplate.query(query, new Object[] { projectId }, new RewardMapper());
	}

	public Reward get(int index) {
		log.info("<Reward> get({})...", index);
		String query = "select id, amount, reward, project_id from reward where id = ?";
		return jdbcTemplate.queryForObject(query, new Object[] { index }, new RewardMapper());
	}

	private final class RewardMapper implements RowMapper<Reward> {
		public Reward mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			log.info("RewardMapper()...");
			Reward reward = new Reward();
			reward.setRewardId(resultSet.getLong("id"));
			reward.setAmount(resultSet.getInt("amount"));
			reward.setReward(resultSet.getString("reward"));
			reward.setProjectId(resultSet.getLong("project_id"));
			log.debug("RewardMapper() returned reward: {}", reward);
			return reward;
		}
	}
}
