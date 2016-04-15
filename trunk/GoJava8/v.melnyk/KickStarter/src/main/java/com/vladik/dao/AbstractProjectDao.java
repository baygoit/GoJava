package com.vladik.dao;

import com.vladik.model.Category;
import com.vladik.model.Payment;
import com.vladik.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public abstract class AbstractProjectDao {

    @Autowired
    public DataSource dataSource;
    @Autowired
    public JdbcTemplate jdbcTemplate;

    public abstract void add(Project element);

    public abstract void remove(Project element);

    public abstract List<Project> getAll();

    public abstract int getSize();

    public abstract List<Project> getProjectsFromCategory(Category category);

    public abstract Project getProjectById(int id);

    public abstract void invest(Payment payment, int projectId);

}
