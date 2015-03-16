/**
 * 
 */
package com.ua.goit.alexkholmov.dao;

import java.sql.SQLException;
import java.util.List;

import com.ua.goit.alexkholmov.logic.Reserve;
import com.ua.goit.alexkholmov.logic.ReserveList;
/**
 * @author SASH
 *
 */
public interface ReserveDao {

    public void createFromList(ReserveList reserveList, int studioId) throws SQLException;
    
    public Reserve create(Reserve reserve, int studioId) throws SQLException;
    
    public Reserve read(int id) throws SQLException;
    
    public void update(Reserve reserve) throws SQLException;
    
    public void delete(Reserve reserve) throws SQLException;
    
    public List<Reserve> getAll(int studioId) throws SQLException;
}
