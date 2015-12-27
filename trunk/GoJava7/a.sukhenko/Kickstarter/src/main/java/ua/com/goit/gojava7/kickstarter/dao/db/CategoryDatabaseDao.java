package ua.com.goit.gojava7.kickstarter.dao.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.dao.DatabaseDao;
import ua.com.goit.gojava7.kickstarter.domain.Category;
@Repository
public class CategoryDatabaseDao extends DatabaseDao<Category>{
    private static final Logger logger = LogManager.getLogger(CategoryDatabaseDao.class); 
    private static String table  = "categories";
    private static String fields = "categoryId,categoryName";
    public CategoryDatabaseDao() {
        
    }
    
    public CategoryDatabaseDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    
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
                return readElement(resultSet);
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
    
    public void delete(int categoryId) {
        String sql = "DELETE FROM " + table + "  WHERE id=?";
        jdbcTemplate.update(sql, categoryId);
    }
    
    @Override
    public List<Category> getAll(){
        String query = "select " + fields + " from " + table;
        List<Category> results = jdbcTemplate.query(query, new CategoryMapper());
        
        return results;
    }
    
    private final class CategoryMapper implements RowMapper<Category>{

        @Override
        public Category mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Category category = new Category();
            category.setCategoryId(resultSet.getInt("categoryId"));
            category.setCategoryName(resultSet.getString("categoryName"));
            return category;
        }
    }
    
    
    @Override
    public Category get(int index) {
        logger.info("Empty function use");
        return null;
    }

    @Override
    public int size() {
        return getAll().size();
    }
    
    
}
