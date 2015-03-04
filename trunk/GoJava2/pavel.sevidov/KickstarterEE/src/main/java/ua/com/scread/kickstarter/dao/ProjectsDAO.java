package ua.com.scread.kickstarter.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.com.scread.kickstarter.data.Category;
import ua.com.scread.kickstarter.data.Project;
import ua.com.scread.kickstarter.storage.Projects;

public class ProjectsDAO implements Projects {
    
    private Connection connection;

    public ProjectsDAO(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public void add(Project project) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "insert into projects "
                    + "(name, description, id_cat, collected, amount, days, history, video) "
                    + "values (?, ?, ?, ?, ?, ?, ?)");
            statement.setString(2, project.getName());
            statement.setString(3, project.getDescription());
            statement.setInt(4, project.getCategory().getId());
            statement.setDouble(5, project.getCollected());
            statement.setDouble(6, project.getAmount());
            statement.setInt(7, project.getDays());
            statement.setString(8, project.getDetails().getHistory());
            statement.setString(9, project.getDetails().getVideo());
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Something happend while adding new project", e);
        }
    }

    @Override
    public List<Project> getProjects(Category category) {
        try {
            Statement statement = connection.createStatement(); 
            List<Project> result = new ArrayList<Project>();

            ResultSet rs = statement.executeQuery(
                    "select * from projects where id_cat = " + category.getId());
            while (rs.next()) {
                Project project = new Project(rs.getInt("id_prj"), 
                                            rs.getString("name"), 
                                            rs.getString("description"),
                                            rs.getDouble("collected"),
                                            rs.getDouble("amount"),
                                            rs.getInt("days"),
                                            rs.getString("history"),
                                            rs.getString("video"));
                project.setCategory(category);
                result.add(project);
            }   
            
            return result;
        } catch (SQLException e) {
            throw new RuntimeException("Something happend while getting project by category", e);
        }
    }
    
    @Override
    public Project get(int index) {
        try {
            Statement statement = connection.createStatement(); 

            ResultSet rs = statement.executeQuery(
                            "select "
                            + "c.id_cat as category_id, "
                            + "c.name as category_name, "
                            + "p.name as project_name, "
                            + "description, "
                            + "p.id_prj as project_id, "
                            + "collected, "
                            + "amount, "
                            + "days, "
                            + "history, "
                            + "video "
                            + " from projects p, categories c where p.id_cat = c.id_cat and p.id_prj = " + index);
            
            if (rs.next()) {
                Project project = new Project(rs.getInt("project_id"), 
                                            rs.getString("project_name"), 
                                            rs.getString("description"),
                                            rs.getDouble("collected"),
                                            rs.getDouble("amount"),
                                            rs.getInt("days"),
                                            rs.getString("history"),
                                            rs.getString("video"));
                
                Category category = new Category(rs.getInt("category_id"), rs.getString("category_name"));
                
                project.setCategory(category);
                    
                return project;
            }
            throw new RuntimeException("There is no project with id = " + index);
            
        } catch (SQLException e) {
            throw new RuntimeException("Something happend while getting project by id", e);
        }
    }
    
    public void update(int id, Project project) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "update projects set"
                    + "name = ?, description = ?, id_cat = ?, collected = ?, amount = ?, "
                    + "days = ?, history = ?, video = ? "
                    + "where id_prj = " + id);
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setInt(3, project.getCategory().getId());
            statement.setDouble(4, project.getCollected());
            statement.setDouble(5, project.getAmount());
            statement.setInt(6, project.getDays());
            statement.setString(7, project.getDetails().getHistory());
            statement.setString(8, project.getDetails().getVideo());
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Something happend while adding new project", e);
        }
    }
}


