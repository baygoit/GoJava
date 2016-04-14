package com.anmertrix.dao.sql;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.never;
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

import com.anmertrix.domain.Question;

@RunWith(MockitoJUnitRunner.class)
public class QuestionDaoSqlTest {
	
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
	private QuestionDaoSql questionDaoSql;
	
	@Before
    public void setUp() throws SQLException {
		when(dataSource.getConnection()).thenReturn(connection);
		when(preparedStatement.executeQuery()).thenReturn(resultSet);
		when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
	}
	
	@Test
	public void testGetQuestionsByProjectId() throws SQLException {
		when(resultSet.next()).thenReturn(true, false);
		when(resultSet.getInt("id")).thenReturn(1);
		when(resultSet.getString("question")).thenReturn("test question");
		List<Question> questions = questionDaoSql.getQuestionsByProjectId(1);
		Question question = questions.get(0);
		assertThat(question.getId(), is(1));
		assertThat(question.getQuestion(), is("test question"));
	}

	@Test
	public void testGetQuestionsByProjectIdNotFound() throws SQLException {
		List<Question> questions = questionDaoSql.getQuestionsByProjectId(1);
		assertThat(questions.isEmpty(), is(true));
	}
	
	@Test(expected = RuntimeException.class)
	public void testGetQuestionsByProjectIdGetConnectionException() throws SQLException {
		when(dataSource.getConnection()).thenThrow(new SQLException());
		try {
			questionDaoSql.getQuestionsByProjectId(1);
		} finally {
			verify(dataSource).getConnection();
		}
	}
	
	@Test(expected = RuntimeException.class)
	public void testGetQuestionsByProjectIdCreateStatementException() throws SQLException {
		when(connection.prepareStatement(anyString())).thenThrow(new SQLException());
		try {
			questionDaoSql.getQuestionsByProjectId(1);
		} finally {
			verify(dataSource).getConnection();
		}
	}
	
	@Test(expected = RuntimeException.class)
	public void testGetQuestionsByProjectIdGetResultSetException() throws SQLException {
		when(preparedStatement.executeQuery()).thenThrow(new SQLException());
		try {
			questionDaoSql.getQuestionsByProjectId(1);
		} finally {
			verify(dataSource).getConnection();
		}
	}
	
	@Test
	public void testInsertQuestion() throws SQLException {
		questionDaoSql.insertQuestion(question);
		verify(connection, times(1)).prepareStatement(anyString());
		verify(preparedStatement, times(1)).setString(anyInt(), anyString());
		verify(preparedStatement, times(1)).setInt(anyInt(), anyInt());
		verify(preparedStatement, times(1)).execute();
	}
	
	@Test(expected = RuntimeException.class)
	public void testInsertQuestionGetConnectionException() throws SQLException {
		when(dataSource.getConnection()).thenThrow(new SQLException());
		try {
			questionDaoSql.insertQuestion(question);
		} finally {
			verify(dataSource).getConnection();
			verify(preparedStatement, never()).execute();
		}
	}
	
	@Test(expected = RuntimeException.class)
	public void testInsertQuestionCreateStatementException() throws SQLException {
		when(connection.prepareStatement(anyString())).thenThrow(new SQLException());
		try {
			questionDaoSql.insertQuestion(question);
		} finally {
			verify(dataSource).getConnection();
			verify(preparedStatement, never()).execute();
			verify(connection).close();
		}
	}
	

}
