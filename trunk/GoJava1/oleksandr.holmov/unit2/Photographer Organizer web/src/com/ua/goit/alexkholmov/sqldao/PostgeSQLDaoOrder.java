/**
 * 
 */
package com.ua.goit.alexkholmov.sqldao;

import java.sql.SQLException;
import java.util.List;

import com.ua.goit.alexkholmov.dao.OrderDao;
import com.ua.goit.alexkholmov.logic.Order;

/**
 * @author SASH
 *
 */
public class PostgeSQLDaoOrder implements OrderDao {

    /* (non-Javadoc)
     * @see com.ua.goit.alexkholmov.dao.OrderDao#create(com.ua.goit.alexkholmov.logic.Order)
     */
    @Override
    public Order create(Order order) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.ua.goit.alexkholmov.dao.OrderDao#read(int)
     */
    @Override
    public Order read(int id) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.ua.goit.alexkholmov.dao.OrderDao#update(com.ua.goit.alexkholmov.logic.Order)
     */
    @Override
    public void update(Order order) throws SQLException {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see com.ua.goit.alexkholmov.dao.OrderDao#delete(com.ua.goit.alexkholmov.logic.Order)
     */
    @Override
    public void delete(Order order) throws SQLException {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see com.ua.goit.alexkholmov.dao.OrderDao#getAll()
     */
    @Override
    public List<Order> getAll() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

}
