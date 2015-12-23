package ua.com.goit.gojava7.kickstarter.dao.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.beans.Reward;
import ua.com.goit.gojava7.kickstarter.dao.AbstractJdbcTemplate;
import ua.com.goit.gojava7.kickstarter.dao.RewardDao;

@Repository
public class RewardDaoMysqlImpl extends AbstractJdbcTemplate implements RewardDao {

	public void add(Reward reward) {
		String sql = "INSERT INTO rewards (projectId, donatingSum, description) VALUES (?,?,?)";
		getJdbcTemplate().update(sql, new Object[] { reward.getProjectID(), reward.getDonatingSum(), reward.getDescription() });
	}

	public void remove(Reward reward) {
		String sql = "DELETE FROM rewards WHERE projectId = ?";
		getJdbcTemplate().update(sql, new Object[] { reward.getProjectID() });
	}

	public List<Reward> getProjectsRewards(int projectId) {
		String sql = "SELECT id, projectId, donatingSum, description FROM rewards WHERE projectId = ?";
		return getJdbcTemplate().query(sql, new Object[] { projectId }, new RewardRowMapper());
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
