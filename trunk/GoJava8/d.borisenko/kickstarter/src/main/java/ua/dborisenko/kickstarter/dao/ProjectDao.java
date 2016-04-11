package ua.dborisenko.kickstarter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.dborisenko.kickstarter.domain.Category;
import ua.dborisenko.kickstarter.domain.Project;

@Repository
public class ProjectDao {

    private static final String QUERY_GET_PROJECT_BY_ID = "SELECT id, name, description, history, required_sum, days_left, video_url FROM projects WHERE id = ?";
    private static final String QUERY_GET_PROJECTS = "SELECT id, name, description, history, required_sum, days_left, video_url FROM projects WHERE category_id = ?";
    @Autowired
    private DataSource dataSource;
    @Autowired
    private InvestmentDao investmentDao;

    public void getProjects(Category category) {
        try (Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(QUERY_GET_PROJECTS)) {
            statement.setInt(1, category.getId());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Project project = new Project();
                project.setId(rs.getInt("id"));
                project.setName(rs.getString("name"));
                project.setDescription(rs.getString("description"));
                project.setHistory(rs.getString("history"));
                project.setRequiredSum(rs.getInt("required_sum"));
                project.setDaysLeft(rs.getInt("days_left"));
                project.setVideoUrl(rs.getString("video_url"));
                investmentDao.getInvestments(project);
                category.addProject(project);
            }
        } catch (SQLException | NullPointerException e) {
            throw new IllegalStateException(e);
        }
    }

    public Project getProjectById(int id) {
        try (Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(QUERY_GET_PROJECT_BY_ID)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (!rs.next()) {
                throw new NoResultException("No project found.");
            }
            Project project = new Project();
            project.setId(rs.getInt("id"));
            project.setName(rs.getString("name"));
            project.setDescription(rs.getString("description"));
            project.setHistory(rs.getString("history"));
            project.setRequiredSum(rs.getInt("required_sum"));
            project.setDaysLeft(rs.getInt("days_left"));
            project.setVideoUrl(rs.getString("video_url"));
            investmentDao.getInvestments(project);
            return project;
        } catch (SQLException | NullPointerException e) {
            throw new IllegalStateException(e);
        }
    }

}
