/**
 * 
 */
package com.ua.goit.alexkholmov.dao;

import java.sql.SQLException;
import java.util.List;

import com.ua.goit.alexkholmov.logic.FotoStudio;
/**
 * @author SASH
 *
 */
public interface StudioDao {

    public FotoStudio create(FotoStudio studio) throws SQLException;
    
    public FotoStudio read(int id) throws SQLException;
    
    public void update(FotoStudio studio) throws SQLException;
    
    public void delete(FotoStudio studio) throws SQLException;
    
    public List<FotoStudio> getAll() throws SQLException;
}
