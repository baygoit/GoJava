package ua.home.kickstarter.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ua.home.kickstarter.content.Project;

public class ProjectsDao {
	private final Connection connection;

	public List<Project> getProjectsByCategoryId(int categoryId) throws SQLException {
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
	}

	public Project getProjectsByIdAndCategoryId(int categoryId, int projectId) throws SQLException {
		Project project = new Project();
		String sql = "SELECT * FROM projects WHERE category_id = ? and id = ?";
		PreparedStatement stm = connection.prepareStatement(sql);
		stm.setInt(1, categoryId);
		stm.setInt(2, projectId);
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
	}

	public void updateProject(int projectId, String columnName, int amount) throws SQLException {
		String sql = "UPDATE projects SET " + columnName + " = ? WHERE id = ?";
		PreparedStatement stm = connection.prepareStatement(sql);
		stm.setInt(1, amount);
		stm.setInt(2, projectId);
		stm.executeUpdate();
	}

	public long projectSizeByCategoryId(int categoryId) throws SQLException {
		long count = 0;
		String sql = "SELECT COUNT(*) AS count FROM projects WHERE category_id = ?;";
		PreparedStatement stm = connection.prepareStatement(sql);
		stm.setInt(1, categoryId);
		ResultSet rs = stm.executeQuery();
		while (rs.next()) {
			count = rs.getLong("count");
		}
		return count;
	}

	public ProjectsDao(Connection connection) {
		this.connection = connection;
	}
}
