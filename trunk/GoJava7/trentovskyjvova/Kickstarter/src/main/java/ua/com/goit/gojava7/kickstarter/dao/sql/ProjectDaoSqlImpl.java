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

		String sql = "SELECT p.id, p.categoryId, p.name, p.daysToGo, p.description, "
				+ "p.goal, p.owner, p.videoUrl, SUM(CASE WHEN pledge IS NULL THEN 0 ELSE pledge END) amountPledge "
				+ "FROM project p "
				+ "LEFT JOIN payment ON p.id = payment.projectId "
				+ "WHERE categoryId = ? "
				+ "GROUP BY p.id, p.categoryId, p.name, p.daysToGo, p.description, p.goal, p.owner, p.videoUrl";			
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

		String sql = "SELECT p.id, p.categoryId, p.name, p.daysToGo, p.description, "
				+ "p.goal, p.owner, p.videoUrl, SUM(CASE WHEN pledge IS NULL THEN 0 ELSE pledge END) amountPledge "
				+ "FROM project p "
				+ "LEFT JOIN payment ON p.id = payment.projectId "
				+ "WHERE p.id = ? "
				+ "GROUP BY p.id, p.categoryId, p.name, p.daysToGo, p.description, p.goal, p.owner, p.videoUrl";
		return jdbcTemplate.queryForObject(sql, new Integer[] { projectId },
				new BeanPropertyRowMapper<Project>(Project.class));
	}

}
