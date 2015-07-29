package goit5.nikfisher.kickstarter.model;

import java.sql.DriverManager;
import java.sql.*;

public class Connections {

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Error loading JDBC driver! ", e);
        }
    }

    private  Connection connection ;

    public Connections(){

        try {
            connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/kickstarter.db");
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting in DB! ", e);
        }
    }
}
