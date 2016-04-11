package ua.dborisenko.kickstarter.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ua.dborisenko.kickstarter.domain.Project;
import ua.dborisenko.kickstarter.domain.Question;

@RunWith(MockitoJUnitRunner.class)
public class QuestionDaoTest {

    @Mock
    private DataSource dataSource;
    @InjectMocks 
    private QuestionDao questionDao;
    
    @Test
    public void getQuestionsTest() throws SQLException {
        ResultSet rs =  mock(ResultSet.class);
        when(rs.getInt("id")).thenReturn(1);
        when(rs.getString("request")).thenReturn("testrequest");
        when(rs.next()).thenReturn(true,false);
        PreparedStatement statement = mock(PreparedStatement.class);
        when(statement.executeQuery()).thenReturn(rs);
        Connection connection = mock(Connection.class);
        when(connection.prepareStatement(anyString())).thenReturn(statement);
        when(dataSource.getConnection()).thenReturn(connection);
        Project project = new Project();
        questionDao.getQuestions(project);
        assertThat(project.getQuestions().size(), is(1));
        assertThat(project.getQuestions().get(0).getId(), is(1));
        assertThat(project.getQuestions().get(0).getRequest(), is("testrequest"));
    }
    
    @Test(expected = IllegalStateException.class)
    public void getQuestionsFailTest() throws SQLException {
        when(dataSource.getConnection()).thenReturn(null);
        Project project = new Project();
        questionDao.getQuestions(project);
    }
    
    @Test
    public void addQuestionTest() throws SQLException {
        ResultSet rs =  mock(ResultSet.class);
        PreparedStatement statement = mock(PreparedStatement.class);
        when(statement.executeQuery()).thenReturn(rs);
        Connection connection = mock(Connection.class);
        when(connection.prepareStatement(anyString())).thenReturn(statement);
        when(dataSource.getConnection()).thenReturn(connection);
        Question question = new Question();
        questionDao.addQuestion(1, question);
        verify(statement).executeUpdate();
    }
    
    @Test(expected = IllegalStateException.class)
    public void addQuestionFailTest() throws SQLException {
        when(dataSource.getConnection()).thenReturn(null);
        Question question = new Question();
        questionDao.addQuestion(1, question);
    }

}
