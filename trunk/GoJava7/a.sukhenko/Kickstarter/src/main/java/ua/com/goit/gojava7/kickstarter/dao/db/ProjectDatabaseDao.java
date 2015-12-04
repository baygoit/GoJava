package ua.com.goit.gojava7.kickstarter.dao.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.DatabaseDao;
import ua.com.goit.gojava7.kickstarter.dao.storage.ProjectStorage;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.User;

public class ProjectDatabaseDao extends DatabaseDao<Project> implements ProjectStorage{

	private static String	TABLE	= "project";
	private static String	FIELDS	= "name, description, goal, pledged, daysToGo, history, link";

	public ProjectDatabaseDao(Connection connection) {
		super(connection, FIELDS, TABLE);
	}

	@Override
	public List<Project> getByCategory(String categoryName) {
		String query = "SELECT " + FIELDS + " FROM " + TABLE + " WHERE category_id = "
				+ "(SELECT id FROM category WHERE name = '" + categoryName + "')";
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
	public void updatePledged(Project project, double amount) {
		String query = "UPDATE " + TABLE + " SET pledged = pledged + " + amount + " WHERE name = '"
				+ prepareStringForDb(project.getProjectName()) + "'";
		try (PreparedStatement ps = connection.prepareStatement(query);) {
			ps.executeUpdate();
			project.updatePledged(amount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public double getPledged(String projectName) {
		String query = "SELECT pledged FROM " + TABLE + " WHERE name = '" + prepareStringForDb(projectName) + "'";
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
		project.setProjectName(resultSet.getString("name"));
		project.setProjectDescription(resultSet.getString("description"));
		project.setMoneyNeeded(resultSet.getDouble("goal"));
		project.setPledged(resultSet.getInt("pledged"));
		// TODO do this shit
		// project.setEnddate(resultSet.getDate("enddate"));
		project.setProjectHistory(resultSet.getString("history"));
		project.setDemoLink(resultSet.getString("link"));
		return project;
	}

	@Override
	public void addProject(Project project) {
		// TODO Auto-generated method stub

	}

	@Override
	public void add(Project element) {
		// TODO Auto-generated method stub

	}

	@Override
	public void userContributeToProject(User user, Double valueOf, String projectName) {
		// TODO Auto-generated method stub

	}
}
