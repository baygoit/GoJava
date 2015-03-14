/**
 * 
 */
package com.ua.goit.alexkholmov.dao;

import java.sql.SQLException;
import java.util.List;

import com.ua.goit.alexkholmov.logic.Customer;
/**
 * @author SASH
 *
 */
public interface CustomerDao {
    
    public Customer create(Customer customer) throws SQLException;
    
    public Customer read(int id) throws SQLException;
    
    public void update(Customer customer) throws SQLException;
    
    public void delete(Customer customer) throws SQLException;
    
    public List<Customer> getAll() throws SQLException;
}
