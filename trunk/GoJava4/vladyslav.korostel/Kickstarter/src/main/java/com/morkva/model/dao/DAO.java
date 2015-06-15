package com.morkva.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by koros on 06.06.2015.
 */
public interface DAO<T extends Identified<PK>, PK extends Serializable> {
    T create() throws PersistException;
    T persist(T object) throws PersistException;
    void delete(T object) throws PersistException;
    T getByPK(PK id) throws PersistException;
    void update(T object) throws PersistException;
    List<T> getAll() throws PersistException;
    List<T> getByCustomQuery(String sql) throws SQLException, PersistException;
}
