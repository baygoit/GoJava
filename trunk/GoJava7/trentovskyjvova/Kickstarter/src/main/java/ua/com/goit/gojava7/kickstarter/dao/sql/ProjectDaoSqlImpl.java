package ua.com.goit.gojava7.kickstarter.dao.sql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.domain.Project;

@Repository
public class ProjectDaoSqlImpl implements ProjectDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Project> getProjects(int categoryId) {

		String sql = "SELECT id, categoryId, name, daysToGo, description, goal, owner, videoUrl FROM project WHERE categoryId = ?";
		return jdbcTemplate.query(sql, new Integer[] { categoryId }, new BeanPropertyRowMapper<Project>(Project.class));
	}

	@Override
	public Project getProject(int userChoise, int categoryId) {
		if (userChoise == 0) {
			return null;
		} else {
			List<Project> projects = getProjects(categoryId);
			return projects.get(userChoise - 1);
		}
	}

	@Override
	public int size(int categoryId) {

		String sql = "SELECT COUNT(*) size FROM project WHERE categoryId = ?";
		return jdbcTemplate.queryForObject(sql, new Integer[] { categoryId }, Integer.class);
	}

	@Override
	public Project getProject(int projectId) {

		String sql = "SELECT id, categoryId, name, daysToGo, description, goal, owner, videoUrl FROM project WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, new Integer[] { projectId },
				new BeanPropertyRowMapper<Project>(Project.class));
	}

}
