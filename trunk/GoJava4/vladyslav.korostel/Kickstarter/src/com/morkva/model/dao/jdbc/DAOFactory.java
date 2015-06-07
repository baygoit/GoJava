package com.morkva.model.dao.jdbc;

import com.morkva.entities.Quote;
import com.morkva.model.dao.DAO;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by koros on 06.06.2015.
 */
public interface DAOFactory {

    Connection getConnection() throws SQLException;

    DAO<Quote> getQuoteDao(Connection connection);


}
