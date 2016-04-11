package com.sandarovich.kickstarter.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sandarovich.kickstarter.dao.CategoryDao;
import com.sandarovich.kickstarter.dao.exception.DaoException;
import com.sandarovich.kickstarter.dao.exception.NoResultException;
import com.sandarovich.kickstarter.model.Category;
import com.sandarovich.kickstarter.model.Project;

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

	@Autowired
	private JdbcTemplate jdbcTemplate;

    @Override
    public List<Category> getCategories() {
		return jdbcTemplate.query(SQL_GET_CATEGORIES, new BeanPropertyRowMapper<Category>(Category.class));
	}

    @Override
    public Category findCategoryById(int categoryId) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_BY_CATEGORY)) {
            statement.setInt(1, categoryId);
            ResultSet rs = statement.executeQuery();
			if (!rs.next()) {
				throw new NoResultException("No category found");
			}

			Category category = new Category();
			category.setId(categoryId);
			category.setName(rs.getString("name"));

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
