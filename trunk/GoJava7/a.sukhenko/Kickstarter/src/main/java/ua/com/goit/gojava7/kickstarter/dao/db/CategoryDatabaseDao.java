package ua.com.goit.gojava7.kickstarter.dao.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.stereotype.Component;

import ua.com.goit.gojava7.kickstarter.dao.DatabaseDao;
import ua.com.goit.gojava7.kickstarter.domain.Category;
@Component
public class CategoryDatabaseDao extends DatabaseDao<Category>{

    private static String table  = "categories";
    private static String fields = "categoryId,categoryName";
    public CategoryDatabaseDao() {
        // TODO Auto-generated constructor stub
    }
    
    public CategoryDatabaseDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    
    @Override
    protected Category readElement(ResultSet resultSet) throws SQLException {
        Category category = new Category();
        category.setCategoryId(resultSet.getInt("categoryId"));
        category.setCategoryName(resultSet.getString("categoryName"));
        return category;
    }

    public Category getCategoryById(int projectCategoryId) {
        String query = "SELECT " + fields + " FROM " + table + " WHERE categoryId = " + projectCategoryId;
        try (PreparedStatement ps = dataSource.getConnection().prepareStatement(query); ResultSet resultSet = ps.executeQuery()) {
            if (resultSet.next()) {
                Category category = new Category();
                category.setCategoryId(resultSet.getInt("categoryId"));
                category.setCategoryName(resultSet.getString("categoryName"));
                return category;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new NoSuchElementException();
    }

    @Override
    public void add(Category element) {

    }
    @Override
    public Connection getConnection() throws SQLException{
        return dataSource.getConnection();
    }
    @Override
    public List<Category> getAll() {
        List<Category> data = new ArrayList<>();
        String query = "select " + fields + " from " + table;
        try (PreparedStatement ps = getConnection().prepareStatement(query); ResultSet resultSet = ps.executeQuery()) {
            while (resultSet.next()) {
                data.add(readElement(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }
    @Override
    public Category get(int index) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public Category getByNumber(int number) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public void setAll(List<Category> data) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }
    
    
}
