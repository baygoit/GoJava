package ua.com.goit.gojava7.kickstarter.dao.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import ua.com.goit.gojava7.kickstarter.dao.RewardDao;
import ua.com.goit.gojava7.kickstarter.domain.Reward;
import ua.com.goit.gojava7.kickstarter.exception.IODatabaseException;

public class RewardDaoSqlImpl implements RewardDao {
	private DataSource dataSource;

	public RewardDaoSqlImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<Reward> getRewards(int projectId) {
		List<Reward> rewards = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement("SELECT id, pledge, benefit FROM reward WHERE projectId =" + projectId);
			rset = stmt.executeQuery();

			Reward reward;
			while (rset.next()) {
				int id = rset.getInt("id");
				int pledge = rset.getInt("pledge");
				String benefit = rset.getString("benefit");

				reward = new Reward(id, projectId);
				reward.setPledge(pledge);
				reward.setBenefit(benefit);

				rewards.add(reward);
			}
		} catch (SQLException e) {
			throw new IODatabaseException("Problem with database", e);
		}finally {
            try { if (rset != null) rset.close(); } catch(Exception e) { }
            try { if (stmt != null) stmt.close(); } catch(Exception e) { }
            try { if (conn != null) conn.close(); } catch(Exception e) { }
		}
		
		return rewards;
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
		return getRewards(projectId).size();
	}

	@Override
	public Reward getReward(int rewardId) {
		Reward reward = null;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement("SELECT projectId, pledge, benefit FROM reward WHERE id =" + rewardId);
			rset = stmt.executeQuery();

			if (rset.next()) {
				int projectId = rset.getInt("projectId");
				int pledge = rset.getInt("pledge");
				String benefit = rset.getString("benefit");

				reward = new Reward(rewardId, projectId);
				reward.setPledge(pledge);
				reward.setBenefit(benefit);
				
			}
		} catch (SQLException e) {
			throw new IODatabaseException("Problem with database", e);
		}finally {
            try { if (rset != null) rset.close(); } catch(Exception e) { }
            try { if (stmt != null) stmt.close(); } catch(Exception e) { }
            try { if (conn != null) conn.close(); } catch(Exception e) { }
		}
		
		return reward;
	}

}
