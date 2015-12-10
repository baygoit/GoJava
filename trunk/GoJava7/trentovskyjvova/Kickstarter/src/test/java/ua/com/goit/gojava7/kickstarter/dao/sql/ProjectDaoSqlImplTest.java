package ua.com.goit.gojava7.kickstarter.dao.sql;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.dao.sql.ProjectDaoSqlImpl;
import ua.com.goit.gojava7.kickstarter.domain.Project;

public class ProjectDaoSqlImplTest {
	@Mock
	private Connection connection = mock(Connection.class);
	@Mock
	DataSource dataSource = mock(DataSource.class);
	@InjectMocks
	private ProjectDao projectDaoMySqlImpl = new ProjectDaoSqlImpl(dataSource);
	
	@Test
	public void testGetProject() throws SQLException {
		PreparedStatement ps = mock(PreparedStatement.class);
		ResultSet rs = mock(ResultSet.class);
		when(dataSource.getConnection()).thenReturn(connection);
		when(connection.prepareStatement(anyString())).thenReturn(ps);
		when(ps.executeQuery()).thenReturn(rs);
		when(rs.next()).thenReturn(true, false);
		when(rs.getString("name")).thenReturn("some project name");
		
		Project project = projectDaoMySqlImpl.getProject(1, 1);

		assertThat(project.getName(), is("some project name"));
	}
	
	@Test
	public void testGetProjects() throws SQLException {
		PreparedStatement ps = mock(PreparedStatement.class);
		ResultSet rs = mock(ResultSet.class);
		when(dataSource.getConnection()).thenReturn(connection);
		when(connection.prepareStatement(anyString())).thenReturn(ps);
		when(ps.executeQuery()).thenReturn(rs);
		when(rs.next()).thenReturn(true, false);
		when(rs.getString("name")).thenReturn("some project name");

		List<Project> projects = projectDaoMySqlImpl.getProjects(1);

		assertThat(projects.get(0).getName(), is("some project name"));
	}
	
	@Test
	public void testSize() throws SQLException {
		PreparedStatement ps = mock(PreparedStatement.class);
		ResultSet rs = mock(ResultSet.class);
		when(dataSource.getConnection()).thenReturn(connection);
		when(connection.prepareStatement(anyString())).thenReturn(ps);
		when(ps.executeQuery()).thenReturn(rs);
		when(rs.next()).thenReturn(true, false);
		when(rs.getInt("size")).thenReturn(1);

		int size = projectDaoMySqlImpl.size(1);

		assertThat(size, is(1));
	}
	
	@Test
	public void testGetProjectById() throws SQLException {
		PreparedStatement ps = mock(PreparedStatement.class);
		ResultSet rs = mock(ResultSet.class);
		when(dataSource.getConnection()).thenReturn(connection);
		when(connection.prepareStatement(anyString())).thenReturn(ps);
		when(ps.executeQuery()).thenReturn(rs);
		when(rs.next()).thenReturn(true, false);
		when(rs.getString("name")).thenReturn("some project name");
		
		Project project = projectDaoMySqlImpl.getProject(12);

		assertThat(project.getId(), is(12));
	}
}
