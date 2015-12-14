package ua.com.goit.gojava7.kickstarter.dao.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.stereotype.Component;

import ua.com.goit.gojava7.kickstarter.dao.DbDao;
import ua.com.goit.gojava7.kickstarter.dao.RewardDao;
import ua.com.goit.gojava7.kickstarter.domain.Reward;

@Component
public class RewardDbDao extends DbDao<Reward> implements RewardDao {

	private static final String TABLE = "reward";
	private static final String FIELDS = "id, amount, reward, project_id";

	public RewardDbDao() {	
		super.TABLE = TABLE;
		super.FIELDS = FIELDS;
	}
	
	public RewardDbDao(BasicDataSource basicDataSource) {
		super(basicDataSource, FIELDS, TABLE);
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
		try (PreparedStatement ps = basicDataSource.getConnection().prepareStatement(query);
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
