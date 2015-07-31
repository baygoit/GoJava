package ua.goit.kyrychok.kickstarter.dao.database;

import ua.goit.kyrychok.kickstarter.dao.ProjectDao;
import ua.goit.kyrychok.kickstarter.model.Project;
import ua.goit.kyrychok.kickstarter.model.ProjectEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DbProjectDao implements ProjectDao {
    private DbDataSourceProvider dbDataSourceProvider;
    private DbFaqDao dbFaqDao;

    public DbProjectDao(DbDataSourceProvider dbDataSourceProvider, DbFaqDao dbFaqDao) {
        this.dbDataSourceProvider = dbDataSourceProvider;
        this.dbFaqDao = dbFaqDao;
    }

    @Override
    public Project load(int id) {
        Project result = null;
        String sql = "SELECT p.NAME AS name, " +
                "p.description AS description, " +
                "p.goal AS goal, " +
                "p.balance AS balance, " +
                "p.deadline_date AS deadline_date, " +
                "p.demo_link AS demo_link, " +
                "p.create_date AS create_date " +
                "FROM project p " +
                "WHERE p.project_id = ? ";
        try (Connection connection = dbDataSourceProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result = new Project(resultSet.getString("name"), resultSet.getInt("goal"), resultSet.getDate("deadline_date"));
                result.setShortDescription(resultSet.getString("description"));
                result.setBalance(resultSet.getInt("balance"));
                result.setDemoLink(resultSet.getString("demo_link"));
                result.setCreateDate(resultSet.getDate("create_date"));
                result.setId(id);
                result.setProjectEvents(fetchEvents(id, connection));
                result.setFaqs(dbFaqDao.fetch(id, connection));
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void setBalance(int projectId, int amount) {
        String sql = "UPDATE project " +
                "SET balance = ? " +
                "WHERE project_id = ? ";
        try (Connection connection = dbDataSourceProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, amount);
            statement.setInt(2, projectId);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getBalance(int projectId) {
        int result = 0;
        String sql = "SELECT p.balance AS balance " +
                "FROM project p " +
                "WHERE p.project_id = ? ";
        try (Connection connection = dbDataSourceProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, projectId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result = resultSet.getInt("balance");
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    List<Project> fetch(int categoryId, Connection connection) throws SQLException {
        List<Project> result = new ArrayList<>();
        String sql = "SELECT p.project_id AS id, " +
                "p.name AS project_name, " +
                "p.description AS short_description, " +
                "p.goal AS goal, " +
                "p.balance AS balance, " +
                "p.deadline_date AS deadline_date " +
                "FROM project p " +
                "WHERE p.category_id = ? " +
                "ORDER BY p.name";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, categoryId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Project project = new Project(resultSet.getString("project_name"), resultSet.getInt("goal"), resultSet.getDate("deadline_date"));
                project.setShortDescription(resultSet.getString("short_description"));
                project.setId(resultSet.getInt("id"));
                project.setBalance(resultSet.getInt("balance"));
                result.add(project);
            }
        }
        return result;
    }

    List<ProjectEvent> fetchEvents(int projectId, Connection connection) throws SQLException {
        List<ProjectEvent> result = new ArrayList<>();
        String sql = "SELECT pe.project_event_id AS id, " +
                "pe.event_date AS event_date, " +
                "pe.message AS message " +
                "FROM project_event pe " +
                "WHERE pe.project_id = ? " +
                "ORDER BY pe.event_date DESC ";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, projectId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ProjectEvent projectEvent = new ProjectEvent(resultSet.getDate("event_date"), resultSet.getString("message"));
                projectEvent.setId(resultSet.getInt("id"));
                result.add(projectEvent);
            }
        }
        return result;
    }

}
