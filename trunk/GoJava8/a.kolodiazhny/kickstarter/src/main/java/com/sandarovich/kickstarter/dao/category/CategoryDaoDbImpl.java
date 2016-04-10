package com.sandarovich.kickstarter.dao.category;


import com.sandarovich.kickstarter.dao.DaoDB;
import com.sandarovich.kickstarter.dao.DaoException;
import com.sandarovich.kickstarter.dao.NoResultException;
import com.sandarovich.kickstarter.domain.Category;
import com.sandarovich.kickstarter.domain.Project;
import com.sandarovich.kickstarter.domain.Question;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoDbImpl extends DaoDB implements CategoryDao {

    private static final String SQL_GET_CATEGORIES = "SELECT id, name FROM category";
    private static final String SQL_FIND_BY_CATEGORY = "SELECT id, name FROM category WHERE id=?";
    private static final String SQL_FIND_PROJECTS_BY_CATEGORY =
        "SELECT id, name, description, required_budget, days_left, video_link, history " +
            "FROM project " +
            "WHERE categoryid=?;";
    private static final String SQL_FIND_GATHERED_BUDGET_BY_PROJECT =
        "SELECT SUM(amount) amount " +
            "FROM  payment " +
            "WHERE projectid=?;";
    private static final String SQL_FIND_BY_PROJECT_ID =
        "SELECT id, name, description, required_budget, days_left, video_link, history " +
            "FROM project " +
            "WHERE id=?;";
    private static final String SQL_FIND_QUESTIONS_BY_PROJECT_ID =
        "SELECT id, text " +
            "FROM question " +
            "WHERE projectid=?";
    private static final String SQL_ADD_QUESTION_INTO_PROJECT =
        "INSERT INTO question (text, projectid)" +
            "VALUES (?, ?);";
    private static final String SQL_FIND_CATEGORY_BY_PROJECT =
        "SELECT id, name " +
            "FROM category " +
            "WHERE id = ( " +
            "SELECT categoryid " +
            "FROM project " +
            "WHERE id=? " +
            "GROUP by categoryid " +
            "LIMIT(1));";

    @Override
    public List<Category> getCategories() {
        List<Category> result = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_CATEGORIES)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                result.add(category);
            }
            rs.close();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return result;
    }

    @Override
    public Category findCategoryById(int categoryId) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_BY_CATEGORY)) {
            statement.setInt(1, categoryId);
            ResultSet rs = statement.executeQuery();
            Category category;
            if (rs.next()) {
                String name = rs.getString("name");
                rs.close();
                category = new Category();
                category.setId(categoryId);
                category.setName(name);
            } else {
                throw new NoResultException("No category found");
            }
            return category;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Project> getProjects(Category category) {
        List<Project> projects = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_PROJECTS_BY_CATEGORY)) {
            statement.setInt(1, category.getId());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Project project = getProject(rs);
                projects.add(project);
            }
            rs.close();
        } catch (SQLException e) {
            throw new DaoException(e);
        }

        return projects;
    }

    private Project getProject(ResultSet rs) throws SQLException {
        Project project = new Project();
        project.setId(rs.getInt("id"));
        project.setName(rs.getString("name"));
        project.setDesription(rs.getString("description"));
        project.setRequiredBudget(rs.getDouble("required_budget"));
        project.setDaysLeft(rs.getInt("days_left"));
        project.setHistory(rs.getString("history"));
        project.setVideoLink(rs.getString("video_link"));
        project.setGatheredBudget(getGatheredBudget(project));
        return project;
    }

    @Override
    public Project findProjectById(int projectId) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_BY_PROJECT_ID)) {
            statement.setInt(1, projectId);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Project project = getProject(rs);
                rs.close();
                return project;
            } else {
                throw new NoResultException("No project found");
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Question> getQuestions(Project project) {
        List<Question> questions = new ArrayList<>();
        try (Connection connection = getConnection();
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
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_ADD_QUESTION_INTO_PROJECT)) {
            statement.setString(1, question.getText());
            statement.setInt(2, projectId);
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            throw new DaoException(e);
        }

    }

    @Override
    public Category findCategoryByProject(Project project) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_CATEGORY_BY_PROJECT)) {
            statement.setInt(1, project.getId());
            ResultSet rs = statement.executeQuery();
            Category category;
            if (rs.next()) {
                String name = rs.getString("name");
                int id = rs.getInt("id");
                rs.close();
                category = new Category();
                category.setId(id);
                category.setName(name);
            } else {
                throw new NoResultException("No category found");
            }
            return category;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    private double getGatheredBudget(Project project) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_GATHERED_BUDGET_BY_PROJECT)) {
            statement.setInt(1, project.getId());
            ResultSet rs = statement.executeQuery();
            double result = rs.next() ? rs.getDouble("amount") : 0;
            rs.close();
            return result;
        } catch (SQLException e) {
            throw new DaoException(e);
        }

    }

}
