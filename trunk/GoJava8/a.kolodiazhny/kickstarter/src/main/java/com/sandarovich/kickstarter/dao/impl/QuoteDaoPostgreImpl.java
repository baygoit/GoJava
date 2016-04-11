package com.sandarovich.kickstarter.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sandarovich.kickstarter.dao.QuoteDao;
import com.sandarovich.kickstarter.model.Quote;

@Repository
public class QuoteDaoPostgreImpl implements QuoteDao {

    private final class QuoteRowMapper implements RowMapper<Quote> {
		public Quote mapRow(ResultSet rs, int rowNum) throws SQLException {
			String author = rs.getString("author");
			String text = rs.getString("text");
			return new Quote(author, text);
		}
	}

	private static final String SQL_GET_RANDOM_QUOTE = "SELECT text, author " +
        "FROM " +
        "public.quote " +
        "ORDER BY RANDOM() LIMIT(1);";

    @Autowired
	private JdbcTemplate jdbcTemplate;

    @Override
    public Quote getRandomQuota() {
		return this.jdbcTemplate.queryForObject(SQL_GET_RANDOM_QUOTE,
				new QuoteRowMapper());
    }
}

