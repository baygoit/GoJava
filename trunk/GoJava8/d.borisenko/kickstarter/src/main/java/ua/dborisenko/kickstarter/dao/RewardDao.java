package ua.dborisenko.kickstarter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.dborisenko.kickstarter.domain.Project;
import ua.dborisenko.kickstarter.domain.Reward;

@Repository
public class RewardDao {
    private static final String QUERY_GET_REWARDS = "SELECT id, amount, description FROM rewards WHERE project_id = ?";
    @Autowired
    private DataSource dataSource;

    public void getRewards(Project project) {
        try (Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(QUERY_GET_REWARDS)) {
            statement.setInt(1, project.getId());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Reward reward = new Reward();
                reward.setId(rs.getInt("id"));
                reward.setAmount(rs.getInt("amount"));
                reward.setDescription(rs.getString("description"));
                project.addReward(reward);
            }
        } catch (SQLException | NullPointerException e) {
            throw new IllegalStateException(e);
        }
    }
}
