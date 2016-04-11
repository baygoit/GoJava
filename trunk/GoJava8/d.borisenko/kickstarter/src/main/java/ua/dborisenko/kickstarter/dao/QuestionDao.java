package ua.dborisenko.kickstarter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.dborisenko.kickstarter.domain.Project;
import ua.dborisenko.kickstarter.domain.Question;

@Repository
public class QuestionDao {
    private static final String QUERY_GET_QUESTIONS = "SELECT id, request, reply FROM questions WHERE project_id = ?";
    private static final String QUERY_ADD_QUESTION = "INSERT INTO questions (project_id, request) VALUES (?, ?)";
    @Autowired
    private DataSource dataSource;

    public void getQuestions(Project project) {
        try (Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(QUERY_GET_QUESTIONS)) {
            statement.setInt(1, project.getId());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Question question = new Question();
                question.setId(rs.getInt("id"));
                question.setRequest(rs.getString("request"));
                question.setReply(rs.getString("reply"));
                project.addQuestion(question);
            }
        } catch (SQLException | NullPointerException e) {
            throw new IllegalStateException(e);
        }
    }

    public void addQuestion(int projectId, Question question) {
        try (Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(QUERY_ADD_QUESTION)) {
            statement.setInt(1, projectId);
            statement.setString(2, question.getRequest());
            statement.executeUpdate();
        } catch (SQLException | NullPointerException e) {
            throw new IllegalStateException(e);
        }
    }

}
