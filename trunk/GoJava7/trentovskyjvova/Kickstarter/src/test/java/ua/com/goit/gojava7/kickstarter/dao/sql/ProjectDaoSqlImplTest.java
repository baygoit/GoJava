package ua.com.goit.gojava7.kickstarter.dao.sql;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.contains;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.dao.sql.ProjectDaoSqlImpl;
import ua.com.goit.gojava7.kickstarter.domain.Project;

@RunWith(MockitoJUnitRunner.class)
public class ProjectDaoSqlImplTest {
	@Mock
	private JdbcTemplate jdbcTemplate;
	@InjectMocks
	private ProjectDao projectDaoMySqlImpl = new ProjectDaoSqlImpl();

	@Test
	public void testGetProjects() {

		projectDaoMySqlImpl.getProjects(1);
		verify(jdbcTemplate).query(contains("project WHERE categoryId = ?"), any(Integer[].class),
				any(BeanPropertyRowMapper.class));
	}

	@Test
	public void testGetProject() {

		Project project = new Project("Project1", 1);
		List<Project> projects = new ArrayList<>();
		projects.add(project);

		when(jdbcTemplate.query(contains("project WHERE categoryId = ?"), any(Integer[].class),
				any(BeanPropertyRowMapper.class))).thenReturn(projects);

		assertThat(projectDaoMySqlImpl.getProject(1, 1), is(project));

	}

	@Test
	public void testSize() {

		when(jdbcTemplate.queryForObject(contains("project WHERE categoryId = ?"), any(Integer[].class), eq(Integer.class))).thenReturn(2);
		int i = projectDaoMySqlImpl.size(1);
		assertThat(i, is(2));
	}

	@Test
	public void testGetProjectById() {

		projectDaoMySqlImpl.getProject(12);
		verify(jdbcTemplate).queryForObject(contains("project WHERE id = ?"), any(Integer[].class),
				any(BeanPropertyRowMapper.class));
	}
}
