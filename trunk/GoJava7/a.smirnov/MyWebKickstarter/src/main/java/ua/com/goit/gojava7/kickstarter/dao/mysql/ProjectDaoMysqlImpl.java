package ua.com.goit.gojava7.kickstarter.dao.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import ua.com.goit.gojava7.kickstarter.beans.Project;
import ua.com.goit.gojava7.kickstarter.dao.AbstractDao;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;

public class ProjectDaoMysqlImpl extends AbstractDao implements ProjectDao {

	public void add(Project project) {
		String sql = "INSERT INTO projects (category_id, title, brief_description, full_description, "
				+ "video_link, required_sum, collected_sum, days_left) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		jdbcTemplate.update(sql, new Object[] { project.getCategoryID(), project.getTitle(), project.getBriefDescription(),
				project.getFullDescription(), project.getVideoLink(), project.getRequiredSum(), project.getCollectedSum(),
				project.getDaysLeft() });
	}

	public void remove(Project project) {
		String sql = "DELETE FROM projects WHERE id = ?";
		jdbcTemplate.update(sql, new Object[] { project.getUniqueID() });
	}

	public List<Project> getProjectsFromCategory(int categoryID) {
		System.out.println("Start");
		String sql = "SELECT id, category_id, title, brief_description, full_description, "
				+ "video_link, required_sum, collected_sum, days_left FROM projects WHERE category_id = ?";
		List<Project> projects = jdbcTemplate.query(sql, new Object[] { categoryID }, new ProjectRowMapper());
		
		if (projects.isEmpty()) {
			System.out.println("LIST IS EMPTY");
		}
		return projects;
		
	}

	public Project getProjectById(int projectId) {
		String sql = "SELECT id, category_id, title, brief_description, full_description, "
				+ "video_link, required_sum, collected_sum, days_left FROM projects WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { projectId }, new ProjectRowMapper());
	}

	public class ProjectRowMapper implements RowMapper<Project> {

		@Override
		public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
			Project project = new Project();
			project.setUniqueID(rs.getInt("id"));
			project.setCategoryID(rs.getInt("category_id"));
			project.setTitle(rs.getString("title"));
			project.setBriefDescription(rs.getString("brief_description"));
			project.setFullDescription(rs.getString("full_description"));
			project.setVideoLink(rs.getString("video_link"));
			project.setRequiredSum(rs.getInt("required_sum"));
			project.setCollectedSum(rs.getInt("collected_sum"));
			project.setDaysLeft(rs.getInt("days_left"));
			return project;
		}
	}
}
