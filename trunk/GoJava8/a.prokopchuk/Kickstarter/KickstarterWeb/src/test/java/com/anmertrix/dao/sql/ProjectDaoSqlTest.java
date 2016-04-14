package com.anmertrix.dao.sql;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.contains;
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

import com.anmertrix.domain.Project;
import com.anmertrix.domain.Question;

@RunWith(MockitoJUnitRunner.class)
public class ProjectDaoSqlTest {
	
	@Mock
	private DataSource dataSource;
	@Mock
	private Connection connection;
	@Mock
    PreparedStatement preparedStatement;
	@Mock
    ResultSet resultSet;
	@Mock
    Question question;
	@InjectMocks
	private ProjectDaoSql projectDaoSql;
	
	@Before
    public void setUp() throws SQLException {
		when(dataSource.getConnection()).thenReturn(connection);
		when(preparedStatement.executeQuery()).thenReturn(resultSet);
		when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
	}
	
	@Test
	public void testGetProjectsByCategoryId() throws SQLException {
		when(resultSet.next()).thenReturn(true, false);
		when(resultSet.getInt("id")).thenReturn(1);
		when(resultSet.getString("name")).thenReturn("test name");
		List<Project> projects = projectDaoSql.getProjectsByCategoryId(1);
		Project project = projects.get(0);
		assertThat(project.getId(), is(1));
		assertThat(project.getName(), is("test name"));
		
		verify(preparedStatement).setInt(1, 1);
		verify(connection).prepareStatement(contains("SELECT id, name FROM project WHERE category_id=?"));
	}

	@Test
	public void testGetProjectsNotFound() throws SQLException {
		List<Project> projects = projectDaoSql.getProjectsByCategoryId(1);
		assertThat(projects.isEmpty(), is(true));
	}
	
	@Test(expected = RuntimeException.class)
	public void testGetProjectsGetConnectionException() throws SQLException {
		when(dataSource.getConnection()).thenThrow(new SQLException());
		try {
			projectDaoSql.getProjectsByCategoryId(1);
		} finally {
			verify(dataSource).getConnection();
		}
	}
	
	@Test(expected = RuntimeException.class)
	public void testGetProjectsCreateStatementException() throws SQLException {
		when(connection.prepareStatement(anyString())).thenThrow(new SQLException());
		try {
			projectDaoSql.getProjectsByCategoryId(1);
		} finally {
			verify(dataSource).getConnection();
		}
	}
	
	@Test(expected = RuntimeException.class)
	public void testGetProjectsGetResultSetException() throws SQLException {
		when(preparedStatement.executeQuery()).thenThrow(new SQLException());
		try {
			projectDaoSql.getProjectsByCategoryId(1);
		} finally {
			verify(dataSource).getConnection();
		}
	}
	
	@Test
	public void testProjectExists() throws SQLException {
		when(resultSet.next()).thenReturn(true, false);
		projectDaoSql.projectExists(1);
	}
	
	@Test
	public void testProjectExistsNotFound() throws SQLException {
		when(resultSet.next()).thenReturn(true, false);
		assertThat(projectDaoSql.projectExists(1), is(true));
		assertThat(projectDaoSql.projectExists(1), is(false));
	}
	
	@Test(expected = RuntimeException.class)
	public void testProjectExistsGetConnectionException() throws SQLException {
		when(dataSource.getConnection()).thenThrow(new SQLException());
		try {
			projectDaoSql.projectExists(1);
		} finally {
			verify(dataSource).getConnection();
		}
	}
	
	@Test(expected = RuntimeException.class)
	public void testProjectExistsCreateStatementException() throws SQLException {
		when(connection.prepareStatement(anyString())).thenThrow(new SQLException());
		try {
			projectDaoSql.projectExists(1);
		} finally {
			verify(dataSource).getConnection();
		}
	}
	
	@Test(expected = RuntimeException.class)
	public void testProjectExistsGetResultSetException() throws SQLException {
		when(preparedStatement.executeQuery()).thenThrow(new SQLException());
		try {
			projectDaoSql.projectExists(1);
		} finally {
			verify(dataSource).getConnection();
		}
	}
	
	@Test
	public void testProjectById() throws SQLException {
		when(resultSet.next()).thenReturn(true, false);
		when(resultSet.getInt("id")).thenReturn(1);
		when(resultSet.getString("name")).thenReturn("test name");
		when(resultSet.getString("description")).thenReturn("test description");
		when(resultSet.getInt("required_budget")).thenReturn(10);
		when(resultSet.getInt("days_left")).thenReturn(5);
		when(resultSet.getString("history")).thenReturn("test history");
		when(resultSet.getString("url")).thenReturn("test url");
		when(resultSet.getInt("sum_amount")).thenReturn(100);
		
		Project project = projectDaoSql.getProjectById(1);
		
		assertThat(project.getId(), is(1));
		assertThat(project.getName(), is("test name"));
		assertThat(project.getDescription(), is("test description"));
		assertThat(project.getRequiredBudget(), is(10));
		assertThat(project.getDaysLeft(), is(5));
		assertThat(project.getHistory(), is("test history"));
		assertThat(project.getUrl(), is("test url"));
		assertThat(project.getGatheredBudget(), is(100));
	}
	
	@Test(expected = RuntimeException.class)
	public void testProjectNotFound() throws SQLException {
		when(resultSet.next()).thenReturn(false);
		projectDaoSql.getProjectById(1);
	}
	
	@Test(expected = RuntimeException.class)
	public void testProjectGetConnectionException() throws SQLException {
		when(dataSource.getConnection()).thenThrow(new SQLException());
		try {
			projectDaoSql.getProjectById(1);
		} finally {
			verify(dataSource).getConnection();
		}
	}
	
	@Test(expected = RuntimeException.class)
	public void testProjectCreateStatementException() throws SQLException {
		when(connection.prepareStatement(anyString())).thenThrow(new SQLException());
		try {
			projectDaoSql.getProjectById(1);
		} finally {
			verify(dataSource).getConnection();
		}
	}
	
	@Test(expected = RuntimeException.class)
	public void testProjectGetResultSetException() throws SQLException {
		when(preparedStatement.executeQuery()).thenThrow(new SQLException());
		try {
			projectDaoSql.getProjectById(1);
		} finally {
			verify(dataSource).getConnection();
		}
	}
	
	
	
}
