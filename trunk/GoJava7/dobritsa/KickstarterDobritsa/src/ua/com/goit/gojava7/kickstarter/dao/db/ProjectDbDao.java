package ua.com.goit.gojava7.kickstarter.dao.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.DbDao;
import ua.com.goit.gojava7.kickstarter.dao.storage.ProjectStorage;
import ua.com.goit.gojava7.kickstarter.domain.Project;

public class ProjectDbDao extends DbDao<Project> implements ProjectStorage {

	private static String TABLE = "project";
	private static String FIELDS = "name, description, goal, pledged, daysToGo, history, link";

	public ProjectDbDao(Connection connection) {
		super(connection, FIELDS, TABLE);
	}

	@Override
	public List<Project> getByCategory(String categoryName) {
		String query = "select " + FIELDS + " from " + TABLE + " where category_id = "
				+ "(select id from category where name = '" + categoryName + "')";
		List<Project> data = new ArrayList<>();
		try (PreparedStatement ps = connection.prepareStatement(query); ResultSet resultSet = ps.executeQuery()) {
			while (resultSet.next()) {
				data.add(readElement(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public void updatePledged(Project project, int amount) {
		String query = "update project set pledged = pledged + " + amount + " where name = '"
				+ prepareStringForDb(project.getName()) + "'";
		try (PreparedStatement ps = connection.prepareStatement(query);) {
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int getPledged(String projectName) {
		String query = "select pledged from project where name = '" + prepareStringForDb(projectName) + "'";
		try (PreparedStatement ps = connection.prepareStatement(query); ResultSet resultSet = ps.executeQuery()) {
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
		project.setName(resultSet.getString("name"));
		project.setDescription(resultSet.getString("description"));
		project.setGoal(resultSet.getInt("goal"));
		project.setPledged(resultSet.getInt("pledged"));
		project.setDaysToGo(resultSet.getInt("daysToGo"));
		project.setHistory(resultSet.getString("history"));
		project.setLink(resultSet.getString("link"));
		return project;
	}	
}
