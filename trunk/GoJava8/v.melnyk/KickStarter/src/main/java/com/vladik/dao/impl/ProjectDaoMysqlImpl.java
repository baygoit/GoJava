package com.vladik.dao.impl;

import com.vladik.dao.AbstractProjectDao;
import com.vladik.model.Category;
import com.vladik.model.Payment;
import com.vladik.model.Project;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProjectDaoMysqlImpl extends AbstractProjectDao {
    private static final String INSERT_PROJECT = "INSERT INTO Projects (category_id, title, brief_description, full_description, "
            + "video_link, required_sum, collected_sum, days_left) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String DELETE_PROJECT = "DELETE FROM Projects WHERE id = ?";
    private static final String SELECT_ALL_PROJECTS = "SELECT id, category_id, title, brief_description, full_description, "
            + "video_link, required_sum, collected_sum, days_left FROM Projects";
    private static final String COUNT_ALL_PROJECTS = "SELECT count(*) FROM Projects";
    private static final String SELECT_PROJECTS_FROM_CATEGORY = "SELECT id, category_id, title, brief_description, full_description, "
            + "video_link, required_sum, collected_sum, days_left FROM Projects WHERE category_id = ?";
    private static final String INVEST_INTO_PROJECT = "INSERT INTO Payments (project_id, cardholder_name, card_number, donating_sum) VALUES (?, ? , ?, ?)";
    private static final String SELECT_PROJECT_BY_ID = "SELECT id, category_id, title, brief_description, full_description, video_link, required_sum, collected_sum, days_left FROM Projects WHERE id = ?";
    @Override
    public void add(Project project) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT_PROJECT);
            statement.setInt(1, project.getCategoryID());
            statement.setString(2, project.getTitle());
            statement.setString(3, project.getBriefDescription());
            statement.setString(4, project.getFullDescription());
            statement.setString(5, project.getVideoLink());
            statement.setInt(6, project.getRequiredSum());
            statement.setInt(7, project.getCollectedSum());
            statement.setInt(8, project.getDaysLeft());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Project project) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_PROJECT);
            statement.setInt(1, project.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//    private setProjectWithResultSet ()

    @Override
    public List<Project> getAll() {
        List<Project> projects = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_PROJECTS);
            Project project;
            while (resultSet.next()) {
                project = new Project();
                project.setId(resultSet.getInt("id"));
                project.setCategoryID(resultSet.getInt("category_id"));
                project.setTitle(resultSet.getString("title"));
                project.setBriefDescription(resultSet.getString("brief_description"));
                project.setFullDescription(resultSet.getString("full_description"));
                project.setVideoLink(resultSet.getString("video_link"));
                project.setRequiredSum(resultSet.getInt("required_sum"));
                project.setCollectedSum(resultSet.getInt("collected_sum"));
                project.setDaysLeft(resultSet.getInt("days_left"));
                projects.add(project);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projects;
    }

    @Override
    public int getSize() {
        int amountOfProjects = 0;
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(COUNT_ALL_PROJECTS);
            while (resultSet.next()) {
                amountOfProjects = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return amountOfProjects;
    }

    @Override
    public List<Project> getProjectsFromCategory(Category category) {
        List<Project> projectFromCategory = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_PROJECTS_FROM_CATEGORY);
            statement.setInt(1, category.getId());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Project project = new Project();
                project.setId(resultSet.getInt("id"));
                project.setCategoryID(resultSet.getInt("category_id"));
                project.setTitle(resultSet.getString("title"));
                project.setBriefDescription(resultSet.getString("brief_description"));
                project.setFullDescription(resultSet.getString("full_description"));
                project.setVideoLink(resultSet.getString("video_link"));
                project.setRequiredSum(resultSet.getInt("required_sum"));
                project.setCollectedSum(resultSet.getInt("collected_sum"));
                project.setDaysLeft(resultSet.getInt("days_left"));
                projectFromCategory.add(project);
                category.addProject(project);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projectFromCategory;
//        return jdbcTemplate.query(SELECT_PROJECTS_FROM_CATEGORY, new BeanPropertyRowMapper<Project>(Project.class), category.getId());
    }

    @Override
    public Project getProjectById(int id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_PROJECT_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) {
//                throw new NoResultException("No project found.");
            }
            Project project = new Project();
            project.setId(resultSet.getInt("id"));
            project.setCategoryID(resultSet.getInt("category_id"));
            project.setTitle(resultSet.getString("title"));
            project.setBriefDescription(resultSet.getString("brief_description"));
            project.setFullDescription(resultSet.getString("full_description"));
            project.setVideoLink(resultSet.getString("video_link"));
            project.setRequiredSum(resultSet.getInt("required_sum"));
            project.setCollectedSum(resultSet.getInt("collected_sum"));
            project.setDaysLeft(resultSet.getInt("days_left"));
            return project;
        } catch (SQLException | NullPointerException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void invest(Payment payment, int projectId) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(INVEST_INTO_PROJECT)) {
            statement.setInt(1, projectId);
            statement.setString(2, payment.getCardholderName());
            statement.setLong(3, payment.getCardNumber());
            statement.setInt(4, payment.getDonatingSum());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
