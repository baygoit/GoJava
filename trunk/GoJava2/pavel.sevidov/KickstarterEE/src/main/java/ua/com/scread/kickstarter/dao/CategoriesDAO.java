package ua.com.scread.kickstarter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.com.scread.kickstarter.data.Category;
import ua.com.scread.kickstarter.storage.Categories;

public class CategoriesDAO implements Categories {

    private Connection connection;

    public CategoriesDAO(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public void add(final Category category) {
        try {
            PreparedStatement statement = connection.prepareStatement("insert into categories (name) values (?)");
            statement.setString(2, category.getName());
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Something happend while adding new category", e);
        }
    }

    @Override
    public List<Category> getCategories() {
        try {
            Statement statement = connection.createStatement(); 
            List<Category> result = new ArrayList<Category>();

            ResultSet rs = statement.executeQuery("select * from categories");
            while (rs.next()) {
                result.add(new Category(rs.getInt("id_cat"), rs.getString("name")));
            }   
            
            return result;
        } catch (SQLException e) {
            throw new RuntimeException("Something happend while getting all categories", e);
        }
    }

    @Override
    public Category get(final int id) {
        try {
            Statement statement = connection.createStatement(); 

            ResultSet rs = statement.executeQuery("select * from categories where id_cat = " + id);
            while (rs.next()) {
                return new Category(rs.getInt("id_cat"), rs.getString("name"));
            }   
            
            throw new RuntimeException("Not found category by id = " + id);
        } catch (SQLException e) {
            throw new RuntimeException("Something happend while getting gategory by id", e);
        }
    }

    @Override
    public int size() {
        try {
            Statement statement = connection.createStatement(); 

            ResultSet rs = statement.executeQuery("select count(*) from categories");
            return rs.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException("Something happend while calculationg categories size", e);
        }
    }

}
