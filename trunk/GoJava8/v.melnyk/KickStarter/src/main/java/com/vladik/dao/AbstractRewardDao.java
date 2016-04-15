package com.vladik.dao;

import com.mysql.fabric.xmlrpc.base.Data;
import com.vladik.model.Project;
import com.vladik.model.Reward;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public abstract class AbstractRewardDao {

    @Autowired
    public DataSource dataSource;
    @Autowired
    public JdbcTemplate jdbcTemplate;

    public abstract List<Reward> getRewardsForProject(Project project);
}
