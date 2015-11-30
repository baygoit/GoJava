package ua.com.goit.gojava7.kickstarter.dao.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.DbDao;
import ua.com.goit.gojava7.kickstarter.dao.storage.RewardStorage;
import ua.com.goit.gojava7.kickstarter.domain.Reward;

public class RewardDbDao extends DbDao<Reward> implements RewardStorage {

	private static String TABLE = "reward";
	private static String FIELDS = "amount, reward";

	public RewardDbDao(Connection connection) {
		super(connection, FIELDS, TABLE);
	} 

	@Override
	public List<Reward> getByProject(String projectName) {	
		String query = "select amount, reward from reward where project_id = "
				+ "(select id from project where name = '" + prepareStringForDb(projectName) + "')";
		List<Reward> rewards = new ArrayList<>();
		try (PreparedStatement ps = connection.prepareStatement(query); ResultSet resultSet = ps.executeQuery()) {
			while (resultSet.next()) {
				Reward reward = new Reward();
				reward.setAmount(resultSet.getInt("amount"));
				reward.setReward(resultSet.getString("reward"));
				rewards.add(reward);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rewards;
	}

	@Override
	protected Reward readElement(ResultSet resultSet) throws SQLException {
		Reward reward = new Reward();
		reward.setAmount(resultSet.getInt("amount"));
		reward.setReward(resultSet.getString("reward"));
		return reward;
	}

	@Override
	public void add(Reward element) {
		// TODO Auto-generated method stub
		
	}

}
