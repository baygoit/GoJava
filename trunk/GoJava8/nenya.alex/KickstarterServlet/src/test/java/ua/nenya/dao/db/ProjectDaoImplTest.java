package ua.nenya.dao.db;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import ua.nenya.domain.Category;
import ua.nenya.domain.Project;

@RunWith(MockitoJUnitRunner.class)
public class ProjectDaoImplTest {
	@Mock
	private JdbcTemplate jdbcTemplate;
	@InjectMocks
	private ProjectDaoImpl projectDaoImpl;

	private Category musicCategory;
	private List<Project> projects;
	private Project project;

	@Before
	public void init() {
		projects = new ArrayList<>();
		project = new Project();
		project.setName("New Song");
		projects.add(project);
		musicCategory = new Category();
		musicCategory.setName("Music");
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testGetProjects() throws SQLException {
		when(jdbcTemplate.query(anyString(), new Object[] { anyString() }, Matchers.any(BeanPropertyRowMapper.class)))
				.thenReturn(projects);
		List<Project> testProjects = projectDaoImpl.getProjects("Music");
		assertThat(testProjects.get(0).getName(), is("New Song"));
	}

	@Ignore
	@Test
	public void testGetProjectByName() throws SQLException {
		when(jdbcTemplate.queryForObject(anyString(), eq(new Object[] { "New Song" }),
				eq(new BeanPropertyRowMapper<Project>(Project.class)))).thenReturn(project);
		Project testProject = projectDaoImpl.getProjectByName("New Song");
		assertThat(testProject.getName(), is("New Song"));
	}

}
