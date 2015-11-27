package com.gojava6.differenttasks.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Autor Andrey Chaykin
 * @Since 12.11.2015
 */
public interface DAOFactory {

    Connection getConnection() throws SQLException;

    GroupDAO getGroupDAO(Connection connection) throws SQLException;

    StudentDAO getStudentDAO(Connection connection) throws SQLException;
}
