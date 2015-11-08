package com.azuiev.dao;

import com.azuiev.model.City;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Masta on 31.10.2015.
 */
public interface ModelDao {
    List<?> getAll() throws SQLException;
    Object getById(Long id) throws SQLException;
    void update(Object obj) throws SQLException;
    void add(Object obj) throws SQLException;
    void delete (Object obj) throws SQLException;
}
