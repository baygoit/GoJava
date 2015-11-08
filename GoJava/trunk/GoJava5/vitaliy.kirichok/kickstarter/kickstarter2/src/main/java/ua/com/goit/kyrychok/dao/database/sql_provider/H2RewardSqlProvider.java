package ua.com.goit.kyrychok.dao.database.sql_provider;

public class H2RewardSqlProvider implements RewardSqlProvider {
    @Override
    public String get4Fetch() {
        return "SELECT r.reward_id AS id, " +
                "r.amount AS amount, " +
                "r.description AS description " +
                "FROM reward r " +
                "WHERE r.project_id = ? " +
                "ORDER BY r.amount, r.description";
    }

    @Override
    public String get4Load() {
        return "SELECT r.reward_id AS id, " +
                "r.amount AS amount, " +
                "r.description AS description " +
                "FROM reward r " +
                "WHERE r.reward_id = ?";
    }

    @Override
    public String get4Add() {
        return "insert into reward(amount, description, project_id) " +
                "values(?, ?, ?)";
    }
}
