package ua.nenya.dao.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.nenya.dao.ProjectDao;
import ua.nenya.domain.Project;

@Repository
public class ProjectDaoImpl implements ProjectDao {

	private static final String GET_PROJECTS_BY_CATEGORY_NAME = "SELECT projects.id AS id, project_name, description, all_amount, "
			+ "days_remain, history, video FROM categories INNER JOIN projects ON "
			+ "categories.id = projects.category_id WHERE category_name =? ORDER BY project_name";
	private static final String GET_AVAILABLE_AMOUNT_BY_PROJECT_ID = "SELECT Projects.id, Projects.project_name, "
			+ "SUM(Payments.amount) AS sum FROM Projects INNER JOIN Payments ON Projects.id = Payments.project_id "
			+ "GROUP BY Projects.id HAVING Projects.id = ?";
	private static final String GET_PROJECT_BY_NAME = "SELECT id, project_name, description, all_amount, days_remain,"
			+ " history, video FROM projects WHERE project_name = ?";

	@Autowired
	private DataSource dataSource;
	
	@Override
	public Project getProjectByName(String projectName) {
		Project project = new Project();
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(GET_PROJECT_BY_NAME)) {
			statement.setString(1, projectName); 
			ResultSet set = statement.executeQuery();
			set.next();
			fillProject(set, project);
		} catch (SQLException e) {
			e.getStackTrace();
		}
		return project;
	}
	
	@Override
	public List<Project> getProjects(String categoryName) {
		List<Project> projects = new ArrayList<>();
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(GET_PROJECTS_BY_CATEGORY_NAME)) {
			statement.setString(1, categoryName);
			ResultSet set = statement.executeQuery();
			while (set.next()) {
				Project project = new Project();
				fillProject(set, project);
				projects.add(project);
			}
		} catch (SQLException e) {
			e.getStackTrace();
		}
		return projects;
	}
	
	private void fillProject(ResultSet set, Project project) throws SQLException {
		String projectName = set.getString("project_name");
		String description = set.getString("description");
		int neededAmount = set.getInt("all_amount");
		int daysRemain = set.getInt("days_remain");
		String history = set.getString("history");
		String video = set.getString("video");

		project.setName(projectName);
		project.setDescription(description);
		project.setNeededAmount(neededAmount);
		project.setDaysRemain(daysRemain);
		project.setHistory(history);
		project.setVideo(video);
		
		int projectId = set.getInt("id");
		int availableAmount = getAvailableAmount(projectId);
		
		project.setAvailableAmount(availableAmount);
	}

	private int getAvailableAmount(int projectId) {
		int amount = 0;
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(GET_AVAILABLE_AMOUNT_BY_PROJECT_ID)) {
			statement.setInt(1, projectId);
			ResultSet set = statement.executeQuery();
			set.next();
			amount = set.getInt("sum");
		} catch (SQLException e) {
			e.getStackTrace();
		}
		return amount;
	}
}
