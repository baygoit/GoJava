/**
 * 
 */
package com.ua.goit.alexkholmov.sqldao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ua.goit.alexkholmov.dao.CustomerDao;
import com.ua.goit.alexkholmov.logic.Customer;

/**
 * @author SASH
 *
 */
public class PostgeSQLDaoCustomer implements CustomerDao {

    private final Connection connection;
    
    public PostgeSQLDaoCustomer(Connection connection) {
        this.connection = connection;
    }
    
    /* (non-Javadoc)
     * @see com.ua.goit.alexkholmov.dao.CustomerDao#create()
     */
    @Override
    public Customer create(Customer customer) throws SQLException {
        String sql = "INSERT INTO customer " 
                    + "(cust_name, cust_address, cust_phone, cust_info) "
                    + "VALUES (?, ?, ?, ?) RETURNING cust_id;";
        PreparedStatement pStatement = connection.prepareStatement(sql);
        pStatement.setString(1, customer.getName());
        pStatement.setString(2, customer.getAddress());
        pStatement.setString(3, customer.getPhone());
        pStatement.setString(4, customer.getAdditionalInfo());
        ResultSet rs = pStatement.executeQuery();
        rs.next();
        customer.setCustomerId(rs.getInt("cust_id"));
        return customer;
    }

    /* (non-Javadoc)
     * @see com.ua.goit.alexkholmov.dao.CustomerDao#read(int)
     */
    @Override
    public Customer read(int id) throws SQLException {
        String sql = "SELECT cust_id, cust_name, cust_address, cust_phone, cust_info "
                + "FROM customer " + "WHERE cust_id=?;";
        PreparedStatement pStatement = connection.prepareStatement(sql);
        pStatement.setInt(1, id);
        ResultSet rs = pStatement.executeQuery();
        rs.next();
        Customer customer = new Customer(rs);
        return customer;
    }

    /* (non-Javadoc)
     * @see com.ua.goit.alexkholmov.dao.CustomerDao#update(com.ua.goit.alexkholmov.logic.Customer)
     */
    @Override
    public void update(Customer customer) throws SQLException {
        String sql = "UPDATE customer " +
                     "SET cust_name=?, cust_address=?, cust_phone=?, cust_info=? " +
                     "WHERE cust_id=?;";
        PreparedStatement pStatement = connection.prepareStatement(sql);
        pStatement.setString(1, customer.getName());
        pStatement.setString(2, customer.getAddress());
        pStatement.setString(3, customer.getPhone());
        pStatement.setString(4, customer.getAdditionalInfo());
        pStatement.setInt(5, customer.getCustomerId());
        pStatement.execute();
    }

    /* (non-Javadoc)
     * @see com.ua.goit.alexkholmov.dao.CustomerDao#delete(com.ua.goit.alexkholmov.logic.Customer)
     */
    @Override
    public void delete(Customer customer) throws SQLException {
        String sql = "DELETE FROM customer WHERE cust_id = ?";
        PreparedStatement pStatement = connection.prepareStatement(sql);
        pStatement.setInt(1, customer.getCustomerId());
        pStatement.execute();
    }

    /* (non-Javadoc)
     * @see com.ua.goit.alexkholmov.dao.CustomerDao#getAll()
     */
    @Override
    public List<Customer> getAll() throws SQLException {
        String sql = "SELECT cust_id, cust_name, cust_address, cust_phone, cust_info FROM customer;";
        List<Customer> list = new ArrayList<Customer>();
        PreparedStatement pStatement = connection.prepareStatement(sql);
        ResultSet rs = pStatement.executeQuery();
        while (rs.next()) {
            Customer customer = new Customer(rs);
            list.add(customer);
        }
        return list;
    }

}
