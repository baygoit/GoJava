package com.vladik.dao.impl;

import com.vladik.dao.AbstractQuoteDao;
import com.vladik.model.Quote;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class QuoteDaoMysqlImpl extends AbstractQuoteDao {
    private static final String INSERT_QUOTE = "INSERT INTO Quotes (text, author) VALUES (?, ?)";
    private static final String DELETE_QUOTE = "DELETE FROM Quotes WHERE author = ?";
    private static final String SELECT_RANDOM_QUOTE = "SELECT text, author FROM Quotes ORDER BY RAND() LIMIT 1";
    private static final String COUNT_ALL_QUOTES = "SELECT count(*) FROM Quotes";

    @Override
    public void add(Quote quote) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT_QUOTE);
            statement.setString(1, quote.getText());
            statement.setString(2, quote.getAuthor());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Quote quote) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_QUOTE);
            statement.setString(1, quote.getAuthor());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getSize() {
        int amountOfQuotes = 0;
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(COUNT_ALL_QUOTES);
            while (resultSet.next()) {
                amountOfQuotes = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return amountOfQuotes;
    }

    @Override
    public Quote getRandomQuote() {
        return (Quote) jdbcTemplate.queryForObject(SELECT_RANDOM_QUOTE,new BeanPropertyRowMapper(Quote.class));
    }
}
