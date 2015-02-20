package ua.com.scread.kickstarter.storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import ua.com.scread.kickstarter.data.Category;

public class CategoriesDAO implements Categories {

    
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            Class.forName("org.postgresql.Driver");
            try {
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/Kickstarter", "postgres", "1234");                
            } catch (SQLException e) {
                e.printStackTrace();
            }
            statement = connection.createStatement();
            rs = statement.executeQuery("SELECT * FROM categories");
            while (rs.next()) {
                System.out.println(rs.getString(2));
            }
        } catch (Exception e) {
            throw new RuntimeException("SMTH HAPPENT", e);
        } finally {
            try {
                rs.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException("SMTH OLOLOLOLO", e);
            }
        }
    }

    @Override
    public void add(Category category) {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            Class.forName("org.postgresql.Driver");
            try {
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/Kickstarter", "postgres", "1234");                
            } catch (SQLException e) {
                e.printStackTrace();
            }
            statement = connection.createStatement();
            //statement.executeUpdate();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO categories (id, name) values (?, ?)");
            ps.setInt(1, category.getIndex());
            ps.setString(2, category.getName());
//            while (rs.next()) {
////                size++;
//            }
        } catch (Exception e) {
            throw new RuntimeException("SMTH HAPPENT", e);
        } finally {
            try {
                rs.close();
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
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/Kickstarter", "postgres", "1234");                
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
            throw new RuntimeException("SMTH HAPPENT", e);
        } finally {
            try {
                rs.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException("SMTH OLOLOLOLO", e);
            }
        }
    }

    @Override
    public List<Category> getCategories() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Category get(int index) {
        // TODO Auto-generated method stub
        return null;
    }
}
