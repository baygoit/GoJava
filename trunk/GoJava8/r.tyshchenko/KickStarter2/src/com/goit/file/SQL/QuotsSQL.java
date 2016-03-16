package com.goit.file.SQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.Queue;


/**
 * Created by roman on 15.03.16.
 */
public class QuotsSQL {
    public void getQuotsSQL() {

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/kickstarter", "root", "p")) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT  quot_name FROM quot  order by rand() limit 1");
            rs.next();
            System.out.println(rs.getString("quot_name"));
            return;
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
