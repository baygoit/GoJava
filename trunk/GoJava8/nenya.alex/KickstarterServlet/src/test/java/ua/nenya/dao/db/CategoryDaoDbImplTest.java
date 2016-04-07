package ua.nenya.dao.db;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;

import ua.nenya.dao.CategoryDao;
import ua.nenya.domain.Category;
import ua.nenya.domain.Project;
import ua.nenya.domain.Question;
import ua.nenya.domain.Reward;
import ua.nenya.util.ConnectionManager;


public class CategoryDaoDbImplTest {

	
	private ConnectionManager connectionManager;

	private Category musicCategory;
	private Project newSongProject;
	private List<Project> projects = new ArrayList<>();
	private List<Question> questions = new ArrayList<>();
	private List<Category> categories = new ArrayList<>();
	private List<Reward> rewards = new ArrayList<>();

	@Before
	public void init() {

		connectionManager = mock(ConnectionManager.class);
		
		newSongProject = new Project();
		newSongProject.setName("New Song");
		newSongProject.setDescription("description of new song");
		newSongProject.setNeededAmount(100);
		newSongProject.setAvailableAmount(10);
		newSongProject.setDaysRemain(100);
		newSongProject.setHistory("hystory of new song");
		newSongProject.setVideo("video about new song");

		Question question = new Question();
		question.setName("Who?");
		questions.add(question);
		
		Reward reward = new Reward();
		reward.setName("reward");
		rewards.add(reward);

		newSongProject.setQuestions(questions);
		newSongProject.setRewards(rewards);
		
		Project oldSongProject = new Project();
		oldSongProject.setName("Old song");
		oldSongProject.setDescription("description of old song");
		oldSongProject.setNeededAmount(1100);
		oldSongProject.setAvailableAmount(110);
		oldSongProject.setDaysRemain(1100);

		projects.add(newSongProject);
		projects.add(oldSongProject);

		musicCategory = new Category();
		musicCategory.setName("Music");
		musicCategory.getProjects().add(newSongProject);
		musicCategory.getProjects().add(oldSongProject);

		Category filmCategory = new Category();
		filmCategory.setName("Film");

		categories.add(musicCategory);
		categories.add(filmCategory);
	}

	@Test
	public void testGetCategories() throws SQLException {

		ResultSet rs = mock(ResultSet.class);
		when(rs.next()).thenReturn(true).thenReturn(true).thenReturn(false);
		when(rs.getString("category_name")).thenReturn("Music").thenReturn("Film");
		

		PreparedStatement statement = mock(PreparedStatement.class);
		when(statement.executeQuery()).thenReturn(rs);

		Connection connection = mock(Connection.class);
		when(connection.prepareStatement(anyString())).thenReturn(statement);

		when(connectionManager.getConnection()).thenReturn(connection);

		CategoryDao categoryDao = new CategoryDaoDbImpl(connectionManager);
		List<Category> categoriesFromMethod = categoryDao.getCategories();

		assertThat(categoriesFromMethod.get(0).getName(), is("Music"));
		assertThat(categoriesFromMethod.get(1).getName(), is("Film"));
		verify(connectionManager).getConnection();

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

		when(connectionManager.getConnection()).thenReturn(connection);

		List<Project> projectsFromMethod = new CategoryDaoDbImpl(connectionManager).getProjects(musicCategory.getName());

		assertThat(projectsFromMethod.get(0).getName(), is("New Song") );
		verify(connectionManager, times(3)).getConnection();
	}
	
	@Test
	public void testGetQuestions() throws SQLException {

		ResultSet rs = mock(ResultSet.class);
		when(rs.next()).thenReturn(true).thenReturn(false);
		when(rs.getString("question")).thenReturn("Who?");
		

		PreparedStatement statement = mock(PreparedStatement.class);
		when(statement.executeQuery()).thenReturn(rs);

		Connection connection = mock(Connection.class);
		when(connection.prepareStatement(anyString())).thenReturn(statement);

		when(connectionManager.getConnection()).thenReturn(connection);

		List<Question> questionsFromMethod = new CategoryDaoDbImpl(connectionManager).getQuestions(newSongProject.getName());

		assertThat(questionsFromMethod.get(0).getName(), is("Who?"));
		verify(connectionManager).getConnection();
	}
	
	@Test
	public void testGetRewards() throws SQLException {

		ResultSet rs = mock(ResultSet.class);
		when(rs.next()).thenReturn(true).thenReturn(false);
		when(rs.getString("name")).thenReturn("reward");
		

		PreparedStatement statement = mock(PreparedStatement.class);
		when(statement.executeQuery()).thenReturn(rs);

		Connection connection = mock(Connection.class);
		when(connection.prepareStatement(anyString())).thenReturn(statement);

		when(connectionManager.getConnection()).thenReturn(connection);

		List<Reward> rewardsFromMethod = new CategoryDaoDbImpl(connectionManager).getRewards(newSongProject.getName());

		assertThat(rewardsFromMethod.get(0).getName(), is("reward"));
		verify(connectionManager).getConnection();
	}
	
	@Test
	public void testWriteQuestionInProject() throws SQLException {

		ResultSet rs = mock(ResultSet.class);
				

		PreparedStatement statement = mock(PreparedStatement.class);
		when(statement.executeQuery()).thenReturn(rs);

		Connection connection = mock(Connection.class);
		when(connection.prepareStatement(anyString())).thenReturn(statement);

		when(connectionManager.getConnection()).thenReturn(connection);

		new CategoryDaoDbImpl(connectionManager).writeQuestionInProject("New Song", "Question?");

		verify(connectionManager, times(4)).getConnection();
	}
	
	@Test
	public void testWriteQuestionNullInProject() throws SQLException {

		ResultSet rs = mock(ResultSet.class);
				

		PreparedStatement statement = mock(PreparedStatement.class);
		when(statement.executeQuery()).thenReturn(rs);

		Connection connection = mock(Connection.class);
		when(connection.prepareStatement(anyString())).thenReturn(statement);

		when(connectionManager.getConnection()).thenReturn(connection);

		new CategoryDaoDbImpl(connectionManager).writeQuestionInProject("New Song", null);

		verify(connectionManager).getConnection();
	}
	
	@Test
	public void testWriteQuestionEmptyInProject() throws SQLException {

		ResultSet rs = mock(ResultSet.class);
				

		PreparedStatement statement = mock(PreparedStatement.class);
		when(statement.executeQuery()).thenReturn(rs);

		Connection connection = mock(Connection.class);
		when(connection.prepareStatement(anyString())).thenReturn(statement);

		when(connectionManager.getConnection()).thenReturn(connection);

		new CategoryDaoDbImpl(connectionManager).writeQuestionInProject("New Song", "");

		verify(connectionManager).getConnection();
	}
	
	@Test
	public void testWriteIvestmentInProject() throws SQLException {

		ResultSet rs = mock(ResultSet.class);
		PreparedStatement statement = mock(PreparedStatement.class);
		when(statement.executeQuery()).thenReturn(rs);

		Connection connection = mock(Connection.class);
		when(connection.prepareStatement(anyString())).thenReturn(statement);

		when(connectionManager.getConnection()).thenReturn(connection);

		new CategoryDaoDbImpl(connectionManager).writeIvestmentInProject("New Song", 123);

		verify(connectionManager, times(2)).getConnection();
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

		when(connectionManager.getConnection()).thenReturn(connection);

		Project project = new CategoryDaoDbImpl(connectionManager).getProjectByName("New Song");

		assertThat(project.getName(), is("New Song"));
		verify(connectionManager, times(3)).getConnection();
	}
}
