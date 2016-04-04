package ua.dborisenko.kickstarter.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public abstract class DaoSql {
    private DataSource dataSource;

    public DaoSql() {
        initDataSource();
    }
    
    void setDataSource(DataSource ds) {
        dataSource = ds;
    }
    
    void initDataSource() {
        try {
            InitialContext initContext= new InitialContext();
            dataSource = (DataSource) initContext.lookup("java:comp/env/jdbc/dataSource");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    protected void closeStatement(Statement statement) throws SQLException {
        if (statement != null && !(statement.isClosed())) {
            statement.close();
        }
    }
}
