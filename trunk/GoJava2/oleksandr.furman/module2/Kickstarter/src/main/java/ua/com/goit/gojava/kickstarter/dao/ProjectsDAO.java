package ua.com.goit.gojava.kickstarter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ua.com.goit.gojava.kickstarter.Project;

@Component
public class ProjectsDAO extends AbstractDAO {

	public List<Project> getProjectsByCategoryId(int categoryId) {
		try (Connection connection = getConnection()) {
			String sql = "SELECT * FROM projects WHERE category_id = ? ORDER BY id";
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setInt(1, categoryId);
			ResultSet rs = stm.executeQuery();
			List<Project> list = new ArrayList<Project>();
			while (rs.next()) {
				Project project = new Project();
				project.setId(rs.getInt("id"));
				project.setName(rs.getString("name"));
				project.setDescription(rs.getString("description"));
				project.setGoal(rs.getInt("goal"));
				project.setDaysLeft(rs.getInt("days_left"));
				project.setPledged(rs.getInt("pledged"));
				list.add(project);
			}
			return list;
		} catch (SQLException e) {
			throw new RuntimeException("Что-то не так с запросом", e);
		}
	}

	public Project getProjectById(int projectId) {
		try (Connection connection = getConnection()) {
			Project project = new Project();
			String sql = "SELECT * FROM projects WHERE id = ?";
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setInt(1, projectId);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				project.setId(rs.getInt("id"));
				project.setName(rs.getString("name"));
				project.setDescription(rs.getString("description"));
				project.setGoal(rs.getInt("goal"));
				project.setDaysLeft(rs.getInt("days_left"));
				project.setPledged(rs.getInt("pledged"));
				project.setLinksToVideo(rs.getString("links_to_video"));
				project.setHistory(rs.getString("history"));
				project.setQuestionAnswers(rs.getString("question_answers"));
			}
			return project;
		} catch (SQLException e) {
			throw new RuntimeException("Что-то не так с запросом", e);
		}
	}

	public void updateProject(int projectId, String columnName, int amount) {
		try (Connection connection = getConnection()) {
			String sql = "UPDATE projects SET " + columnName + " = ? WHERE id = ?";
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setInt(1, amount);
			stm.setInt(2, projectId);
			stm.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException("Что-то не так с запросом", e);
		}
	}
}
