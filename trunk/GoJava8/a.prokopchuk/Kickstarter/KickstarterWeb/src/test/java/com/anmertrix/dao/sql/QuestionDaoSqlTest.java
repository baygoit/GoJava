package com.anmertrix.dao.sql;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Ignore;
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
	
	@Ignore
	@Test
	public void testInsertQuestion() throws SQLException {
		questionDaoSql.insertQuestion(question);
		verify(connection, times(1)).prepareStatement(anyString());
		verify(preparedStatement, times(1)).setString(anyInt(), anyString());
		verify(preparedStatement, times(1)).setInt(anyInt(), anyInt());
		verify(preparedStatement, times(1)).execute();
	}
	

}
