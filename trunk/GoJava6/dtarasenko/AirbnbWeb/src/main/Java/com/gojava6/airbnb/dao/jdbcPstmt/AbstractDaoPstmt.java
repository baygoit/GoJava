package com.gojava6.airbnb.dao.jdbcPstmt;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;

public abstract class AbstractDaoPstmt {

//    private static final String sqlUrl = "jdbc:mysql://localhost:3306/airbnb";
//    private static final String sqlUser = "javauser";
//    private static final String sqlPassword = "javadude";

    Connection getDBConnection() {
        Connection connection = null;
        DataSource dataSource = null;

        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            dataSource = (DataSource) envContext.lookup("jdbc/ResAirbnb");
            connection = dataSource.getConnection();
//            connection = DriverManager.getConnection(sqlUrl, sqlUser, sqlPassword);
        }
        catch (NamingException e) {
            System.out.println(e.getMessage());
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
