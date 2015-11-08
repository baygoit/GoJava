package nikfisher.kickstarter.dao;

import nikfisher.kickstarter.ConnectDB;
import nikfisher.kickstarter.model.Category;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoriesDAO implements Categories {

    Category category = null;
    Connection connection = ConnectDB.getDBConnection();

    private ResultSet getResultSet() throws SQLException {
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);
        return statement.executeQuery("SELECT * FROM categories");
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
        }
    }


    @Override
    public Category get(int index) {

        try {
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            ResultSet rs = statement.executeQuery("SELECT * FROM categories WHERE ID = " + index);
            while (rs.next()) {
                category = new Category(rs.getInt("id"), rs.getString("name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error query! (method get() ", e);
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
        }
        return size;
    }
}