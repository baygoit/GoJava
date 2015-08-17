package com.tyomsky.kickstarter.dao;

import com.tyomsky.kickstarter.model.Category;
import com.tyomsky.kickstarter.model.Project;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectDAOImpl implements ProjectDAO {

    private DataSource dataSource;

    public ProjectDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Project> getByCategoryId(int categoryId) {
        List<Project> result = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT p.ID, " +
                            "p.NAME, " +
                            "p.CATEGORY_ID, " +
                            "p.DESCRIPTION, " +
                            "p.COST, " +
                            "p.BALANCE, " +
                            "p.DEADLINE, " +
                            "c.NAME AS CATEGORY_NAME " +
                            "FROM PROJECTS p, CATEGORIES c " +
                            "WHERE c.ID = p.CATEGORY_ID AND CATEGORY_ID = (?)"
            );
            preparedStatement.setInt(1, categoryId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Project project = new Project(resultSet.getInt("ID"), resultSet.getString("NAME"),
                        resultSet.getString("DESCRIPTION"),
                        new Category(resultSet.getInt("CATEGORY_ID"), resultSet.getString("CATEGORY_NAME")));
                project.setCost(resultSet.getInt("COST"));
                project.setBalance(resultSet.getInt("BALANCE"));
                project.setDeadLine(resultSet.getString("DEADLINE"));
                result.add(project);
            }
        } catch (SQLException e) {
            throw new RuntimeException("cant get db connection", e);
        }
        return result;
    }

    @Override
    public Project getById(int id) {
        Project result = null;
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT p.ID, " +
                            "p.NAME, " +
                            "p.CATEGORY_ID, " +
                            "p.DESCRIPTION, " +
                            "p.COST, " +
                            "p.BALANCE, " +
                            "p.DEADLINE, " +
                            "p.VIDEOLINK, " +
                            "p.HISTORY, " +
                            "p.QUESTIONSANDANSWERS, " +
                            "c.NAME AS CATEGORY_NAME " +
                            "FROM PROJECTS p, CATEGORIES c " +
                            "WHERE c.ID = p.CATEGORY_ID AND p.ID = (?)"
            );
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Project project = new Project(resultSet.getInt("ID"), resultSet.getString("NAME"),
                        resultSet.getString("DESCRIPTION"),
                        new Category(resultSet.getInt("CATEGORY_ID"), resultSet.getString("CATEGORY_NAME")));
                project.setCost(resultSet.getInt("COST"));
                project.setBalance(resultSet.getInt("BALANCE"));
                project.setDeadLine(resultSet.getString("DEADLINE"));
                project.setVideoLink(resultSet.getString("VIDEOLINK"));
                project.setHistory(resultSet.getString("HISTORY"));
                project.setQuestionsAndAnswers(resultSet.getString("QUESTIONSANDANSWERS"));
                result = project;
            }
        } catch (SQLException e) {
            throw new RuntimeException("cant get db connection", e);
        }
        return result;
    }

    @Override
    public void update(Project project) {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE PROJECTS " +
                    "SET BALANCE =(?)" +
                    "WHERE ID=(?);");
            preparedStatement.setInt(1,project.getBalance());
            preparedStatement.setInt(2,project.getId());
            int count = preparedStatement.executeUpdate();
            if (count != 1) {
                throw new RuntimeException("On update modify more then 1 record: " + count);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
