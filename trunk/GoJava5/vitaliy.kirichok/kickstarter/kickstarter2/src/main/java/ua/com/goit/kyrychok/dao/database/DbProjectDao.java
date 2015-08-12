package ua.com.goit.kyrychok.dao.database;

import ua.com.goit.kyrychok.dao.ProjectDao;
import ua.com.goit.kyrychok.domain.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbProjectDao implements ProjectDao {
    private DbDataSourceProvider dbDataSourceProvider;
    private DbFaqDao dbFaqDao;
    private DbRewardDao dbRewardDao;
    private DbProjectEventDao dbProjectEventDao;
    private ProjectSqlProvider sqlProvider;

    public DbProjectDao(DbDataSourceProvider dbDataSourceProvider, DbFaqDao dbFaqDao, DbRewardDao dbRewardDao, DbProjectEventDao dbProjectEventDao, ProjectSqlProvider sqlProvider) {
        this.dbDataSourceProvider = dbDataSourceProvider;
        this.dbFaqDao = dbFaqDao;
        this.sqlProvider = sqlProvider;
        this.dbRewardDao = dbRewardDao;
        this.dbProjectEventDao = dbProjectEventDao;
    }

    @Override
    public Project load(int id) {
        Project result = null;
        try (Connection connection = dbDataSourceProvider.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(sqlProvider.get4Load())) {
                statement.setInt(1, id);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    result = new Project(resultSet.getString("name"), resultSet.getInt("goal"), resultSet.getDate("deadline_date"));
                    result.setShortDescription(resultSet.getString("description"));
                    result.setBalance(resultSet.getInt("balance"));
                    result.setDemoLink(resultSet.getString("demo_link"));
                    result.setCreateDate(resultSet.getDate("create_date"));
                    result.setId(id);
                }
            }
            result.setProjectEvents(dbProjectEventDao.fetch(id, connection));
            result.setFaqs(dbFaqDao.fetch(id, connection));
            result.setRewards(dbRewardDao.fetch(id, connection));
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public void setBalance(int projectId, int amount) {
        try (Connection connection = dbDataSourceProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlProvider.get4SetBalance())) {
            statement.setInt(1, amount);
            statement.setInt(2, projectId);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public int getBalance(int projectId) {
        int result = 0;
        try (Connection connection = dbDataSourceProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlProvider.get4GetBalance())) {
            statement.setInt(1, projectId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                result = resultSet.getInt("balance");
            }
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    List<Project> fetch(int categoryId, Connection connection) throws SQLException {
        List<Project> result = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(sqlProvider.get4Fetch())) {
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

    void add(int category_id, Project project, Connection connection) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(sqlProvider.get4Add(), new String[]{"project_id"})) {
            statement.setString(1, project.getName());
            statement.setString(2, project.getShortDescription());
            statement.setInt(3, project.getGoal());
            statement.setInt(4, project.getBalance());
            statement.setDate(5, (Date) project.getDeadlineDate());
            statement.setString(6, project.getDemoLink());
            statement.setDate(7, (Date) project.getDeadlineDate());
            statement.setInt(8, category_id);
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    project.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Can't receive project ID.");
                }
            }
        }
        dbFaqDao.addList(project.getId(), project.getFaqs(), connection);
        dbRewardDao.addList(project.getId(), project.getRewards(), connection);
    }

    void addList(int category_id, List<Project> projects, Connection connection) throws SQLException {
        for (Project project : projects) {
            add(category_id, project, connection);
        }
    }
}
