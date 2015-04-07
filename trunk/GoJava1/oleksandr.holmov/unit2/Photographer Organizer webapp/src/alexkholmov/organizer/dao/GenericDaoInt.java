/**
 * 
 */
package alexkholmov.organizer.dao;

import java.io.Serializable;
import java.util.List;

import alexkholmov.organizer.exceptions.DaoException;

/**
 * @author SASH
 *
 */
public interface GenericDaoInt<T, PK extends Serializable> {

    public void save(T object) throws DaoException;
    
    public PK create(T object) throws DaoException;
    
    public T getObjectById(PK id) throws DaoException;
    
    public void update(T object) throws DaoException;
    
    public void delete(T object) throws DaoException;
    
    public List<T> getAll() throws DaoException;
}
