/**
 * 
 */
package com.ua.goit.alexkholmov.dao;

import java.sql.SQLException;
import java.util.List;

import com.ua.goit.alexkholmov.logic.Order;

/**
 * @author SASH
 *
 */
public interface OrderDao {

    public Order create(Order order) throws SQLException;
    
    public Order read(int id) throws SQLException;
    
    public void update(Order order) throws SQLException;
    
    public void delete(Order order) throws SQLException;
    
    public List<Order> getAll() throws SQLException;
}
