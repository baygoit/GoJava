package ua.goit.kyrychok.kickstarter.dao.database.sql_provider;

import ua.goit.kyrychok.kickstarter.dao.database.RewardSqlProvider;

public class OraRewardSqlProvider implements RewardSqlProvider {
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
        return "insert into reward(reward_id, amount, description, project_id) " +
                "values(reward_id_seq.nextval, ?, ?, ?)";
    }
}
