package ua.com.goit.gojava7.kickstarter.dao.sql;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import ua.com.goit.gojava7.kickstarter.config.DaoProvider;
import ua.com.goit.gojava7.kickstarter.dao.QuestionDao;
import ua.com.goit.gojava7.kickstarter.dao.sql.QuestionDaoSqlImpl;
import ua.com.goit.gojava7.kickstarter.domain.Question;

public class QuestionDaoSqlImplTest {
	@Mock
	private Connection connection = mock(Connection.class);
	@Mock
	DaoProvider daoProvider = mock(DaoProvider.class);
	@InjectMocks
	private QuestionDao questionDaoMySqlImpl = new QuestionDaoSqlImpl(daoProvider);
	
	@Test
	public void testGetQuestions() throws SQLException {
		PreparedStatement ps = mock(PreparedStatement.class);
		ResultSet rs = mock(ResultSet.class);
		when(daoProvider.open()).thenReturn(connection);
		when(connection.prepareStatement(anyString())).thenReturn(ps);
		when(ps.executeQuery()).thenReturn(rs);
		when(rs.next()).thenReturn(true, false);
		when(rs.getString("questionText")).thenReturn("some question");

		List<Question> questions = questionDaoMySqlImpl.getQuestions(1);

		assertThat(questions.get(0).getQuestionText(), is("some question"));
	}
	
	@Test
	public void testAddQuestion() throws SQLException {
		PreparedStatement ps = mock(PreparedStatement.class);
		when(daoProvider.open()).thenReturn(connection);
		when(connection.prepareStatement(anyString())).thenReturn(ps);
		when(ps.executeUpdate()).thenReturn(1);
		
		questionDaoMySqlImpl.addQuestion(new Question());
		
		verify(ps).executeUpdate();

	}
}
