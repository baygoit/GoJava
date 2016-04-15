package com.sandarovich.kickstarter.dao.impl;

import com.sandarovich.kickstarter.dao.QuoteDao;
import com.sandarovich.kickstarter.model.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class QuoteDaoPostgreImpl implements QuoteDao {

    public static final String SQL_GET_RANDOM_QUOTE = "SELECT text, author " +
        "FROM " +
        "public.quote " +
        "ORDER BY RANDOM() LIMIT(1);";

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public Quote getRandomQuota() {
        Quote quote = jdbcTemplate.queryForObject(SQL_GET_RANDOM_QUOTE, new QuoteRowMapper());
        return quote != null ? quote : new Quote("No Author", "No text");
    }

    private final class QuoteRowMapper implements RowMapper<Quote> {
        public Quote mapRow(ResultSet rs, int rowNum) throws SQLException {
            String author = rs.getString("author");
            String text = rs.getString("text");
            return new Quote(author, text);
        }
    }
}

