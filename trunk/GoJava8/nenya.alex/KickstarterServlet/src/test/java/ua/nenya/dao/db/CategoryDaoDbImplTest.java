package ua.nenya.dao.db;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;

import ua.nenya.project.Category;
import ua.nenya.project.Project;
import ua.nenya.project.Question;
import ua.nenya.project.Quote;
import ua.nenya.project.Reward;
import ua.nenya.util.ConnectionManager;

@RunWith(MockitoJUnitRunner.class)
public class CategoryDaoDbImplTest {

	@Mock
	private ConnectionManager connectionManager;

	@Mock
	private Quote quote;

	@InjectMocks
	private QuoteDaoDbImpl quoteDao;

	private Category musicCategory;
	private Project newSongProject;
	private List<Project> projects = new ArrayList<>();
	private List<Question> questions = new ArrayList<>();
	private List<Category> categories = new ArrayList<>();
	private List<Reward> rewards = new ArrayList<>();

	@Before
	public void init() {

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
	public void testInitCategories() throws SQLException {

		ResultSet rs = mock(ResultSet.class);
		when(rs.next()).thenReturn(true).thenReturn(true).thenReturn(false);
		when(rs.getString("category_name")).thenReturn("Music").thenReturn("Film");
		

		Statement statement = mock(Statement.class);
		when(statement.executeQuery(anyString())).thenReturn(rs);

		Connection connection = mock(Connection.class);
		when(connection.createStatement()).thenReturn(statement);

		when(connectionManager.getConnection()).thenReturn(connection);

		List<Category> categoriesFromMethod = new CategoryDaoDbImpl(connectionManager).getCategories();

		assertEquals(categories.get(0).getName(), categoriesFromMethod.get(0).getName());
		assertEquals(categories.get(1).getName(), categoriesFromMethod.get(1).getName());
		verify(connectionManager).getConnection();

	}

	@Test
	public void testInitProjects() throws SQLException {

		ResultSet rs = mock(ResultSet.class);
		when(rs.next()).thenReturn(true).thenReturn(false);
		when(rs.getString("project_name")).thenReturn("New Song");
		

		Statement statement = mock(Statement.class);
		when(statement.executeQuery(anyString())).thenReturn(rs);

		Connection connection = mock(Connection.class);
		when(connection.createStatement()).thenReturn(statement);

		when(connectionManager.getConnection()).thenReturn(connection);

		List<Project> projectsFromMethod = new CategoryDaoDbImpl(connectionManager).initProjects(musicCategory);

		assertEquals(projects.get(0).getName(), projectsFromMethod.get(0).getName());
		verify(connectionManager, times(2)).getConnection();
	}
	
	@Test
	public void testInitQuestions() throws SQLException {

		ResultSet rs = mock(ResultSet.class);
		when(rs.next()).thenReturn(true).thenReturn(false);
		when(rs.getString("question")).thenReturn("Who?");
		

		Statement statement = mock(Statement.class);
		when(statement.executeQuery(anyString())).thenReturn(rs);

		Connection connection = mock(Connection.class);
		when(connection.createStatement()).thenReturn(statement);

		when(connectionManager.getConnection()).thenReturn(connection);

		List<Question> questionsFromMethod = new CategoryDaoDbImpl(connectionManager).initQuestions(newSongProject);

		assertEquals(questions.get(0).getName(), questionsFromMethod.get(0).getName());
		verify(connectionManager).getConnection();
	}
	
	@Test
	public void testInitRewards() throws SQLException {

		ResultSet rs = mock(ResultSet.class);
		when(rs.next()).thenReturn(true).thenReturn(false);
		when(rs.getString("name")).thenReturn("reward");
		

		Statement statement = mock(Statement.class);
		when(statement.executeQuery(anyString())).thenReturn(rs);

		Connection connection = mock(Connection.class);
		when(connection.createStatement()).thenReturn(statement);

		when(connectionManager.getConnection()).thenReturn(connection);

		List<Reward> rewardsFromMethod = new CategoryDaoDbImpl(connectionManager).initRewards(newSongProject);

		assertEquals(rewards.get(0).getName(), rewardsFromMethod.get(1).getName());
		verify(connectionManager).getConnection();
	}
	
	@Test
	public void testWriteQuestionInProject() throws SQLException {

		ResultSet rs = mock(ResultSet.class);
				

		Statement statement = mock(Statement.class);
		when(statement.executeQuery(anyString())).thenReturn(rs);

		Connection connection = mock(Connection.class);
		when(connection.createStatement()).thenReturn(statement);

		when(connectionManager.getConnection()).thenReturn(connection);

		new CategoryDaoDbImpl(connectionManager).writeQuestionInProject(newSongProject, new Question());

		verify(connectionManager, times(2)).getConnection();
	}
	
	@Test
	public void testWriteIvestmentInProject() throws SQLException {

		ResultSet rs = mock(ResultSet.class);
				

		Statement statement = mock(Statement.class);
		when(statement.executeQuery(anyString())).thenReturn(rs);

		Connection connection = mock(Connection.class);
		when(connection.createStatement()).thenReturn(statement);

		when(connectionManager.getConnection()).thenReturn(connection);

		new CategoryDaoDbImpl(connectionManager).writeIvestmentInProject(newSongProject, 123);

		verify(connectionManager).getConnection();
	}
}
