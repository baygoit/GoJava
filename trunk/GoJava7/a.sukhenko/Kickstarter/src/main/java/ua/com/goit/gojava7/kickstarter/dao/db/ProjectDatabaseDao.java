package ua.com.goit.gojava7.kickstarter.dao.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import ua.com.goit.gojava7.kickstarter.dao.DatabaseDao;
import ua.com.goit.gojava7.kickstarter.dao.storage.ProjectStorage;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.User;

public class ProjectDatabaseDao extends DatabaseDao<Project> implements ProjectStorage{

	private static String	TABLE	= "projects";
	private static String	FIELDS	= "projectName, projectDescription, moneyNeeded,projectHistory,demoLink,projectCategoryId,categoryName,pledged,enddate";

	public ProjectDatabaseDao(Connection connection) {
		super(connection, FIELDS, TABLE);
	}

	@Override
	public List<Project> getByCategory(String categoryName) {
		String query = "SELECT " + FIELDS + " FROM " + TABLE + " WHERE projectCategoryId = "
				+ "(SELECT categoryId FROM categories WHERE categoryName = '" + categoryName + "')";
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
		project.setProjectName(resultSet.getString("projectName"));
		project.setProjectDescription(resultSet.getString("projectDescription"));
		project.setMoneyNeeded(resultSet.getDouble("moneyNeeded"));
		project.setPledged(resultSet.getInt("pledged"));
		project.setProjectHistory(resultSet.getString("projectHistory"));
		project.setDemoLink(resultSet.getString("demoLink"));
		project.setProjectCategoryId(resultSet.getInt("projectCategoryId"));
		project.setCategoryName(resultSet.getString("categoryName"));
		project.setEnddate(LocalDateTime.now().plusDays(5));
		//TODO: Enddate
		return project;
	}

	@Override
	public void addProject(Project project) {
		// TODO Auto-generated method stub

	}

	@Override
	public void add(Project element) {
		data.add(element);

	}

	@Override
	public void userContributeToProject(User user, Double valueOf, String projectName) {
		String query = "UPDATE " + TABLE + " SET pledged= pledged + " + valueOf + " where projectName='"+projectName + "'";
		try(PreparedStatement ps = connection.prepareStatement(query); ){
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}



	@Override
	public Project getProjectByName(String projectName) {
		String query = "SELECT projectName FROM " + TABLE + " WHERE projectname = '" + prepareStringForDb(projectName) + "'";
		try (PreparedStatement ps = connection.prepareStatement(query); ResultSet resultSet = ps.executeQuery()) {
			if (resultSet.next()) {
				Project project  = new Project();
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
}
