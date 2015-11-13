package dao;

import model.Entity;

import java.sql.SQLException;
import java.util.Set;

/**
 * Created by root on 04.11.15.
 */
public interface AbstractDAO<K,T extends Entity> {
    Set<T> findAll() throws SQLException;
    T findEntityById(K id);
    boolean delete(K id);
    boolean delete(T entity);
    boolean create(T entity);
    T update(T entity);
}
