package ua.com.goit.gojava7.kickstarter.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.beans.Reward;
import ua.com.goit.gojava7.kickstarter.config.ConnectionPoolSource;
import ua.com.goit.gojava7.kickstarter.dao.RewardDao;

public class RewardDaoMysqlImpl implements RewardDao {

	private static final String INSERT_REWARD = "INSERT INTO rewards (projectId, donatingSum, description) VALUES (?,?,?)";
	private static final String DELETE_REWARD = "DELETE FROM rewards WHERE projectId = ?";
	private static final String SELECT_PROJECTS_REWARDS = "SELECT id, projectId, donatingSum, description FROM rewards WHERE projectId = ?";

	private ConnectionPoolSource dataSource;

	public RewardDaoMysqlImpl(ConnectionPoolSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void add(Reward reward) {

		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(INSERT_REWARD)) {

			statement.setInt(1, reward.getProjectID());
			statement.setInt(2, reward.getDonatingSum());
			statement.setString(3, reward.getDescription());

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remove(Reward reward) {

		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_REWARD)) {

			statement.setInt(1, reward.getProjectID());

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Reward> getProjectsRewards(int projectId) {

		List<Reward> rewards = new ArrayList<>();

		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(SELECT_PROJECTS_REWARDS)) {

			statement.setInt(1, projectId);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {

				Reward reward = new Reward();
				reward.setProjectID(resultSet.getInt("projectId"));
				reward.setDonatingSum(resultSet.getInt("donatingSum"));
				reward.setDescription(resultSet.getString("description"));

				rewards.add(reward);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rewards;
	}
}
