package com.morkva.model.dao.jdbc.postgres;

import com.morkva.entities.Quote;
import com.morkva.model.dao.DAO;
import com.morkva.model.dao.jdbc.DAOFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by koros on 06.06.2015.
 */
public class PostgresDaoFactory implements DAOFactory {

    private String user = "korostel";
    private String password = "rjhjcntkm";
    private String url = "jdbc:postgresql://korosteldbserver.cfu7bxpjmxyc.eu-west-1.rds.amazonaws.com:5432/KorostelDB";
    private String driver = "org.postgresql.Driver";

    public PostgresDaoFactory() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public DAO<Quote> getQuoteDao(Connection connection) {
        return new PostgreQuoteDAO(connection);
    }
}
