package com.anmertrix.dao.sql;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
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

import com.anmertrix.domain.Answer;

@RunWith(MockitoJUnitRunner.class)
public class AnswerDaoSqlTest {
	
	@Mock
	private DataSource dataSource;
	@Mock
	private Connection connection;
	@Mock
    PreparedStatement preparedStatement;
	@Mock
    ResultSet resultSet;
	@InjectMocks
	private AnswerDaoSql answerDaoSql;
	
	@Before
    public void setUp() throws SQLException {
		when(dataSource.getConnection()).thenReturn(connection);
		when(preparedStatement.executeQuery()).thenReturn(resultSet);
		when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
	}
	
	@Test
	public void testGetAnswersByProjectId() throws SQLException {
		when(resultSet.next()).thenReturn(true, false);
		when(resultSet.getInt("id")).thenReturn(1);
		when(resultSet.getString("answer")).thenReturn("test answer");
		when(resultSet.getInt("question_id")).thenReturn(51);
		List<Answer> answers = answerDaoSql.getAnswersByProjectId(1);
		Answer answer = answers.get(0);
		assertThat(answer.getId(), is(1));
		assertThat(answer.getAnswer(), is("test answer"));
		assertThat(answer.getQuestionId(), is(51));
	}

	@Test
	public void testGetAnswersByProjectIdNotFound() throws SQLException {
		List<Answer> answers = answerDaoSql.getAnswersByProjectId(1);
		assertThat(answers.isEmpty(), is(true));
	}
	
	@Test(expected = RuntimeException.class)
	public void testGetAnswersByProjectIdGetConnectionException() throws SQLException {
		when(dataSource.getConnection()).thenThrow(new SQLException());
		try {
			answerDaoSql.getAnswersByProjectId(1);
		} finally {
			verify(dataSource).getConnection();
		}
	}
	
	@Test(expected = RuntimeException.class)
	public void testGetAnswersByQuestionIdCreateStatementException() throws SQLException {
		when(connection.prepareStatement(anyString())).thenThrow(new SQLException());
		try {
			answerDaoSql.getAnswersByProjectId(1);
		} finally {
			verify(dataSource).getConnection();
		}
	}
	
	@Test(expected = RuntimeException.class)
	public void testGetAnswersByProjectIdGetResultSetException() throws SQLException {
		when(preparedStatement.executeQuery()).thenThrow(new SQLException());
		try {
			answerDaoSql.getAnswersByProjectId(1);
		} finally {
			verify(dataSource).getConnection();
		}
	}

}
