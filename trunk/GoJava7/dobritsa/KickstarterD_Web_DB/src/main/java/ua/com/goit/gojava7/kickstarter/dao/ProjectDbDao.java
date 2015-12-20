package ua.com.goit.gojava7.kickstarter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import ua.com.goit.gojava7.kickstarter.DbDao;
import ua.com.goit.gojava7.kickstarter.models.Project;

@Component
public class ProjectDbDao extends DbDao<Project> {
	
	private static final Logger log = LoggerFactory.getLogger(ProjectDbDao.class);	 
	private static final String TABLE = "project";
	private static final String FIELDS = "id, name, description, goal, pledged, daysToGo, history, link, category_id";

	public ProjectDbDao() {	
		log.info("Constructor ProjectDbDao()...");		
		super.TABLE = TABLE;
		super.FIELDS = FIELDS;
	}
	
	public ProjectDbDao(BasicDataSource basicDataSource) {
		super(basicDataSource, FIELDS, TABLE);
	}

	public void updatePledged(Project project, int amount) {
		log.info("updatePledged({}, {})...", project, amount);		
		String query = "UPDATE " + TABLE + " SET pledged = pledged + " + amount + " WHERE name = '"
				+ prepareStringForDb(project.getName()) + "'";
		log.debug("updatePledged({}, {}) built query: {}", project, amount, query);
		
		try (Connection connection = basicDataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(query)) {
			ps.executeUpdate();
			project.updatePledged(amount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Project readElement(ResultSet resultSet) throws SQLException {
		log.info("readElement()...");			
		Project project = new Project();
		project.setId(resultSet.getInt("id"));
		project.setName(resultSet.getString("name"));
		project.setDescription(resultSet.getString("description"));
		project.setGoal(resultSet.getInt("goal"));
		project.setPledged(resultSet.getInt("pledged"));
		project.setDaysToGo(resultSet.getInt("daysToGo"));
		project.setHistory(resultSet.getString("history"));
		project.setLink(resultSet.getString("link"));
		project.setCategoryId(resultSet.getInt("category_id"));
		log.debug("readElement() returned project: {}", project);
		return project;
	}

	public List<Project> getByCategory(int categoryId) {	
		log.info("getByCategory({})...", categoryId);	
		String query = "SELECT " + FIELDS + " FROM " + TABLE + " WHERE category_id = " + categoryId;
		log.debug("getByCategory({}) built query: {}", categoryId, query);
		
		List<Project> data = new ArrayList<>();
		try (Connection connection = basicDataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(query); ResultSet resultSet = ps.executeQuery()) {
			while (resultSet.next()) {
				data.add(readElement(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		log.debug("getByCategory({}) returned projects: {}", categoryId, data);
		return data;
	}
}
