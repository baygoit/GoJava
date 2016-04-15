package com.vladik.dao.impl;

import com.vladik.dao.AbstractCategoryDao;
import com.vladik.model.Category;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class CategoryDaoMysqlImpl extends AbstractCategoryDao {
    private static final String INSERT_CATEGORY = "INSERT INTO Categories (name) VALUES (?)";
    private static final String DELETE_CATEGORY = "DELETE FROM Categories WHERE id = ?";
    private static final String SELECT_ALL_CATEGORIES = "SELECT id, name FROM Categories";
    private static final String COUNT_ALL_CATEGORIES = "SELECT count(*) FROM Categories";
    private static final String SELECT_CATEGORY_BY_ID = "SELECT id, name FROM Categories WHERE id = ?";

    @Override
    public void add(Category category) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT_CATEGORY);
            statement.setString(2, category.getName());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Category category) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_CATEGORY);
            statement.setInt(1, category.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Category> getAll() {
        return jdbcTemplate.query(SELECT_ALL_CATEGORIES, new BeanPropertyRowMapper<Category>(Category.class));
    }

    @Override
    public Category getCategoryById(int id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_CATEGORY_BY_ID)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (!rs.next()) {
//                throw new NoResultException("No category found");
            }
            Category category = new Category();
            category.setId(rs.getInt("id"));
            category.setName(rs.getString("name"));
            return category;
        } catch (SQLException | NullPointerException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public int getSize() {
        int amountOfCatrgories = 0;

        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(COUNT_ALL_CATEGORIES);
            while (resultSet.next()) {
                amountOfCatrgories = resultSet.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return amountOfCatrgories;
    }
}
