package ua.com.goit.gojava7.kickstarter.dao.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.stereotype.Component;

import ua.com.goit.gojava7.kickstarter.dao.DatabaseDao;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.servlet.MainServlet;
@Component
public class CategoryDatabaseDao extends DatabaseDao<Category>{
    private static final Logger logger = LogManager.getLogger(CategoryDatabaseDao.class); 
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
            logger.log(Level.ERROR, e);
        }
        throw new NoSuchElementException();
    }

    @Override
    public void add(Category element) {
        logger.info("Empty function use");
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
            logger.log(Level.ERROR, e);
        }
        return data;
    }
    @Override
    public Category get(int index) {
        logger.info("Empty function use");
        return null;
    }
    @Override
    public Category getByNumber(int number) {
        logger.info("Empty function use");
        return null;
    }
    @Override
    public void setAll(List<Category> data) {
        logger.info("Empty function use");
        
    }
    @Override
    public int size() {
        return getAll().size();
    }
    
    
}
