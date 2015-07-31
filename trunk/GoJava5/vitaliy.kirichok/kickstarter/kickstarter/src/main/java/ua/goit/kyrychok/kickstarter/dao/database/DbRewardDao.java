package ua.goit.kyrychok.kickstarter.dao.database;

import ua.goit.kyrychok.kickstarter.dao.RewardDao;
import ua.goit.kyrychok.kickstarter.model.Reward;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DbRewardDao implements RewardDao {
    private DbDataSourceProvider dbDataSourceProvider;

    public DbRewardDao(DbDataSourceProvider dbDataSourceProvider) {
        this.dbDataSourceProvider = dbDataSourceProvider;
    }

    @Override
    public List<Reward> fetch(int projectId) {
        List<Reward> result = new ArrayList<>();
        String sql = "SELECT r.reward_id AS id, " +
                "r.amount AS amount, " +
                "r.description AS description " +
                "FROM reward r " +
                "WHERE r.project_id = ? " +
                "ORDER BY r.amount, r.description";
        try (Connection connection = dbDataSourceProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, projectId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Reward reward = new Reward(resultSet.getInt("amount"), resultSet.getString("description"));
                reward.setId(resultSet.getInt("id"));
                result.add(reward);
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Reward load(int id) {
        Reward result = null;
        String sql = "SELECT r.reward_id AS id, " +
                "r.amount AS amount, " +
                "r.description AS description " +
                "FROM reward r " +
                "WHERE r.reward_id = ? ";
        try (Connection connection = dbDataSourceProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result = new Reward(resultSet.getInt("amount"), resultSet.getString("description"));
                result.setId(resultSet.getInt("id"));
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}
