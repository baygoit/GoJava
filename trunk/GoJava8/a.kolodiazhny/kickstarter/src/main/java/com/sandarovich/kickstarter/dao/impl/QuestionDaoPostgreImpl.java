package com.sandarovich.kickstarter.dao.impl;


import com.sandarovich.kickstarter.dao.QuestionDao;
import com.sandarovich.kickstarter.model.Project;
import com.sandarovich.kickstarter.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class QuestionDaoPostgreImpl implements QuestionDao {

    private static final String SQL_FIND_QUESTIONS_BY_PROJECT_ID =
            "SELECT id, text " +
                    "FROM question " +
                    "WHERE projectid=?";
    private static final String SQL_ADD_QUESTION_INTO_PROJECT =
            "INSERT INTO question (text, projectid)" +
                    "VALUES (?, ?);";

    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Question> getQuestions(Project project) {
        return jdbcTemplate.query(
                SQL_FIND_QUESTIONS_BY_PROJECT_ID,
                new Object[]{project.getId()},
                new BeanPropertyRowMapper<>(Question.class));
    }

    @Override
    public void addQuestion(Question question, int projectId) {
        jdbcTemplate.update(
                SQL_ADD_QUESTION_INTO_PROJECT,
                new Object[]{question.getText(), projectId});
    }
}
