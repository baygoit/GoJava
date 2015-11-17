package com.vopanasyuk.dao;

import java.sql.Connection;

/**
 * Created by Hunky on 08.10.15.
 */
public interface DaoDB {
    Connection getConnection();
    void closeConnection();
}