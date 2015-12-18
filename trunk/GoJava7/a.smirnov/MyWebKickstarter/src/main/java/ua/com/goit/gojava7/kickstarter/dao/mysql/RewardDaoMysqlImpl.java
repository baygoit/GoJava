package ua.com.goit.gojava7.kickstarter.dao.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import ua.com.goit.gojava7.kickstarter.beans.Reward;
import ua.com.goit.gojava7.kickstarter.dao.AbstractDao;
import ua.com.goit.gojava7.kickstarter.dao.RewardDao;

public class RewardDaoMysqlImpl extends AbstractDao implements RewardDao {

	public void add(Reward reward) {
		String sql = "INSERT INTO rewards (projectId, donatingSum, description) VALUES (?,?,?)";
		jdbcTemplate.update(sql, new Object[] { reward.getProjectID(), reward.getDonatingSum(), reward.getDescription() });
	}

	public void remove(Reward reward) {
		String sql = "DELETE FROM rewards WHERE projectId = ?";
		jdbcTemplate.update(sql, new Object[] { reward.getProjectID() });
	}

	public List<Reward> getProjectsRewards(int projectId) {
		String sql = "SELECT id, projectId, donatingSum, description FROM rewards WHERE projectId = ?";
		return jdbcTemplate.query(sql, new Object[] { projectId }, new RewardRowMapper());
	}

	public class RewardRowMapper implements RowMapper<Reward> {
		@Override
		public Reward mapRow(ResultSet rs, int rowNum) throws SQLException {
			Reward reward = new Reward();
			reward.setProjectID(rs.getInt("projectId"));
			reward.setDonatingSum(rs.getInt("donatingSum"));
			reward.setDescription(rs.getString("description"));
			return reward;
		}
	}
}
