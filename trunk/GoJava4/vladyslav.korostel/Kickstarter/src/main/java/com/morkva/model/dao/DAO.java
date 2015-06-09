package com.morkva.model.dao;

import com.morkva.entities.Entity;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by koros on 06.06.2015.
 */
public interface DAO<T extends Entity, PK extends Serializable> {
    T create(T object) throws PersistException;
    void delete(T object) throws PersistException;
    T getByPK(int id) throws PersistException;
    void update(T object) throws PersistException;
    List<T> getAll() throws PersistException;
    List<T> getByCustomQuery(String sql) throws SQLException, PersistException;
}
