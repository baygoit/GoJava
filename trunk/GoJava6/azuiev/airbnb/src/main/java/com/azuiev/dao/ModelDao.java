package com.azuiev.dao;

import com.azuiev.model.City;
import com.azuiev.model.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Masta on 31.10.2015.
 */
public interface ModelDao<T> {
    List<T> getAll() throws SQLException;
    Object getById(Long id) throws SQLException;
    void update(T obj) throws SQLException;
    void add(T obj) throws SQLException;
    void delete (T obj) throws SQLException;
}
