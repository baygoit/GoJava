package com.goit.file.SQL;

import java.sql.*;

/**
 * Created by roman on 16.03.16.
 */
public class CategoriesSQL {
    public void getCAtegoriesSQL() {

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/kickstarter", "root", "p")) {
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT cat_name FROM cat ");

            while(rs.next()) {
                String name = rs.getString("cat_name");
                System.out.println(name);
            }
            rs.next();
            System.out.println(rs.getString("cat_name"));
            return;

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
