package com.sandarovich.kickstarter.dao.impl;


import com.sandarovich.kickstarter.dao.ProjectDao;
import com.sandarovich.kickstarter.dao.exception.DaoException;
import com.sandarovich.kickstarter.dao.exception.NoResultException;
import com.sandarovich.kickstarter.model.Category;
import com.sandarovich.kickstarter.model.Payment;
import com.sandarovich.kickstarter.model.Project;
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
public class ProjectDaoPostgreImpl implements ProjectDao {

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
    private static final String SQL_INVEST_INTO_PROJECT =
            "INSERT INTO payment (cardnumber, cardholder, amount, projectid) " +
                    "VALUES (?, ? , ?, ?);";

    @Autowired
    private DataSource dataSource;

    @Override
    public Project findProjectById(int projectId) {
        try (Connection connection = dataSource.getConnection();
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
    public void invest(Payment payment, int projectId) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_INVEST_INTO_PROJECT)) {
            statement.setString(1, payment.getCardNumber());
            statement.setString(2, payment.getCardHolder());
            statement.setDouble(3, payment.getAmount());
            statement.setInt(4, projectId);
            statement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Project> getProjects(Category category) {
        List<Project> projects = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
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

    private double getGatheredBudget(Project project) {
        try (Connection connection = dataSource.getConnection();
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
