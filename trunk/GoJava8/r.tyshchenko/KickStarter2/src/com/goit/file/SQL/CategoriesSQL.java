package com.goit.file.SQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by roman on 16.03.16.
 */
public class CategoriesSQL {
    List CatSQL = new ArrayList<>();
    public void getCAtegoriesSQL() {

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/kickstarter", "root", "p")) {
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT cat_name FROM cat ");
            //List CatSQL = new ArrayList<>();
            while(rs.next()) {
                String name = rs.getString("cat_name");
                CatSQL.add(name);
            }
            System.out.println(CatSQL);
            rs.next();
            System.out.println(rs.getString("cat_name"));
            return;
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public Object getChoosCatSQL (int a ) {
        return  CatSQL.get(a);
    }
}

