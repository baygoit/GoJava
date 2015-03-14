/**
 * 
 */
package com.ua.goit.alexkholmov.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author SASH
 *
 */
public interface DAOFactory {
    
    public Connection getConnection() throws SQLException;
    
    public CustomerDao getCustomerDao(Connection connection);
    
    public StudioDao getStudioDao(Connection connection);
    
    public ReserveDao getReserveDao(Connection connection);
}
