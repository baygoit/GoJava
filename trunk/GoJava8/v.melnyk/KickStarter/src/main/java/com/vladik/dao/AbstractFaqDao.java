package com.vladik.dao;

import java.util.List;

import com.vladik.model.Faq;
import com.vladik.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public abstract class AbstractFaqDao {

    @Autowired
    public DataSource dataSource;
    @Autowired
    public JdbcTemplate jdbcTemplate;

    public abstract void add(Faq element);

    public abstract void remove(Faq element);

    public abstract List<Faq> getAll();

    public abstract int getSize();

    public abstract String getProjectFaqs(Project project);


}
