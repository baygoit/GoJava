package ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.beans.Category;
import ua.com.goit.gojava7.kickstarter.beans.Project;
import ua.com.goit.gojava7.kickstarter.dao.ProjectStorage;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.JdbcDispatcher;

public class ProjectPostgreDAO implements ProjectStorage {

    private static final String TABLE = "project";
    private static final String FIELDS = "id,name,goalSum,startDate,endDate,category_id,description,videoUrl,author";
    private static final String INSERTION = FIELDS.replaceAll("[^,]+", "?");
    private static final String KEY = "id";
    
    private JdbcDispatcher dispatcher;

    public ProjectPostgreDAO(JdbcDispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    @Override
    public void clear() {
        String sql = "delete from " + TABLE;
        try(Connection connection = dispatcher.getConnection();
            Statement statement = connection.createStatement()) {
            statement.execute(sql);
            connection.commit();
        } catch (SQLException e) {
            dispatcher.processException(e);
        }
    }

    @Override
    public Project get(int index) {
        String sql = "select " + FIELDS + " from " + TABLE + " where " + KEY + " = " + index;
        Project element = null;
        try(Connection connection = dispatcher.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);) {    
            if (resultSet.next()) {
                element = readElementFromRecord(resultSet);
            }
        } catch (SQLException e) {
            dispatcher.processException(e);
        }
        return element;
    }

    @Override
    public void add(Project element) {
        String sql = "insert into " + TABLE + " (" + FIELDS + ") values (" + INSERTION + ")";
        try(Connection connection = dispatcher.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            writeElementToRecord(element, statement);
            statement.executeUpdate();  
            connection.commit();
        } catch (SQLException e) {
            dispatcher.processException(e);
        }
    }

    @Override
    public void addAll(List<Project> elements) {
        String sql = "insert into " + TABLE + " (" + FIELDS + ") values (" + INSERTION + ")";
        try(Connection connection = dispatcher.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            for (Project element : elements) {
                writeElementToRecord(element, statement);
                statement.executeUpdate();
            } 
            connection.commit();
        } catch (SQLException e) {
            dispatcher.processException(e);
        } 
    }

    @Override
    public List<Project> getAll() {
        String sql = "select " + FIELDS + " from " + TABLE;
        List<Project> result = new ArrayList<>();
        try(Connection connection = dispatcher.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                result.add(readElementFromRecord(resultSet));
            }
        } catch (SQLException e) {
            dispatcher.processException(e);
        }       
        return result;
    }

    @Override
    public List<Project> getByCategory(Category category) {
        String sql = "select " + FIELDS + " from " + TABLE + " where category_id = " + category.getId();
        List<Project> result = new ArrayList<>();
        try(Connection connection = dispatcher.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                result.add(readElementFromRecord(resultSet));
            }
        } catch (SQLException e) {
            dispatcher.processException(e);
        }       
        return result;
    }

    private Project readElementFromRecord(ResultSet resultSet) throws SQLException {
        Project project = new Project();
        project.setId(resultSet.getInt("id"));
        project.setName(resultSet.getString("name"));
        project.setAuthor(resultSet.getString("author"));
        project.setDescription(resultSet.getString("description"));
        project.setVideoUrl(resultSet.getString("videoUrl"));
        project.setStartDate(resultSet.getDate("startDate"));
        project.setEndDate(resultSet.getDate("endDate"));
        project.setGoalSum(resultSet.getLong("goalSum"));
        project.setCategory(null);//resultSet.getInt("category_id"));
        return project;
    }

    private void writeElementToRecord(Project element, PreparedStatement statement) throws SQLException {
        int i = 0;
        statement.setInt(++i, element.getId());
        statement.setString(++i, element.getName());
        statement.setLong(++i, element.getGoalSum());
        statement.setDate(++i, element.getStartDate());
        statement.setDate(++i, element.getEndDate());
        statement.setInt(++i, element.getCategory().getId());
        statement.setString(++i, element.getDescription());
        statement.setString(++i, element.getVideoUrl());
        statement.setString(++i, element.getAuthor());
    }
}
