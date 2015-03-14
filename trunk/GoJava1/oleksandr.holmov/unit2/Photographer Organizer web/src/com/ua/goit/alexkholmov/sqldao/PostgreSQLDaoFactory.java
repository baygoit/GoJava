/**
 * 
 */
package com.ua.goit.alexkholmov.sqldao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.ua.goit.alexkholmov.dao.CustomerDao;
import com.ua.goit.alexkholmov.dao.DAOFactory;
import com.ua.goit.alexkholmov.dao.ReserveDao;
import com.ua.goit.alexkholmov.dao.StudioDao;

/**
 * @author SASH
 *
 */
public class PostgreSQLDaoFactory implements DAOFactory{

    private String lookup = "java:/comp/env/jdbc/postgres";
    
    @Override
    public Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            Context context = new InitialContext();
            DataSource source = (DataSource) context.lookup(lookup);
            connection = source.getConnection();
        } catch (NamingException e) {
            e.printStackTrace();
        } 
        return connection;
    }

    @Override
    public CustomerDao getCustomerDao(Connection connection) {
        return new PostgeSQLDaoCustomer(connection);
    }

    @Override
    public StudioDao getStudioDao(Connection connection) {
        return new PostgeSQLDaoStudio(connection);
    }

    @Override
    public ReserveDao getReserveDao(Connection connection) {
        return new PostgeSQLDaoReserve(connection);
    }
    
}
