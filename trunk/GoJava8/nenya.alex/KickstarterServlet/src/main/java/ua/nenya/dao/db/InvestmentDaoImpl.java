package ua.nenya.dao.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.nenya.dao.InvestmentDao;
import ua.nenya.domain.Reward;

@Repository
public class InvestmentDaoImpl implements InvestmentDao {

	private static final String GET_REWARDS_BY_PROJECT_NAME = "SELECT name, amount, rewards.description AS description FROM projects "
			+ "INNER JOIN rewards ON projects.id = rewards.project_id WHERE project_name = ?";
	private static final String GET_PROJECT_ID_BY_PROJECT_NAME = "SELECT id FROM projects WHERE project_name = ?";
	private static final String WRITE_INVESTMENT_IN_PROJECT = "INSERT INTO PAYMENTS (project_id, amount) VALUES (?, ?)";

	@Autowired
	private DataSource dataSource;

	@Override
	public List<Reward> getRewards(String projectName) {
		List<Reward> rewards = new ArrayList<>();
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(GET_REWARDS_BY_PROJECT_NAME)) {
			statement.setString(1, projectName);
			ResultSet set = statement.executeQuery();
			while (set.next()) {
				Reward reward = new Reward();
				String name = set.getString("name");
				int amount = set.getInt("amount");
				String description = set.getString("description");
				reward.setName(name);
				reward.setDescription(description);
				reward.setAmount(amount);
				rewards.add(reward);
			}
		} catch (SQLException e) {
			e.getStackTrace();
		}
		return rewards;
	}

	@Override
	public void writeIvestmentInProject(String projectName, int amount) {

		int id = getProjectId(projectName);
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(WRITE_INVESTMENT_IN_PROJECT)) {
			statement.setInt(1, id);
			statement.setInt(2, amount);
			statement.executeQuery();
		} catch (SQLException e) {
			e.getStackTrace();
		}
	}

	private int getProjectId(String projectName) {
		int id = 0;
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(GET_PROJECT_ID_BY_PROJECT_NAME)) {
			statement.setString(1, projectName);
			ResultSet set = statement.executeQuery();
			set.next();
			id = set.getInt("id");
		} catch (SQLException e) {
			e.getStackTrace();
		}
		return id;
	}
}
