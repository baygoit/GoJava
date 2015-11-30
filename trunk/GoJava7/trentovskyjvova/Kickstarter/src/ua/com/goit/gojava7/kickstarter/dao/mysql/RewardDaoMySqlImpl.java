package ua.com.goit.gojava7.kickstarter.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.RewardDao;
import ua.com.goit.gojava7.kickstarter.domain.Reward;
import ua.com.goit.gojava7.kickstarter.exception.IODatabaseException;

public class RewardDaoMySqlImpl implements RewardDao{
	private Connection connection;

	public RewardDaoMySqlImpl(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public List<Reward> getRewards(int projectId) {
		List<Reward> rewards = new ArrayList<>();

		try (PreparedStatement ps = connection
				.prepareStatement("SELECT id, pledge, benefit FROM reward WHERE projectId ="
						+ projectId);
				ResultSet rs = ps.executeQuery()) {

			Reward reward;
			while (rs.next()) {
				int id = rs.getInt("id");
				int pledge = rs.getInt("pledge");
				String benefit = rs.getString("benefit");

				reward = new Reward(id, projectId);
				reward.setPledge(pledge);
				reward.setBenefit(benefit);

				rewards.add(reward);
			}
		} catch (SQLException e) {

			throw new IODatabaseException("Problem with database", e);
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

}
