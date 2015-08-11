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
    private RewardSqlProvider sqlProvider;

    public DbRewardDao(DbDataSourceProvider dbDataSourceProvider, RewardSqlProvider sqlProvider) {
        this.dbDataSourceProvider = dbDataSourceProvider;
        this.sqlProvider = sqlProvider;
    }

    @Override
    public List<Reward> fetch(int projectId) {
        List<Reward> result = new ArrayList<>();
        try (Connection connection = dbDataSourceProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlProvider.get4Fetch())) {
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
        try (Connection connection = dbDataSourceProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlProvider.get4Load())) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                result = new Reward(resultSet.getInt("amount"), resultSet.getString("description"));
                result.setId(resultSet.getInt("id"));
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    void add(int projectId, Reward reward, Connection connection) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(sqlProvider.get4Add(), new String[]{"reward_id"})) {
            statement.setInt(1, reward.getAmount());
            statement.setString(2, reward.getDescription());
            statement.setInt(3, projectId);
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    reward.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Can't receive reward ID.");
                }
            }
        }
    }

    void addList(int projectId, List<Reward> rewards, Connection connection) throws SQLException {
        for (Reward reward : rewards) {
            add(projectId, reward, connection);
        }
    }
}
