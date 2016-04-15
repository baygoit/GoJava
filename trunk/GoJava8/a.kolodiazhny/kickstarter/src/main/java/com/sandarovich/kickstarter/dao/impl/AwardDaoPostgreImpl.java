package com.sandarovich.kickstarter.dao.impl;

import com.sandarovich.kickstarter.dao.AwardDao;
import com.sandarovich.kickstarter.model.Award;
import com.sandarovich.kickstarter.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AwardDaoPostgreImpl implements AwardDao {

    private static final String SQL_FIND_AWARD_BY_PROJECT =
            "SELECT name, amount, description " +
                    "FROM award " +
                    "where projectid=?";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Award> getByProject(Project project) {
        return jdbcTemplate.query(SQL_FIND_AWARD_BY_PROJECT, new Object[]{project.getId()}, new BeanPropertyRowMapper<Award>(Award.class));
    }
}
