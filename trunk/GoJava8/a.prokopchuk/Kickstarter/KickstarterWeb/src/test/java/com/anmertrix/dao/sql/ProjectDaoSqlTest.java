package com.anmertrix.dao.sql;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.contains;
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

import com.anmertrix.domain.Answer;
import com.anmertrix.domain.Payment;
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
	@Mock
	Payment payment;
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
	public void testGetProductsNotFound() throws SQLException {
		List<Project> projects = projectDaoSql.getProjectsByCategoryId(1);
		assertThat(projects.isEmpty(), is(true));
	}
	
	@Test(expected = RuntimeException.class)
	public void testGetProductsGetConnectionException() throws SQLException {
		when(dataSource.getConnection()).thenThrow(new SQLException());
		try {
			projectDaoSql.getProjectsByCategoryId(1);
		} finally {
			verify(dataSource).getConnection();
		}
	}
	
	@Test(expected = RuntimeException.class)
	public void testGetProductsCreateStatementException() throws SQLException {
		when(connection.prepareStatement(anyString())).thenThrow(new SQLException());
		try {
			projectDaoSql.getProjectsByCategoryId(1);
		} finally {
			verify(dataSource).getConnection();
		}
	}
	
	@Test(expected = RuntimeException.class)
	public void testGetProductsGetResultSetException() throws SQLException {
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
	
	@Test(expected = RuntimeException.class)
	public void testProjectExistsNotFound() throws SQLException {
		when(resultSet.next()).thenReturn(false);
		projectDaoSql.projectExists(1);
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
	
	@Test
	public void testGetQuestionsByProjectId() throws SQLException {
		when(resultSet.next()).thenReturn(true, false);
		when(resultSet.getInt("id")).thenReturn(1);
		when(resultSet.getString("question")).thenReturn("test question");
		List<Question> questions = projectDaoSql.getQuestionsByProjectId(1);
		Question question = questions.get(0);
		assertThat(question.getId(), is(1));
		assertThat(question.getQuestion(), is("test question"));
	}

	@Test
	public void testGetQuestionsByProjectIdNotFound() throws SQLException {
		List<Question> questions = projectDaoSql.getQuestionsByProjectId(1);
		assertThat(questions.isEmpty(), is(true));
	}
	
	@Test(expected = RuntimeException.class)
	public void testGetQuestionsByProjectIdGetConnectionException() throws SQLException {
		when(dataSource.getConnection()).thenThrow(new SQLException());
		try {
			projectDaoSql.getQuestionsByProjectId(1);
		} finally {
			verify(dataSource).getConnection();
		}
	}
	
	@Test(expected = RuntimeException.class)
	public void testGetQuestionsByProjectIdCreateStatementException() throws SQLException {
		when(connection.prepareStatement(anyString())).thenThrow(new SQLException());
		try {
			projectDaoSql.getQuestionsByProjectId(1);
		} finally {
			verify(dataSource).getConnection();
		}
	}
	
	@Test(expected = RuntimeException.class)
	public void testGetQuestionsByProjectIdGetResultSetException() throws SQLException {
		when(preparedStatement.executeQuery()).thenThrow(new SQLException());
		try {
			projectDaoSql.getQuestionsByProjectId(1);
		} finally {
			verify(dataSource).getConnection();
		}
	}
	
	@Test
	public void testGetAnswersByQuestionId() throws SQLException {
		when(resultSet.next()).thenReturn(true, false);
		when(resultSet.getInt("id")).thenReturn(1);
		when(resultSet.getString("answer")).thenReturn("test answer");
		List<Answer> answers = projectDaoSql.getAnswersByQuestionId(1);
		Answer answer = answers.get(0);
		assertThat(answer.getId(), is(1));
		assertThat(answer.getAnswer(), is("test answer"));
	}

	@Test
	public void testGetAnswersByQuestionIdNotFound() throws SQLException {
		List<Answer> answers = projectDaoSql.getAnswersByQuestionId(1);
		assertThat(answers.isEmpty(), is(true));
	}
	
	@Test(expected = RuntimeException.class)
	public void testGetAnswersByQuestionIdGetConnectionException() throws SQLException {
		when(dataSource.getConnection()).thenThrow(new SQLException());
		try {
			projectDaoSql.getAnswersByQuestionId(1);
		} finally {
			verify(dataSource).getConnection();
		}
	}
	
	@Test(expected = RuntimeException.class)
	public void testGetAnswersByQuestionIdCreateStatementException() throws SQLException {
		when(connection.prepareStatement(anyString())).thenThrow(new SQLException());
		try {
			projectDaoSql.getAnswersByQuestionId(1);
		} finally {
			verify(dataSource).getConnection();
		}
	}
	
	@Test(expected = RuntimeException.class)
	public void testGetAnswersByQuestionIdGetResultSetException() throws SQLException {
		when(preparedStatement.executeQuery()).thenThrow(new SQLException());
		try {
			projectDaoSql.getAnswersByQuestionId(1);
		} finally {
			verify(dataSource).getConnection();
		}
	}
	
	@Test
	public void testGetPaymentsByProjectId() throws SQLException {
		when(resultSet.next()).thenReturn(true, false);
		when(resultSet.getInt("id")).thenReturn(1);
		when(resultSet.getString("cardholder_name")).thenReturn("test cardholder name");
		when(resultSet.getInt("amount")).thenReturn(100);
		List<Payment> payments = projectDaoSql.getPaymentsByProjectId(1);
		Payment payment = payments.get(0);
		assertThat(payment.getId(), is(1));
		assertThat(payment.getCardholderName(), is("test cardholder name"));
		assertThat(payment.getAmount(), is(100));
	}

	@Test
	public void testGetPaymentsByProjectIdNotFound() throws SQLException {
		List<Payment> payments = projectDaoSql.getPaymentsByProjectId(1);
		assertThat(payments.isEmpty(), is(true));
	}
	
	@Test(expected = RuntimeException.class)
	public void testGetPaymentsByProjectIdGetConnectionException() throws SQLException {
		when(dataSource.getConnection()).thenThrow(new SQLException());
		try {
			projectDaoSql.getPaymentsByProjectId(1);
		} finally {
			verify(dataSource).getConnection();
		}
	}
	
	@Test(expected = RuntimeException.class)
	public void testGetPaymentsByProjectIdCreateStatementException() throws SQLException {
		when(connection.prepareStatement(anyString())).thenThrow(new SQLException());
		try {
			projectDaoSql.getPaymentsByProjectId(1);
		} finally {
			verify(dataSource).getConnection();
		}
	}
	
	@Test(expected = RuntimeException.class)
	public void testGetPaymentsByProjectIdGetResultSetException() throws SQLException {
		when(preparedStatement.executeQuery()).thenThrow(new SQLException());
		try {
			projectDaoSql.getPaymentsByProjectId(1);
		} finally {
			verify(dataSource).getConnection();
		}
	}
	
	@Test
	public void testInsertQuestion() throws SQLException {
		projectDaoSql.insertQuestion(question);

		verify(connection, times(1)).prepareStatement(anyString());
		verify(preparedStatement, times(1)).setString(anyInt(), anyString());
		verify(preparedStatement, times(1)).setInt(anyInt(), anyInt());
		verify(preparedStatement, times(1)).execute();
		
	}
	
	@Test(expected = RuntimeException.class)
	public void testInsertQuestionGetConnectionException() throws SQLException {
		when(dataSource.getConnection()).thenThrow(new SQLException());
		try {
			projectDaoSql.insertQuestion(question);
		} finally {
			verify(dataSource).getConnection();
			verify(preparedStatement, never()).execute();
		}
	}
	
	@Test(expected = RuntimeException.class)
	public void testInsertQuestionCreateStatementException() throws SQLException {
		when(connection.prepareStatement(anyString())).thenThrow(new SQLException());
		try {
			projectDaoSql.insertQuestion(question);
		} finally {
			verify(dataSource).getConnection();
			verify(preparedStatement, never()).execute();
			verify(connection).close();
		}
	}
	
	@Test
	public void testInsertPayment() throws SQLException {
		projectDaoSql.insertPayment(payment);

		verify(connection, times(1)).prepareStatement(anyString());
		verify(preparedStatement, times(2)).setString(anyInt(), anyString());
		verify(preparedStatement, times(2)).setInt(anyInt(), anyInt());
		verify(preparedStatement, times(1)).execute();
		
	}
	
	@Test(expected = RuntimeException.class)
	public void testInsertPaymentGetConnectionException() throws SQLException {
		when(dataSource.getConnection()).thenThrow(new SQLException());
		try {
			projectDaoSql.insertPayment(payment);
		} finally {
			verify(dataSource).getConnection();
			verify(preparedStatement, never()).execute();
		}
	}
	
	@Test(expected = RuntimeException.class)
	public void testInsertPaymentCreateStatementException() throws SQLException {
		when(connection.prepareStatement(anyString())).thenThrow(new SQLException());
		try {
			projectDaoSql.insertPayment(payment);
		} finally {
			verify(dataSource).getConnection();
			verify(preparedStatement, never()).execute();
			verify(connection).close();
		}
	}
}
