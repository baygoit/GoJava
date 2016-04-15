package com.sandarovich.kickstarter.dao.impl;


import com.sandarovich.kickstarter.dao.CategoryDao;
import com.sandarovich.kickstarter.model.Category;
import com.sandarovich.kickstarter.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Category> getCategories() {
        return jdbcTemplate.query(SQL_GET_CATEGORIES, new BeanPropertyRowMapper<Category>(Category.class));
    }

    @Override
    public Category findById(int categoryId) {
        return (Category) jdbcTemplate.queryForObject(SQL_FIND_BY_CATEGORY, new Object[]{categoryId}, new BeanPropertyRowMapper(Category.class));
    }

    @Override
    public Category findByProject(Project project) {
        return (Category) jdbcTemplate.queryForObject(SQL_FIND_CATEGORY_BY_PROJECT, new Object[]{project.getId()}, new BeanPropertyRowMapper(Category.class));
    }

}
