package ua.com.goit.gojava7.salivon.dao.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBUtil {

    private String URL_DB = "jdbc:mysql://localhost:3306/kickstarter";
    private String USER_DB = "root";
    private String PASSWORD_DB = "";
    private Connection connection;
    private Statement statement;
    private ResultSet result;

    public void setConnectionParameters(String url, String user, String password) {
        URL_DB = url;
        USER_DB = user;
        PASSWORD_DB = password;
    }

    public void openConnection() {
        
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
            connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
//            System.out.println("Connected database successfully...");
            statement = connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            result = statement.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int executeUpdate(String query) {
        int rowCount = 0;
        openConnection();
        try {
            rowCount = statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowCount;
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
