package com.sandarovich.kickstarter.dao.quote;

import com.sandarovich.kickstarter.ConnectionManager;
import com.sandarovich.kickstarter.domain.Quote;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Quate Dao for Db
 */

public class QuoteDaoDbImpl implements QuoteDao {

    private ConnectionManager connectionManager;

    public QuoteDaoDbImpl(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    @Override
    public Quote getRandomQuota() {
        try (Statement statement = connectionManager.getConnection().createStatement()) {
            String query = "SELECT text, author " +
                "FROM " +
                "public.quote " +
                "ORDER BY RANDOM() LIMIT(1);";
            ResultSet rs = statement.executeQuery(query);
            if (!rs.next()) {
                throw new SQLException("No records found in Quote table.");
            }
            Quote result = new Quote(rs.getString("AUTHOR"), rs.getString("TEXT"));
            connectionManager.closeConnection();
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
