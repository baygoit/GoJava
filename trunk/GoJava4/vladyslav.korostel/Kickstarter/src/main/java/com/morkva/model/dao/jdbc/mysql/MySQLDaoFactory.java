package com.morkva.model.dao.jdbc.mysql;

import com.morkva.entities.Quote;
import com.morkva.model.dao.DAO;
import com.morkva.model.dao.jdbc.DAOFactory;
import com.morkva.model.dao.jdbc.postgres.PostgreQuoteDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by koros on 06.06.2015.
 */
public class MySQLDaoFactory implements DAOFactory {

    private String user = "cakehost_goit";
    private String password = "975w736h";
    private String url = "jdbc:mysql://cakehost.mysql.ukraine.com.ua:3306/cakehost_goit";
    private String driver = "com.mysql.jdbc.Driver";

    public MySQLDaoFactory() {
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
