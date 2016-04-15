package com.vladik.dao.impl;

import com.vladik.dao.AbstractRewardDao;
import com.vladik.model.Project;
import com.vladik.model.Reward;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RewardsDaoMysqlImpl extends AbstractRewardDao {
    private static final String SELECT_REWARDS_FROM_PROJECT = "SELECT id, amount, description FROM Rewards WHERE project_id = ?";

    @Override
    public List<Reward> getRewardsForProject(Project project) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_REWARDS_FROM_PROJECT)) {
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
        return project.getRewardList();
    }
}
