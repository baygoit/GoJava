package ua.com.goit.gojava7.kickstarter.dao.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.stereotype.Component;

import ua.com.goit.gojava7.kickstarter.dao.DatabaseDao;
import ua.com.goit.gojava7.kickstarter.domain.Project;
@Component
public class ProjectDatabaseDao extends DatabaseDao<Project>{

    private static String table  = "projects";
    private static String fields = "projectName, projectDescription, moneyNeeded,projectHistory,demoLink,projectCategoryId,categoryName,pledged,enddate";
public ProjectDatabaseDao(DataSource dataSource) {
    this.dataSource = dataSource;
}
public ProjectDatabaseDao() {
    // TODO Auto-generated constructor stub
}

    public List<Project> getByCategory(String categoryName) {
        String query = "SELECT " + fields + " FROM " + table + " WHERE projectCategoryId = "
                + "(SELECT categoryId FROM categories WHERE categoryName = '" + categoryName + "')";
        List<Project> data = new ArrayList<>();
        try (PreparedStatement ps = dataSource.getConnection().prepareStatement(query); ResultSet resultSet = ps.executeQuery()) {
            while (resultSet.next()) {
                data.add(readElement(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    public void updatePledged(Project project, double amount) {
        String query = "UPDATE " + table + " SET pledged = pledged + " + amount + " WHERE name = '"
                + prepareStringForDb(project.getProjectName()) + "'";
        try (PreparedStatement ps = dataSource.getConnection().prepareStatement(query);) {
            ps.executeUpdate();
            project.updatePledged(amount);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public double getPledged(String projectName) {
        String query = "SELECT pledged FROM " + table + " WHERE name = '" + prepareStringForDb(projectName) + "'";
        try (PreparedStatement ps = dataSource.getConnection().prepareStatement(query); ResultSet resultSet = ps.executeQuery()) {
            if (resultSet.next()) {
                int pledged = resultSet.getInt("pledged");
                return pledged;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    protected Project readElement(ResultSet resultSet) throws SQLException {
        Project project;
        project = new Project();
        project.setProjectName(resultSet.getString("projectName"));
        project.setProjectDescription(resultSet.getString("projectDescription"));
        project.setMoneyNeeded(resultSet.getDouble("moneyNeeded"));
        project.setPledged(resultSet.getInt("pledged"));
        project.setProjectHistory(resultSet.getString("projectHistory"));
        project.setDemoLink(resultSet.getString("demoLink"));
        project.setProjectCategoryId(resultSet.getInt("projectCategoryId"));
        project.setCategoryName(resultSet.getString("categoryName"));
        project.setEnddate(LocalDateTime.now().plusDays(5));
        // TODO: Enddate
        return project;
    }

    public void addProject(Project project) {
        // TODO Auto-generated method stub

    }

    @Override
    public void add(Project element) {
        data.add(element);

    }

    public void userContributeToProject(Double valueOf, String projectName) {
        String query = "UPDATE " + table + " SET pledged= pledged + " + valueOf + " where projectName='" + projectName + "'";
        try (PreparedStatement ps = dataSource.getConnection().prepareStatement(query);) {
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public Project getProjectByName(String projectName) {
        String query = "SELECT projectName FROM " + table + " WHERE projectname = '" + prepareStringForDb(projectName) + "'";
        try (PreparedStatement ps = dataSource.getConnection().prepareStatement(query); ResultSet resultSet = ps.executeQuery()) {
            if (resultSet.next()) {
                Project project = new Project();
                project.setProjectName(resultSet.getString("projectName"));
                project.setProjectDescription(resultSet.getString("projectDescription"));
                project.setMoneyNeeded(resultSet.getDouble("moneyNeeded"));
                project.setPledged(resultSet.getInt("pledged"));
                project.setProjectHistory(resultSet.getString("projectHistory"));
                project.setDemoLink(resultSet.getString("demoLink"));
                project.setProjectCategoryId(resultSet.getInt("projectCategoryId"));
                project.setCategoryName(resultSet.getString("categoryName"));
                project.setEnddate(LocalDateTime.now().plusDays(5));
                return project;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new NoSuchElementException();
    }

    @Override
    public Connection getConnection() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Project getByNumber(int number) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setAll(List<Project> data) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<Project> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Project get(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }
}
