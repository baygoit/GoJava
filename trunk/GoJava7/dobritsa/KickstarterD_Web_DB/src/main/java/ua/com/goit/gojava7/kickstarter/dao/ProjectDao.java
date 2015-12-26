package ua.com.goit.gojava7.kickstarter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.models.Project;

@Repository
public class ProjectDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final Logger log = LoggerFactory.getLogger(ProjectDao.class);	 

	public ProjectDao() {	
		log.info("Constructor ProjectDao()...");			
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Project> getByCategory(Long categoryId) {			
		log.info("<Project> getByCategory({})...", categoryId);	
		String query = "select  id, name, description, goal, daysToGo, history, link, category_id from project where category_id = ?";
		return jdbcTemplate.query(query, new Object[] { categoryId }, new ProjectMapper());
	}	
	
	public Project get(Long index) {				
		log.info("<Project> get({})...", index);
		String query = "select id, name, description, goal, daysToGo, history, link, category_id from project where id = ?";
		return jdbcTemplate.queryForObject(query, new Object[] { index }, new ProjectMapper());
	}		
	
	private final class ProjectMapper implements RowMapper<Project> {
		public Project mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			log.info("ProjectMapper()...");
			Project project = new Project();
			project.setId(resultSet.getLong("id"));
			project.setName(resultSet.getString("name"));
			project.setDescription(resultSet.getString("description"));
			project.setGoal(resultSet.getInt("goal"));		
			project.setDaysToGo(resultSet.getInt("daysToGo"));
			project.setHistory(resultSet.getString("history"));
			project.setLink(resultSet.getString("link"));
			project.setCategoryId(resultSet.getLong("category_id"));
			log.debug("ProjectMapper() returned project: {}", project);
			return project;
		}
	}
}
