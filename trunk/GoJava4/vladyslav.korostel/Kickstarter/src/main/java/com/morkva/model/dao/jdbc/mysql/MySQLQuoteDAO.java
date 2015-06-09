package com.morkva.model.dao.jdbc.mysql;

import com.morkva.entities.Quote;
import com.morkva.model.dao.DAO;
import com.morkva.model.dao.PersistException;
import com.morkva.model.dao.jdbc.AbstractJDBCDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by koros on 06.06.2015.
 */
public class MySQLQuoteDAO extends AbstractJDBCDao<Quote, Integer>{


    public MySQLQuoteDAO(Connection connection) {
        super(connection);
    }

    @Override
    public String getSelectQuery() {
        return "SELECT `id`, `value`, `author` FROM quotes";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE quotes SET `value`=?, author=? WHERE id=?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM quotes WHERE id=?;";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO quotes (`value`, author) VALUES (?, ?);";
    }

    @Override
    protected List<Quote> parseResultSet(ResultSet resultSet) throws PersistException {
        LinkedList<Quote> result = new LinkedList<>();
        try {
            while (resultSet.next()) {
                Quote quote = new Quote(
                        resultSet.getInt("id"),
                        resultSet.getString("value"),
                        resultSet.getString("author"));
                result.add(quote);
            }
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return result;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Quote object) throws PersistException {
        try {
            statement.setString(1, object.getValue());
            statement.setString(2, object.getAuthor());
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Quote object) throws PersistException {
        try {
            statement.setString(1, object.getValue());
            statement.setString(2, object.getAuthor());
            statement.setInt(3, object.getId());
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }
}
