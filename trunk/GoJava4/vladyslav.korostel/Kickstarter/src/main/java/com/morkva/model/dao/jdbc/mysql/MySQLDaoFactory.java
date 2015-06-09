package com.morkva.model.dao.jdbc.mysql;

import com.morkva.entities.Quote;
import com.morkva.model.dao.DAO;
import com.morkva.model.dao.PersistException;
import com.morkva.model.dao.jdbc.DAOFactory;
import com.morkva.model.dao.jdbc.DaoCreator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by koros on 06.06.2015.
 */
public class MySQLDaoFactory implements DAOFactory<Connection> {

    private String user = "vlad_korostel";
    private String password = "vlad_korostel";
    private String url = "jdbc:mysql://tortik.asuscomm.com:3306/vlad_korostel";
    private String driver = "com.mysql.jdbc.Driver";

    private Map<Class, DaoCreator> creators;

    public MySQLDaoFactory() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        creators = new HashMap<>();
        creators.put(Quote.class, new DaoCreator<Connection>() {
            @Override
            public DAO create(Connection connection) {
                return new MySQLQuoteDAO(connection);
            }
        });
    }

    @Override
    public Connection getContext() throws PersistException {
        Connection connection;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new PersistException(e);
        }
        return connection;
    }

    @Override
    public DAO getDao(Connection connection, Class dtoClass) throws PersistException {
        DaoCreator creator = creators.get(dtoClass);
        if (creator == null) {
            throw new PersistException("Dao object for " + dtoClass + " not found");
        }
        return creator.create(connection);
    }
}
