package nikfisher.kickstarter.dao;

import nikfisher.kickstarter.ConnectDB;
import nikfisher.kickstarter.model.Category;
import nikfisher.kickstarter.model.Project;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProjectsDAO implements Projects {

    Project project = null;
    Connection connection = ConnectDB.getDBConnection();

    private ResultSet getResultSet() throws SQLException {
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);
        return statement.executeQuery("SELECT * FROM projects");
    }

    @Override
    public void add(Project project) {

    }

    @Override
    public List<Project> getProjects(Category category) {

        List<Project> result = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            ResultSet rs = statement.executeQuery("SELECT * FROM projects WHERE id_categories = " + category.getID());

            while (rs.next()) {
                result.add(new Project(rs.getInt("id"), rs.getString("name")));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error query! (method get() ", e);
        }
        return result;
    }

    @Override
    public Project get(int index) {
        try {
            ResultSet rs = getResultSet();
            while (rs.next()) {
                project = new Project(rs.getInt("id"), rs.getString("name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error query! (method get() ", e);
        }
        return project;
    }
}
