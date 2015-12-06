package dao;

import model.AbstractEntity;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by root on 04.11.15.
 */
public interface AbstractDAO<K,T extends AbstractEntity> {
    List<T> findAll() throws SQLException;
    T findEntityById(K id);
    boolean delete(K id);
    boolean delete(T entity);
    AbstractEntity create(T entity);
    T update(T entity);
}
