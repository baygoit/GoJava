package com.vladik.dao;

import com.vladik.model.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public abstract class AbstractQuoteDao {

    @Autowired
    public DataSource dataSource;
    @Autowired
    public JdbcTemplate jdbcTemplate;

    public abstract void add(Quote element);

    public abstract void remove(Quote element);

    public abstract int getSize();

    public abstract Quote getRandomQuote();

}
