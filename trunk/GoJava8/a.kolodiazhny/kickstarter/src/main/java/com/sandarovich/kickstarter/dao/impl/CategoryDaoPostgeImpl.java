package com.sandarovich.kickstarter.dao.impl;


import com.sandarovich.kickstarter.dao.CategoryDao;
import com.sandarovich.kickstarter.dao.exception.DaoException;
import com.sandarovich.kickstarter.dao.exception.NoResultException;
import com.sandarovich.kickstarter.model.Category;
import com.sandarovich.kickstarter.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryDaoPostgeImpl implements CategoryDao {

    private static final String SQL_GET_CATEGORIES = "SELECT id, name FROM category";
    private static final String SQL_FIND_BY_CATEGORY = "SELECT id, name FROM category WHERE id=?";
    private static final String SQL_FIND_CATEGORY_BY_PROJECT =
        "SELECT id, name " +
            "FROM category " +
            "WHERE id = ( " +
            "SELECT categoryid " +
            "FROM project " +
            "WHERE id=? " +
            "GROUP by categoryid " +
            "LIMIT(1));";

    @Autowired
    private DataSource dataSource;

    @Override
    public List<Category> getCategories() {
        List<Category> result = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_CATEGORIES)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                result.add(category);
            }
            rs.close();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return result;
    }

    @Override
    public Category findCategoryById(int categoryId) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_BY_CATEGORY)) {
            statement.setInt(1, categoryId);
            ResultSet rs = statement.executeQuery();
            Category category;
            if (rs.next()) {
                String name = rs.getString("name");
                rs.close();
                category = new Category();
                category.setId(categoryId);
                category.setName(name);
            } else {
                throw new NoResultException("No category found");
            }
            return category;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Category findCategoryByProject(Project project) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_CATEGORY_BY_PROJECT)) {
            statement.setInt(1, project.getId());
            ResultSet rs = statement.executeQuery();
            Category category;
            if (rs.next()) {
                String name = rs.getString("name");
                int id = rs.getInt("id");
                rs.close();
                category = new Category();
                category.setId(id);
                category.setName(name);
            } else {
                throw new NoResultException("No category found");
            }
            return category;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }



}
