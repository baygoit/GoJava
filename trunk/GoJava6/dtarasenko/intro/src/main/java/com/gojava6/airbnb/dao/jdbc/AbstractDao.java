package com.gojava6.airbnb.dao.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDao {

    private static final String sqlUrl = "jdbc:mysql://localhost:3306/airbnb";
    private static final String sqlUser = "javauser";
    private static final String sqlPassword = "javadude";

    void updateDatabase(String sqlCode) {
        try {
            Connection conn = DriverManager.getConnection(sqlUrl, sqlUser, sqlPassword);
            Statement stmt = null;
            try {
                stmt = conn.createStatement();
                stmt.executeUpdate(sqlCode);
            } catch (SQLException ex) {
                System.out.println("SQL query is no correct");
            } finally {
                try {
                    if (stmt != null) {
                        stmt.close();
                    }
                } finally {
                    conn.close();
                }
            }
        } catch (SQLException ex) {
            System.out.println("No connection");
        }
    }

    List<Object> readDatabase(String sqlCode) {
        List<Object> objectList = new ArrayList<Object>();

        try {
            Connection conn = DriverManager.getConnection(sqlUrl, sqlUser, sqlPassword);
            Statement stmt = null;
            ResultSet rs = null;

            try {
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sqlCode);

                while (rs.next()) {
                    Object object = createObject(rs);
                    objectList.add(object);
                }
            } catch (SQLException ex) {
                System.out.println("SQL query is no correct");
            } finally {
                try {
                    if (rs != null) {
                        rs.close();
                    }
                } finally {
                    try {
                        if (stmt != null) {
                            stmt.close();
                        }
                    } finally {
                        conn.close();
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("No connection");
        }

        return objectList;
    }

    Object createObject(ResultSet resultSet) throws SQLException {
        return null;
    }
}
