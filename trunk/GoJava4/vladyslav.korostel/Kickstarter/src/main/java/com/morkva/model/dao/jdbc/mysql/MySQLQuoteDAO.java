package com.morkva.model.dao.jdbc.mysql;

import com.morkva.entities.Quote;
import com.morkva.model.dao.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by koros on 06.06.2015.
 */
public class MySQLQuoteDAO implements DAO<Quote> {

    private final Connection connection;

    public MySQLQuoteDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Quote create(Quote object) {
        return null;
    }

    @Override
    public void delete(Quote object) {

    }

    @Override
    public Quote getById(int id) throws SQLException {
        String sql = "SELECT * FROM quotes WHERE id = ?;";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, id);

        ResultSet rs = statement.executeQuery();
        rs.next();
        Quote quote = new Quote(rs.getInt("id"), rs.getString("value"), rs.getString("author"));
        return quote;
    }

    @Override
    public void update(Quote object) {

    }

    @Override
    public List<Quote> getAll() throws SQLException {
        String sql = "SELECT * FROM quotes;";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        List<Quote> list = new ArrayList<>();
        while (rs.next()) {
            Quote quote = new Quote(rs.getInt("id"), rs.getString("value"), rs.getString("author"));
            list.add(quote);
        }
        return list;    
    }
}
