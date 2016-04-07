package com.sandarovich.kickstarter.dao.quote;

import com.sandarovich.kickstarter.dao.DaoDB;
import com.sandarovich.kickstarter.dao.DaoException;
import com.sandarovich.kickstarter.dao.NoResultException;
import com.sandarovich.kickstarter.domain.Quote;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Quate Dao for Db
 */

public class QuoteDaoDbImpl extends DaoDB implements QuoteDao {

    public static final String SQL_GET_RANDOM_QUOTE = "SELECT text, author " +
        "FROM " +
        "public.quote " +
        "ORDER BY RANDOM() LIMIT(1);";

    @Override
    public Quote getRandomQuota() {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_GET_RANDOM_QUOTE)) {
            ResultSet rs = statement.executeQuery();
            if (!rs.next()) {
                throw new NoResultException("No records found in Quote table.");
            }
            return new Quote(rs.getString("AUTHOR"), rs.getString("TEXT"));
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}

