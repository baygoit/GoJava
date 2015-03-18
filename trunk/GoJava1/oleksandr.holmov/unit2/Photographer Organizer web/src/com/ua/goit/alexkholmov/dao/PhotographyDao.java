/**
 * 
 */
package com.ua.goit.alexkholmov.dao;

import java.sql.SQLException;
import java.util.List;

import com.ua.goit.alexkholmov.logic.Photography;

/**
 * @author SASH
 *
 */
public interface PhotographyDao {
    
    public Photography create(Photography photography) throws SQLException;
    
    public Photography read(int id) throws SQLException;
    
    public void update(Photography photography) throws SQLException;
    
    public void delete(Photography photography) throws SQLException;
    
    public List<Photography> getAll() throws SQLException;
}
