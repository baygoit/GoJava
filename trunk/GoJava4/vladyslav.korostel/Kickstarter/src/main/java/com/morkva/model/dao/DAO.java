package com.morkva.model.dao;

import com.morkva.entities.Entity;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by koros on 06.06.2015.
 */
public interface DAO<T extends Entity> {
    T create(T object);
    void delete(T object);
    T getById(int id) throws SQLException;
    void update(T object);
    List<T> getAll() throws SQLException;
}
