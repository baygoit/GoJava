package ua.dborisenko.kickstarter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ua.dborisenko.kickstarter.domain.Project;
import ua.dborisenko.kickstarter.domain.Reward;

@Repository
public class RewardDao {

    private final class RewardRowMapper implements RowMapper<Reward> {
        @Override
        public Reward mapRow(ResultSet rs, int rowNum) throws SQLException {
            Reward reward = new Reward();
            reward.setId(rs.getInt("id"));
            reward.setAmount(rs.getInt("amount"));
            reward.setDescription(rs.getString("description"));
            return reward;
        }
    }

    private static final String QUERY_GET_REWARDS = "SELECT id, amount, description FROM rewards WHERE project_id = ?";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void getAllForProject(Project project) {
        project.setRewards(
                jdbcTemplate.query(QUERY_GET_REWARDS, new Object[] { project.getId() }, new RewardRowMapper()));
    }
}
