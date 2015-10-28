package com.azuiev.dao;

import java.sql.Connection;

/**
 * Created by Administrator on 08.10.15.
 */
public interface DaoDB {
    Connection getConnection();
    void closeConnection();
}
