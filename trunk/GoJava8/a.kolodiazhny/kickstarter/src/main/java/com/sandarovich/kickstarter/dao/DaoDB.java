package com.sandarovich.kickstarter.dao;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DaoDB {
    private DataSource dataSource;

    public DaoDB() {
        initDataSource();
    }

    public void initDataSource() {
        try {
            Class.forName("org.postgresql.Driver");
            InitialContext initContext = new InitialContext();
            dataSource = (DataSource) initContext.lookup("java:comp/env/jdbc/kickstarter");
        } catch (ClassNotFoundException | NamingException e) {
            throw new DaoException(e);
        }
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
