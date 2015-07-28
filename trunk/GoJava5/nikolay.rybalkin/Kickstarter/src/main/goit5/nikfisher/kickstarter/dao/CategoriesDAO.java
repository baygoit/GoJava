package goit5.nikfisher.kickstarter.dao;

import goit5.nikfisher.kickstarter.model.Category;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.List;

public class CategoriesDAO implements Categories {


    public static Connection conn;
    public static Statement statmt;
    public static ResultSet resSet;

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Error loading JDBC driver! ", e);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {




        Connection connection = null;
        try {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/kickstarter.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            statement.executeUpdate("drop table if exists categories");

            statement.executeUpdate("create table categories (id INT PRIMARY KEY UNIQUE, name TEXT UNIQUE)");
            statement.executeUpdate("insert into categories values(1, 'Game')");
            statement.executeUpdate("insert into categories values(2, 'Video')");
            statement.executeUpdate("insert into categories values(3, 'Music')");

            ResultSet rs = statement.executeQuery("select * from categories");
            while(rs.next())
            {
                System.out.println("name = " + rs.getString("name"));
                System.out.println("id = " + rs.getInt("id"));
            }

        } catch (SQLException e) {
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e);
            }
        }
    }


    @Override
    public void add(Category category) {

    }

    @Override
    public List<String> getCategories() {
        return null;
    }

    @Override
    public Category get(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }



}