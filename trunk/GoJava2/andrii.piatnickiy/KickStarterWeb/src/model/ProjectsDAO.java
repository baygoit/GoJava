package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class ProjectsDAO {
    private LinkedList<Project> projects = new LinkedList<Project>();
    private Connection connection;

    public ProjectsDAO(Connection connection) {
        this.connection = connection;
    }

    private ResultSet getResultSet(String sql) {
        ResultSet resultSet = null;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            return resultSet;
        } catch (SQLException e) {
            new RuntimeException("SQLException " + e);
        }
        return resultSet;
    }

    public LinkedList<Project> getProjectsList(int categoryId) {
        ResultSet resultSet = getResultSet("SELECT * FROM projects WHERE category_id = " + categoryId);
        try {
            while (resultSet.next()) {
//                projects.add(new Project(resultSet.getString("name"), resultSet
//                        .getString("description"),
//                        resultSet.getInt("need_sum"), resultSet
//                        .getInt("currnt_sum"), resultSet
//                        .getInt("days_left"), resultSet
//                        .getString("project_history"), resultSet
//                        .getString("link_on_video"), resultSet
//                        .getString("questions_and_answers")));
                projects.add(new Project(resultSet.getString("name"), resultSet
                      .getString("description"), resultSet.getInt("need_sum"), resultSet
                    .getInt("current_sum"), resultSet
                    .getInt("days_left"), resultSet
                  .getString("project_history"), resultSet
                  .getString("link_on_video"), resultSet
                  .getString("questions_and_answers")));
            }
            return projects;
        } catch (SQLException e) {
            new RuntimeException("SQLException " + e);
        }
        return projects;
    }
}
