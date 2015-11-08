package com.vopanasyuk.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Hunky on 31.10.2015.
 */
public interface DaoModel {
    List<?> getAll() throws SQLException;
    Object getById(Integer i) throws SQLException;
    void update(Object obj);
    void insert(Object obj);
    void delete (Object obj);
}