package com.anmertrix.dao.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.anmertrix.dao.DaoException;
import com.anmertrix.dao.RewardDao;
import com.anmertrix.domain.Reward;

@Repository
public class RewardDaoSql implements RewardDao {

	private static final String SELECT_REWARDS = "SELECT id, name, amount, description FROM reward";
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	public List<Reward> getRewards() {

		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(SELECT_REWARDS);
				ResultSet rs = statement.executeQuery()) {
			
			
			List<Reward> rewards = new ArrayList<>();
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int amount = rs.getInt("amount");
				String description = rs.getString("description");
				
				Reward reward = new Reward();
				reward.setId(id);
				reward.setName(name);
				reward.setAmount(amount);
				reward.setDescription(description);
				rewards.add(reward);				
			}
			return rewards;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

}
