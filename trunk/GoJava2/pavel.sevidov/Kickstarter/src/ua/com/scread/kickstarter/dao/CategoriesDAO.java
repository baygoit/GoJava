package ua.com.scread.kickstarter.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.com.scread.kickstarter.data.Category;
import ua.com.scread.kickstarter.storage.Categories;

public class CategoriesDAO implements Categories {

    @Override
    public void add(Category category) {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("org.postgresql.Driver");
            try {
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/kickstarter", "postgres", "1234");                
            } catch (SQLException e) {
                e.printStackTrace();
            }
            statement = connection.createStatement();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO categories (name) values (?)");
            ps.setString(1, category.getName());
            ps.execute();
        } catch (Exception e) {
            throw new RuntimeException("SMTH HAPPENT", e);
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException("SMTH OLOLOLOLO", e);
            }
        }
        
    }

    @Override
    public int size() {
        int size = 0;
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            Class.forName("org.postgresql.Driver");
            try {
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/kickstarter", "postgres", "1234");                
            } catch (SQLException e) {
                e.printStackTrace();
            }
            statement = connection.createStatement();
            rs = statement.executeQuery("SELECT * FROM categories");
            while (rs.next()) {
                size++;
            }
            return size;
        } catch (Exception e) {
        	throw new RuntimeException("Something happent while calculation Categories size!", e);
        } finally {
            try {
                rs.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
            	throw new RuntimeException("Something happent while closing connection!", e);
            }
        }
    }

    @Override
    public List<Category> getCategories() {
    	List<Category> result = new ArrayList<Category>();
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            Class.forName("org.postgresql.Driver");
            try {
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/kickstarter", "postgres", "1234");                
            } catch (SQLException e) {
                e.printStackTrace();
            }
            statement = connection.createStatement();
            rs = statement.executeQuery("SELECT * FROM categories");
            while (rs.next()) {
                result.add(new Category(rs.getString(2)));
            }
            return result;
        } catch (Exception e) {
        	throw new RuntimeException("Something happent while calculation Categories size!", e);
        } finally {
            try {
                rs.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
            	throw new RuntimeException("Something happent while closing connection!", e);
            }
        }
    }

    @Override
    public Category get(int index) {
    	Category category = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            Class.forName("org.postgresql.Driver");
            try {
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/kickstarter", "postgres", "1234");                
            } catch (SQLException e) {
                e.printStackTrace();
            }
            statement = connection.createStatement();
            rs = statement.executeQuery("SELECT * FROM categories");
            while (rs.next()) {
            	if (rs.getInt(1) == (index + 1)) {
            		category = new Category(rs.getString(2));
            		break;
            	} else {
            		// do nothing
            	}
            }
            return category;
        } catch (Exception e) {
        	throw new RuntimeException("Something happent while calculation Categories size!", e);
        } finally {
            try {
                rs.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
            	throw new RuntimeException("Something happent while closing connection!", e);
            }
        }
    }
}
