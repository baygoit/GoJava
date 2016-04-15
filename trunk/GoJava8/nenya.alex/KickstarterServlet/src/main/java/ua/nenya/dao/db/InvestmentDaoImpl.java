package ua.nenya.dao.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ua.nenya.dao.InvestmentDao;
import ua.nenya.domain.Reward;

@Repository
public class InvestmentDaoImpl implements InvestmentDao {

	private static final String GET_REWARDS_BY_PROJECT_NAME = "SELECT rewards.name, amount, rewards.description AS description FROM projects "
			+ "INNER JOIN rewards ON projects.id = rewards.project_id WHERE projects.name = ?";
	private static final String GET_PROJECT_ID_BY_PROJECT_NAME = "SELECT id FROM projects WHERE name = ?";
	private static final String WRITE_INVESTMENT_IN_PROJECT = "INSERT INTO PAYMENTS (project_id, amount) VALUES (?, ?)";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Reward> getRewards(String projectName) {
		return jdbcTemplate.query(GET_REWARDS_BY_PROJECT_NAME, new Object[] { projectName },
				new BeanPropertyRowMapper<Reward>(Reward.class));
	}

	@Override
	public void writeIvestmentInProject(String projectName, int amount) {
		int id = getProjectId(projectName);
		jdbcTemplate.update(WRITE_INVESTMENT_IN_PROJECT, new Object[] { id, amount });
	}

	private int getProjectId(String projectName) {
		return jdbcTemplate.queryForObject(GET_PROJECT_ID_BY_PROJECT_NAME, new Object[] { projectName }, Integer.class);
	}
}
