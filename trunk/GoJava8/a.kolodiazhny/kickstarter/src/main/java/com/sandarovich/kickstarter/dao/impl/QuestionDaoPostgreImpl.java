package com.sandarovich.kickstarter.dao.impl;


import com.sandarovich.kickstarter.dao.QuestionDao;
import com.sandarovich.kickstarter.dao.exception.DaoException;
import com.sandarovich.kickstarter.model.Project;
import com.sandarovich.kickstarter.model.Question;
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

    @Override
    public List<Question> getQuestions(Project project) {
        List<Question> questions = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_QUESTIONS_BY_PROJECT_ID)) {
            statement.setInt(1, project.getId());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Question question = new Question();
                question.setId(rs.getInt("id"));
                question.setText(rs.getString("text"));
                questions.add(question);
            }
            rs.close();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return questions;
    }

    @Override
    public void addQuestion(Question question, int projectId) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_ADD_QUESTION_INTO_PROJECT)) {
            statement.setString(1, question.getText());
            statement.setInt(2, projectId);
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            throw new DaoException(e);
        }

    }

}
