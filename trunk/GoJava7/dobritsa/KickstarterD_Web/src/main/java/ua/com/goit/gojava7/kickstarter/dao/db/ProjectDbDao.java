package ua.com.goit.gojava7.kickstarter.dao.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.stereotype.Component;

import ua.com.goit.gojava7.kickstarter.dao.DbDao;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.domain.Project;

@Component
public class ProjectDbDao extends DbDao<Project> implements ProjectDao {

	private static final String TABLE = "project";
	private static final String FIELDS = "id, name, description, goal, pledged, daysToGo, history, link, category_id";

	public ProjectDbDao() {	
		super.TABLE = TABLE;
		super.FIELDS = FIELDS;
	}
	
	public ProjectDbDao(BasicDataSource basicDataSource) {
		super(basicDataSource, FIELDS, TABLE);
	}

	@Override
	public void updatePledged(Project project, int amount) {
		String query = "UPDATE " + TABLE + " SET pledged = pledged + " + amount + " WHERE name = '"
				+ prepareStringForDb(project.getName()) + "'";
		try (Connection connection = basicDataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(query)) {
			ps.executeUpdate();
			project.updatePledged(amount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected Project readElement(ResultSet resultSet) throws SQLException {
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
		return project;
	}

	@Override
	public List<Project> getByCategory(int categoryId) {	
		String query = "SELECT " + FIELDS + " FROM " + TABLE + " WHERE category_id = " + categoryId;
		List<Project> data = new ArrayList<>();
		try (Connection connection = basicDataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(query); ResultSet resultSet = ps.executeQuery()) {
			while (resultSet.next()) {
				data.add(readElement(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}
}
