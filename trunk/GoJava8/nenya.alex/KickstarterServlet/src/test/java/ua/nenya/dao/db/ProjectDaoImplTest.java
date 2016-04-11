package ua.nenya.dao.db;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ua.nenya.domain.Category;
import ua.nenya.domain.Project;

@RunWith(MockitoJUnitRunner.class)
public class ProjectDaoImplTest {
	@Mock
	private DataSource dataSource;
	@InjectMocks
	private ProjectDaoImpl projectDaoImpl; 

	private Category musicCategory;
	

	@Before
	public void init() {

		Project newSongProject;
		newSongProject = new Project();
		newSongProject.setName("New Song");
		musicCategory = new Category();
		musicCategory.setName("Music");

	}

	

	@Test
	public void testGetProjects() throws SQLException {

		ResultSet rs = mock(ResultSet.class);
		when(rs.next()).thenReturn(true).thenReturn(false);
		when(rs.getString("project_name")).thenReturn("New Song");
		

		PreparedStatement statement = mock(PreparedStatement.class);
		when(statement.executeQuery()).thenReturn(rs);

		Connection connection = mock(Connection.class);
		when(connection.prepareStatement(anyString())).thenReturn(statement);

		when(dataSource.getConnection()).thenReturn(connection);

		List<Project> projectsFromMethod = projectDaoImpl.getProjects(musicCategory.getName());

		assertThat(projectsFromMethod.get(0).getName(), is("New Song") );
		verify(dataSource, times(2)).getConnection();
	}
	
	
	
	@Test
	public void testGetProjectByName() throws SQLException {

		ResultSet rs = mock(ResultSet.class);
		when(rs.next()).thenReturn(true).thenReturn(false);
		when(rs.getString("project_name")).thenReturn("New Song");
		

		PreparedStatement statement = mock(PreparedStatement.class);
		when(statement.executeQuery()).thenReturn(rs);

		Connection connection = mock(Connection.class);
		when(connection.prepareStatement(anyString())).thenReturn(statement);

		when(dataSource.getConnection()).thenReturn(connection);

		Project project = projectDaoImpl.getProjectByName("New Song");

		assertThat(project.getName(), is("New Song"));
		verify(dataSource, times(2)).getConnection();
	}
	
}
