package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
//import java.sql.DriverManager;
//import java.sql.SQLException;

/**
 * @autor A_Nakonechnyi
 * @date 21.10.2015.
 */
public abstract class AbstractDAO {
     void updateDB(String sqlQuery) {
        Connection connection = null;
        Statement sttmnt = null;

        try {
            connection = getDBConnection();
            sttmnt = connection.createStatement();
            sttmnt.executeUpdate(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (sttmnt != null) {
                    sttmnt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    List<Object> readDB (String sqlQuery){
        List<Object> getList = new ArrayList<>();
        Connection conn = null;
        Statement sttmnt = null;
        ResultSet resultSet = null;

        try {
            conn = getDBConnection();
            sttmnt = conn.createStatement();
            resultSet = sttmnt.executeQuery(sqlQuery);

            while (resultSet.next()) {
            getList.add(readObj(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (sttmnt != null) {
                    sttmnt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return getList;
    }

    private Connection getDBConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver?");
            e.printStackTrace();
        }
        Connection connection = null;
        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/airbnb", "root", "polipoli");
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
        }

        return connection;
    }
    abstract Object readObj (ResultSet resultSet) throws SQLException;
}
