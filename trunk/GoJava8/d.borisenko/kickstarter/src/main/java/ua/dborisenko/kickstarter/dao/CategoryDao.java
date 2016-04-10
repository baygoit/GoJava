package ua.dborisenko.kickstarter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.dborisenko.kickstarter.domain.Category;

@Repository
public class CategoryDao {

    private static final String QUERY_GET_CATEGORY_BY_PROJECT_ID = "SELECT c.id, c.name FROM categories c INNER JOIN projects p ON (p.category_id = c.id) WHERE p.id = ?";
    private static final String QUERY_GET_CATEGORY_BY_ID = "SELECT id, name FROM categories WHERE id = ?";
    private static final String QUERY_GET_CATEGORIES = "SELECT id, name FROM categories ORDER BY name";
    @Autowired
    private DataSource dataSource;
  
    public Category getCategoryById(int id) {
        try (Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(QUERY_GET_CATEGORY_BY_ID)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (!rs.next()) {
                throw new NoResultException("No category found.");
            }
            Category category = new Category();
            category.setId(rs.getInt("id"));
            category.setName(rs.getString("name"));
            return category;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public List<Category> getCategories() {
        try (Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(QUERY_GET_CATEGORIES)) {
            ResultSet rs = statement.executeQuery();
            List<Category> categories = new ArrayList<>();
            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                categories.add(category);
            }
            return categories;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public Category getCategoryByProjectId(int id) {
        try (Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(QUERY_GET_CATEGORY_BY_PROJECT_ID)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (!rs.next()) {
                throw new NoResultException("No category found.");
            }
            Category category = new Category();
            category.setId(rs.getInt("c.id"));
            category.setName(rs.getString("c.name"));
            return category;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

}
