package com.morkva.model.dao.jdbc.postgres;

import com.morkva.entities.Quote;
import com.morkva.model.dao.DAO;

import java.sql.Connection;
import java.util.List;

/**
 * Created by koros on 06.06.2015.
 */
public class PostgreQuoteDAO implements DAO<Quote> {

    private final Connection connection;

    public PostgreQuoteDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Quote object) {

    }

    @Override
    public void delete(Quote object) {

    }

    @Override
    public Quote getById(int id) {
        return null;
    }

    @Override
    public void update(Quote object) {

    }

    @Override
    public List<Quote> getAll() {
        return null;
    }
}
