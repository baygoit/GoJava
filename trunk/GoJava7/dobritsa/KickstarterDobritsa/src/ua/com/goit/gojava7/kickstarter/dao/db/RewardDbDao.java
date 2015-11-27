package ua.com.goit.gojava7.kickstarter.dao.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.storage.RewardStorage;
import ua.com.goit.gojava7.kickstarter.domain.Reward;

public class RewardDbDao implements RewardStorage {
	private Connection connection;

	public RewardDbDao(Connection connection) {
		this.connection = connection;
	}
	
	List<Reward> rewards = new ArrayList<>();
	
	@Override
	public List<Reward> getAll() {		
			List<Reward> rewards = new ArrayList<>();
			String query = "select amount, reward from reward";
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
	public List<Reward> getByProject(String projectName) {
		String query = "select amount, reward from reward where project_id = (select id from project where name = '" + prepareStringForDb(projectName) + "')";
		List<Reward> rewards = new ArrayList<>();
		try (PreparedStatement ps = connection.prepareStatement(query); 
				ResultSet resultSet = ps.executeQuery()) {
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
	
	
	public String prepareStringForDb(String original) {		
		return original.replace("'", "\\'");
	}
	
	@Override
	public void setAll(List<Reward> rewards) {
		this.rewards = rewards;
	}

	@Override
	public Reward get(int index) {
		Reward reward = new Reward();
		String query = "select amount, reward from reward where id = " + (index + 1);		
		try (PreparedStatement ps = connection.prepareStatement(query); 
				ResultSet resultSet = ps.executeQuery()) {
			while (resultSet.next()) {				
				reward.setAmount(resultSet.getInt("amount"));
				reward.setReward(resultSet.getString("reward"));						
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reward;
	}

	@Override
	public int size() {
		int size = 0;
		String query = "select count(*) as cnt from reward";
		try (PreparedStatement ps = connection.prepareStatement(query); ResultSet resultSet = ps.executeQuery()) {
			if (resultSet.next()) {
				size = (resultSet.getInt("cnt"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return size;
	}

}
