package goit5.nikfisher.kickstarter.dao;

import goit5.nikfisher.kickstarter.model.Category;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.List;

public class CategoriesDAO implements Categories {

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
            connection = DriverManager.getConnection("jdbc:sqlite:./src/main/resources/kickstarters.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            ResultSet rs = statement.executeQuery("select * from Categories");

//            while (rs.next()) {
//                // read the result set
//                System.out.println("name = " + rs.getString("name"));
//                System.out.println("id = " + rs.getInt("id"));
//            }

            System.out.println("Test connecting good!");
        } catch (SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
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