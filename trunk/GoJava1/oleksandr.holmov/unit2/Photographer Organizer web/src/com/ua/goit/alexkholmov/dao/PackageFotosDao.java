/**
 * 
 */
package com.ua.goit.alexkholmov.dao;

import java.sql.SQLException;
import java.util.List;

import com.ua.goit.alexkholmov.logic.PackageFotos;
/**
 * @author SASH
 *
 */
public interface PackageFotosDao {

    public PackageFotos create(PackageFotos fotos, int orderId) throws SQLException;
    
    public PackageFotos read(int id) throws SQLException;
    
    public void update(PackageFotos fotos) throws SQLException;
    
    public void delete(PackageFotos fotos) throws SQLException;
    
    public List<PackageFotos> getAll(int orderId) throws SQLException;
}
