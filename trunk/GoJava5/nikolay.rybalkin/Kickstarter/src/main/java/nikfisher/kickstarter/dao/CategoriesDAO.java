package nikfisher.kickstarter.dao;

import nikfisher.kickstarter.model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriesDAO implements Categories {

    //TODO duplicated method
    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Error loading JDBC driver! ", e);
        }
    }

    Connection connection = null;
    Category category = null;

    //TODO duplicated method
    private ResultSet getResultSet() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/kickstarter.db");
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);
        return statement.executeQuery("SELECT * FROM categories");
    }

    public static void main(String[] args) {
        CategoriesDAO categoriesDAO = new CategoriesDAO();
        Category category = categoriesDAO.get(1);
        System.out.println(category);
        System.out.println(categoriesDAO.size());
        System.out.println(categoriesDAO.getCategories());
    }

    @Override
    public void add(Category category) {

    }

    @Override
    public List<String> getCategories() {

        List<String> result = new ArrayList<>();
        try {
            ResultSet rs = getResultSet();

            while (rs.next()) {
                result.add(rs.getInt("id") + ") " + rs.getString("name"));
            }

            return result;

        } catch (SQLException e) {
            throw new RuntimeException("Error query! (method getCategories()", e);
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }


    @Override
    public Category get(int index) {

        try {
            ResultSet rs = getResultSet();

            while (rs.next()) {
                category = new Category(rs.getInt("id"), rs.getString("name"));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error query! (method get() ", e);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return category;
    }

    @Override
    public int size() {

        int size = 0;

        try {
            ResultSet rs = getResultSet();

            while (rs.next()) {
                size++;
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error query! (method size()) ", e);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return size;
    }


}