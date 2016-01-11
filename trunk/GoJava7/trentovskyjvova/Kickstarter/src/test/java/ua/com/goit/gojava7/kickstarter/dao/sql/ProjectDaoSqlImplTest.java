package ua.com.goit.gojava7.kickstarter.dao.sql;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.verify;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;

@RunWith(MockitoJUnitRunner.class)
public class ProjectDaoSqlImplTest {
	@Mock
	private JdbcTemplate jdbcTemplate;
	@InjectMocks
	private ProjectDao projectDaoMySqlImpl = new ProjectDaoSqlImpl();

	@Test
	@Ignore
	public void testGetProjects() {

		projectDaoMySqlImpl.getProjects(1);
		verify(jdbcTemplate).query(contains("WHERE categoryId = ?"), any(Integer[].class),
				any(BeanPropertyRowMapper.class));
	}

	@Test
	@Ignore
	public void testGetProjectById() {

		projectDaoMySqlImpl.getProject(12);
		verify(jdbcTemplate).queryForObject(contains("id = ?"), any(Integer[].class),
				any(BeanPropertyRowMapper.class));
	}
}
