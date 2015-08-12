package ua.com.goit.kyrychok.dao.database;

import ua.com.goit.kyrychok.dao.ProjectEventDao;
import ua.com.goit.kyrychok.domain.ProjectEvent;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbProjectEventDao implements ProjectEventDao {
    private ProjectEventSqlProvider sqlProvider;

    public DbProjectEventDao(ProjectEventSqlProvider sqlProvider) {
        this.sqlProvider = sqlProvider;
    }

    List<ProjectEvent> fetch(int projectId, Connection connection) throws SQLException {
        List<ProjectEvent> result = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(sqlProvider.get4Fetch())) {
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

    void add(int projectId, ProjectEvent projectEvent, Connection connection) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(sqlProvider.get4Add(), new String[]{"project_event_id"})) {
            statement.setDate(1, (Date) projectEvent.getEventDate());
            statement.setString(2, projectEvent.getMessage());
            statement.setInt(3, projectId);
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    projectEvent.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Can't receive project event ID.");
                }
            }
        }
    }

    void addList(int projectId, List<ProjectEvent> projectEvents, Connection connection) throws SQLException {
        for (ProjectEvent projectEvent : projectEvents) {
            add(projectId, projectEvent, connection);
        }
    }

}
