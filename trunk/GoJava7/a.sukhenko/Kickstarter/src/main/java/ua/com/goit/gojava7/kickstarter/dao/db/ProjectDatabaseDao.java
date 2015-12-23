package ua.com.goit.gojava7.kickstarter.dao.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
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
    LOGGER.log(Level.DEBUG, "Emty Constructor ProjectDatabaseDao");
}
    
@Override
public Project get(int index) {
    String query = "select " + fields + " from " + table + " where id="+index;
    return jdbcTemplate.query(query, new ResultSetExtractor<Project>(){

        @Override
        public Project extractData(ResultSet resultSet) throws SQLException, DataAccessException {
            if (resultSet.next()) {
                return readElement(resultSet);
            }
            throw new NoSuchElementException();
        }
        
    });
}


    public List<Project> getByCategory(String categoryName) {
        String query = "SELECT " + fields + " FROM " + table + " WHERE projectCategoryId = "
                + "(SELECT categoryId FROM categories WHERE categoryName = '" + categoryName + "')";
        return jdbcTemplate.query(query, new RowMapper<Project>() {

            @Override
            public Project mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                return readElement(resultSet);
            }
            });

    }
    public void updatePledged(Project project,double amount) {
            String query = "UPDATE " + table + " SET pledged = pledged + " + amount + " WHERE name = '";
            jdbcTemplate.update(query);
        }
     


    public double getPledged(String projectName) {
        LOGGER.debug("using getPledged for project: " + projectName);
        String query = "SELECT pledged FROM " + table + " WHERE name = '" + prepareStringForDb(projectName) + "'";
        
        return jdbcTemplate.query(query, new ResultSetExtractor<Double>() {
            
            @Override
            public Double extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                   return  rs.getDouble("pledged");
                    
                }
     
                throw new NoSuchElementException("Haven't found project " + projectName);
            }
     
        });
        
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
        LOGGER.info("Not done add()");

    }

    public void userContributeToProject(Double valueOf, String projectName) {
        String query = "UPDATE " + table + " SET pledged= pledged + " + valueOf + " where projectName='" + projectName + "'";
        jdbcTemplate.update(query);

    }
    
    public Project getProjectByName(String projectName) {
        String query = "SELECT " + fields + " FROM " + table + " WHERE projectName = '" + prepareStringForDb(projectName) + "'";
        return jdbcTemplate.query(query, new ResultSetExtractor<Project>() {
            
            @Override
            public Project extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    return readElement(rs);
                }
     
                throw new NoSuchElementException();
            }
     
        });
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
    public List<Project> getAll(){
        String query = "select " + fields + " from " + table;
        List<Project> results = jdbcTemplate.query(query, new RowMapper<Project>() {

            @Override
            public Project mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                return readElement(resultSet);
            }});
        
        return results;
    }
    

    @Override
    public int size() {
        LOGGER.info("Function not done");
        return 0;
    }
}
