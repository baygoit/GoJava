package com.gojava6.differenttasks.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Autor Andrey Chaykin
 * @Since 12.11.2015
 */
public class MySqlDaoFactory implements DAOFactory {

    private String user = "root";
    private String password = "root";
    private String url = "jdbc:mysql://localhost:3306/daotalk";
    private String driver = "com.mysql.jdbc.Driver";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public GroupDAO getGroupDAO(Connection connection) throws SQLException {
        return new MySqlGroupDao(connection);
    }

    public StudentDAO getStudentDAO(Connection connection) throws SQLException {
        return null;
    }

    public MySqlDaoFactory() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
