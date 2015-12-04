package ua.com.goit.gojava7.kickstarter.dao.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

import ua.com.goit.gojava7.kickstarter.dao.DbDao;
import ua.com.goit.gojava7.kickstarter.dao.RewardDao;
import ua.com.goit.gojava7.kickstarter.domain.Reward;

public class RewardDbDao extends DbDao<Reward> implements RewardDao {

	private static final String TABLE = "reward";
	private static final String FIELDS = "id, amount, reward, project_id";

	public RewardDbDao(BasicDataSource basicDataSource) {
		super(basicDataSource, FIELDS, TABLE);
	}

	@Override
	public List<Reward> getByProject(String projectName) {
		String query = "SELECT " + FIELDS + " FROM " + TABLE + " WHERE project_id = "
				+ "(SELECT id FROM project WHERE name = '" + prepareStringForDb(projectName) + "')";
		List<Reward> data = new ArrayList<>();
		try (Connection connection = basicDataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(query);
				ResultSet resultSet = ps.executeQuery()) {
			while (resultSet.next()) {
				data.add(readElement(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	protected Reward readElement(ResultSet resultSet) throws SQLException {
		Reward reward = new Reward();
		reward.setId(resultSet.getInt("id"));
		reward.setAmount(resultSet.getInt("amount"));
		reward.setReward(resultSet.getString("reward"));
		reward.setProjectId(resultSet.getInt("project_id"));
		return reward;
	}

	@Override
	public List<Reward> getByProject(int projectId) {
		String query = "SELECT " + FIELDS + " FROM " + TABLE + " WHERE project_id = " + projectId;
		List<Reward> data = new ArrayList<>();
		try (Connection connection = basicDataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(query);
				ResultSet resultSet = ps.executeQuery()) {
			while (resultSet.next()) {
				data.add(readElement(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}
}
