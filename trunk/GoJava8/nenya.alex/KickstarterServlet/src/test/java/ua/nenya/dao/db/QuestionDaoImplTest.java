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
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ua.nenya.domain.Project;
import ua.nenya.domain.Question;

@RunWith(MockitoJUnitRunner.class)
public class QuestionDaoImplTest {

	@Mock
	private DataSource dataSource;
	@InjectMocks
	private QuestionDaoImpl questionDaoImpl; 

	private Project newSongProject;
	

	@Before
	public void init() {

		
		List<Question> questions = new ArrayList<>();
		
		
		newSongProject = new Project();
		newSongProject.setName("New Song");
		

		Question question = new Question();
		question.setName("Who?");
		questions.add(question);
		
		
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

		when(dataSource.getConnection()).thenReturn(connection);

		List<Question> questionsFromMethod = questionDaoImpl.getQuestions(newSongProject.getName());

		assertThat(questionsFromMethod.get(0).getName(), is("Who?"));
		verify(dataSource).getConnection();
	}
	
	
	@Test
	public void testWriteQuestionInProject() throws SQLException {

		ResultSet rs = mock(ResultSet.class);
				

		PreparedStatement statement = mock(PreparedStatement.class);
		when(statement.executeQuery()).thenReturn(rs);

		Connection connection = mock(Connection.class);
		when(connection.prepareStatement(anyString())).thenReturn(statement);

		when(dataSource.getConnection()).thenReturn(connection);

		questionDaoImpl.writeQuestionInProject("New Song", "Question?");

		verify(dataSource, times(4)).getConnection();
	}
	
	@Test
	public void testWriteQuestionNullInProject() throws SQLException {

		ResultSet rs = mock(ResultSet.class);
				

		PreparedStatement statement = mock(PreparedStatement.class);
		when(statement.executeQuery()).thenReturn(rs);

		Connection connection = mock(Connection.class);
		when(connection.prepareStatement(anyString())).thenReturn(statement);

		when(dataSource.getConnection()).thenReturn(connection);

		questionDaoImpl.writeQuestionInProject("New Song", null);

		verify(dataSource).getConnection();
	}
	
	@Test
	public void testWriteQuestionEmptyInProject() throws SQLException {

		ResultSet rs = mock(ResultSet.class);
				

		PreparedStatement statement = mock(PreparedStatement.class);
		when(statement.executeQuery()).thenReturn(rs);

		Connection connection = mock(Connection.class);
		when(connection.prepareStatement(anyString())).thenReturn(statement);

		when(dataSource.getConnection()).thenReturn(connection);

		questionDaoImpl.writeQuestionInProject("New Song", "");

		verify(dataSource).getConnection();
	}
	
}
