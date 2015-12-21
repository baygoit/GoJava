package ua.com.goit.gojava7.kickstarter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import ua.com.goit.gojava7.kickstarter.models.Reward;

@Component
public class RewardDbDao extends DbDao<Reward> {
	
	private static final Logger log = LoggerFactory.getLogger(RewardDbDao.class);	 

	private static final String TABLE = "reward";
	private static final String FIELDS = "id, amount, reward, project_id";

	public RewardDbDao() {	
		log.info("Constructor RewardDbDao()...");		
		super.TABLE = TABLE;
		super.FIELDS = FIELDS;
	}
	
	public RewardDbDao(BasicDataSource basicDataSource) {
		super(basicDataSource, FIELDS, TABLE);
	}

	@Override
	protected Reward readElement(ResultSet resultSet) throws SQLException {
		log.info("readElement()...");			
		Reward reward = new Reward();
		reward.setId(resultSet.getInt("id"));
		reward.setAmount(resultSet.getInt("amount"));
		reward.setReward(resultSet.getString("reward"));
		reward.setProjectId(resultSet.getInt("project_id"));
		log.debug("readElement() returned reward: {}", reward);
		return reward;
	}

	public List<Reward> getByProject(int projectId) {
		log.info("getByProject({})...", projectId);	
		String query = "SELECT " + FIELDS + " FROM " + TABLE + " WHERE project_id = " + projectId;
		log.debug("getByProject({}) built query: {}", projectId, query);
		
		List<Reward> data = new ArrayList<>();
		try (Connection connection = basicDataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(query); ResultSet resultSet = ps.executeQuery()) {
			while (resultSet.next()) {
				data.add(readElement(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		log.debug("getByProject({}) returned rewards: {}", projectId, data);
		return data;
	}
}
