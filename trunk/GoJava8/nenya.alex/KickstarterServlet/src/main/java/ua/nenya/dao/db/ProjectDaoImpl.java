package ua.nenya.dao.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ua.nenya.dao.ProjectDao;
import ua.nenya.domain.Project;

@Repository
public class ProjectDaoImpl implements ProjectDao {

	private static final String GET_PROJECTS_BY_CATEGORY_NAME = "SELECT project.id AS id, project.name AS name, "
			+ "description, needed_amount, project.sum AS available_amount, days_remain, history, video FROM categories INNER JOIN "
			+ "(SELECT description, needed_amount, days_remain, history, video, "
			+ "Projects.id, Projects.category_id, Projects.name, SUM(Payments.amount) AS sum "
			+ "FROM Projects INNER JOIN Payments ON Projects.id = Payments.project_id GROUP BY Projects.id)"
			+ " AS project ON categories.id = project.category_id WHERE categories.name =? ORDER BY name";
	
	private static final String GET_PROJECT_BY_NAME = "SELECT Projects.id, Projects.name, description, needed_amount, days_remain, "
			+ "history, video, SUM(Payments.amount) AS available_amount FROM Projects INNER JOIN Payments "
			+ "ON Projects.id = Payments.project_id GROUP BY Projects.id HAVING Projects.name = ?";

	private static final String GET_COUNT_PROJECT_BY_NAME = "SELECT COUNT(name) FROM Projects WHERE name = ?";


	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Project> getProjects(String categoryName) {
		return jdbcTemplate.query(GET_PROJECTS_BY_CATEGORY_NAME, new Object[] { categoryName },
				new BeanPropertyRowMapper<Project>(Project.class));
	}

	@Override
	public Project getProjectByName(String projectName) {
		return jdbcTemplate.queryForObject(GET_PROJECT_BY_NAME, new Object[] { projectName },
				new BeanPropertyRowMapper<Project>(Project.class));
	}

	@Override
	public boolean isProjectExist(String projectName) {
		return jdbcTemplate.queryForObject(GET_COUNT_PROJECT_BY_NAME, new Object[] { projectName }, Integer.class) == 1;
	}
	

}
