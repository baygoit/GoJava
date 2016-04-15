package com.vladik.dao;

import java.util.List;

import com.vladik.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public abstract class AbstractCategoryDao {

    @Autowired
    public DataSource dataSource;
    @Autowired
    public JdbcTemplate jdbcTemplate;

    public abstract void add(Category element);

    public abstract void remove(Category element);

    public abstract List<Category> getAll();

    public abstract Category getCategoryById(int id);

    public abstract int getSize();
}
