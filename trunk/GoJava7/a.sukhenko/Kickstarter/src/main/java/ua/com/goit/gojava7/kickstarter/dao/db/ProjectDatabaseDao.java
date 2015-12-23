package ua.com.goit.gojava7.kickstarter.dao.db;

import java.security.InvalidParameterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.stereotype.Component;

import ua.com.goit.gojava7.kickstarter.dao.DatabaseDao;
import ua.com.goit.gojava7.kickstarter.domain.Project;
@Component
public class ProjectDatabaseDao extends DatabaseDao<Project>{
    private static final String PROJECT_PLEDGED = "pledged";
    private static final Logger LOGGER = LogManager.getLogger(ProjectDatabaseDao.class);
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
        try (PreparedStatement ps = getConnection().prepareStatement(query); ResultSet resultSet = ps.executeQuery()) {
            while (resultSet.next()) {
                data.add(readElement(resultSet));
            }
        } catch (SQLException e) {
            LOGGER.error("Fail of getByCategory()",e);
        }
        return data;
    }

    public void updatePledged(Project project, double amount) {
        if(amount > 0.0){
            String query = "UPDATE " + table + " SET pledged = pledged + " + amount + " WHERE name = '"
                    + prepareStringForDb(project.getProjectName()) + "'";
            try (PreparedStatement ps = getConnection().prepareStatement(query);) {
                ps.executeUpdate();
                project.updatePledged(amount);
            } catch (SQLException e) {
                LOGGER.error("Fail of updatePledged()",e);
            }
            }else{
                throw new InvalidParameterException("amount cannot be negative");
            }
        
    }

    public double getPledged(String projectName) {
        String query = "SELECT pledged FROM " + table + " WHERE name = '" + prepareStringForDb(projectName) + "'";
        try (PreparedStatement ps = dataSource.getConnection().prepareStatement(query); ResultSet resultSet = ps.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getInt(PROJECT_PLEDGED);
            }
        } catch (SQLException e) {
            LOGGER.error("Fail of getPledged()",e);
        }
        throw new NoSuchElementException("Haven't found project " + projectName);
    }

    @Override
    protected Project readElement(ResultSet resultSet) throws SQLException {
        Project project;
        project = new Project();
        project.setProjectName(resultSet.getString("projectName"));
        project.setProjectDescription(resultSet.getString("projectDescription"));
        project.setMoneyNeeded(resultSet.getDouble("moneyNeeded"));
        project.setPledged(resultSet.getInt(PROJECT_PLEDGED));
        project.setProjectHistory(resultSet.getString("projectHistory"));
        project.setDemoLink(resultSet.getString("demoLink"));
        project.setProjectCategoryId(resultSet.getInt("projectCategoryId"));
        project.setCategoryName(resultSet.getString("categoryName"));
        project.setEnddate(LocalDateTime.now().plusDays(5));
        // TODO: Enddate
        return project;
    }

    public void addProject(Project project) {
        LOGGER.info("Function not done");

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
            LOGGER.error("Fail of userContributeToProject()",e);
        }

    }

    public Project getProjectByName(String projectName) {
        String query = "SELECT " + fields + " FROM " + table + " WHERE projectName = '" + prepareStringForDb(projectName) + "'";
        try (PreparedStatement ps = getConnection().prepareStatement(query); ResultSet resultSet = ps.executeQuery()) {
            if (resultSet.next()) {
                Project project = new Project();
                project.setProjectName(resultSet.getString("projectName"));
                project.setProjectDescription(resultSet.getString("projectDescription"));
                project.setMoneyNeeded(resultSet.getDouble("moneyNeeded"));
                project.setPledged(resultSet.getInt(PROJECT_PLEDGED));
                project.setProjectHistory(resultSet.getString("projectHistory"));
                project.setDemoLink(resultSet.getString("demoLink"));
                project.setProjectCategoryId(resultSet.getInt("projectCategoryId"));
                project.setCategoryName(resultSet.getString("categoryName"));
                project.setEnddate(LocalDateTime.now().plusDays(5));
                return project;
            }
        } catch (SQLException e) {
            LOGGER.error("Fail of getProjectByName()",e);
        }
        throw new NoSuchElementException();
    }

    @Override
    public Connection getConnection() throws SQLException{
        return dataSource.getConnection();
    }

    @Override
    public Project getByNumber(int number) {
                LOGGER.info("Function not done");
        return null;
    }

    @Override
    public void setAll(List<Project> data) {
        LOGGER.info("Function not done");
        
    }

    @Override
    public List<Project> getAll() {
        String query = "SELECT " + fields + " FROM " + table;
        List<Project> data = new ArrayList<>();
        try (PreparedStatement ps = getConnection().prepareStatement(query); ResultSet resultSet = ps.executeQuery()) {
            while (resultSet.next()) {
                data.add(readElement(resultSet));
            }
        } catch (SQLException e) {
            LOGGER.error("Error in getAll()",e);
        }
        return data;
    }

    @Override
    public Project get(int index) {
        LOGGER.info("Function not done");
        return null;
    }

    @Override
    public int size() {
        LOGGER.info("Function not done");
        return 0;
    }
}
