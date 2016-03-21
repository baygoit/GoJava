package ua.dborisenko.kickstarter.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.mysql.jdbc.Statement;

import ua.dborisenko.kickstarter.domain.Category;
import ua.dborisenko.kickstarter.domain.Investment;
import ua.dborisenko.kickstarter.domain.Project;
import ua.dborisenko.kickstarter.domain.Question;
import ua.dborisenko.kickstarter.domain.Reward;

public class CategoryDaoSqlTest {
    private CategoryDaoSql categoryDao = spy(CategoryDaoSql.class);
    private Connection connection = mock(Connection.class);
    private Statement statement = mock(Statement.class);
    private ResultSet rs = mock(ResultSet.class);

    @Before
    public void prepareMock() throws SQLException {
        when(categoryDao.getConnection()).thenReturn(connection);
        when(connection.createStatement()).thenReturn(statement);
        when(statement.executeQuery(anyString())).thenReturn(rs);
    }

    @Test
    public void getCategoryNamesTest() throws SQLException {
        when(rs.getString("name")).thenReturn("testname");
        when(rs.next()).thenReturn(true).thenReturn(false);
        List<String> categoriyNames = categoryDao.getCategoryNames();
        assertThat(categoriyNames.get(0), is("testname"));
    }

    @Test
    public void getByNameTest() throws SQLException {
        when(rs.getString("name")).thenReturn("testname");
        when(rs.getInt("id")).thenReturn(1);
        Category category = categoryDao.getByName("");
        assertThat(category.getId(), is(1));
        assertThat(category.getName(), is("testname"));
    }
    
    @Test
    public void getProjectsTest() throws SQLException {
        when(rs.getInt("id")).thenReturn(1);
        when(rs.getString("name")).thenReturn("testname");
        when(rs.getString("description")).thenReturn("testdescription");
        when(rs.getString("history")).thenReturn("testhistory");
        when(rs.getInt("days_left")).thenReturn(111);
        when(rs.getInt("required_sum")).thenReturn(222);
        when(rs.getString("video_url")).thenReturn("testvideourl");
        when(rs.next()).thenReturn(true).thenReturn(true).thenReturn(false);
        Category category = categoryDao.getByName("test");
        Project project = category.getProjects().get(0);
        assertThat(project.getId(), is(1));
        assertThat(project.getName(), is("testname"));
        assertThat(project.getDescription(), is("testdescription"));
        assertThat(project.getHistory(), is("testhistory"));
        assertThat(project.getDaysLeft(), is(111));
        assertThat(project.getRequiredSum(), is(222));
        assertThat(project.getVideoUrl(), is("testvideourl"));
    }
    
    @Test
    public void getQuestionsTest() throws SQLException {
        when(rs.getInt("id")).thenReturn(1);
        when(rs.getString("request")).thenReturn("testrequest");
        when(rs.getString("reply")).thenReturn("testreply");
        when(rs.next()).thenReturn(true).thenReturn(false);
        Project project = new Project();
        categoryDao.getQuestions(project);
        Question question = project.getQuestions().get(0);
        assertThat(question.getId(), is(1));
        assertThat(question.getRequest(), is("testrequest"));
        assertThat(question.getReply(), is("testreply"));
    }
    
    @Test
    public void getRewardsTest() throws SQLException {
        when(rs.getInt("id")).thenReturn(1);
        when(rs.getInt("amount")).thenReturn(111);
        when(rs.getString("description")).thenReturn("testdescription");
        when(rs.next()).thenReturn(true).thenReturn(false);
        Project project = new Project();
        categoryDao.getRewards(project);
        Reward reward = project.getRewards().get(0);
        assertThat(reward.getId(), is(1));
        assertThat(reward.getAmount(), is(111));
        assertThat(reward.getDescription(), is("testdescription"));
    }
    
    @Test
    public void addInvestmentTest() throws SQLException  {
        Project project = new Project();
        Investment investment = new Investment();
        investment.setAmount(111);
        categoryDao.addInvestment(project, investment);
        assertThat(project.getCollectedSum(), is(111));
        verify(statement).executeUpdate(anyString());
    }
    
    @Test
    public void addQuestionTest() throws SQLException  {
        Project project = new Project();
        Question question = new Question();
        question.setRequest("testrequest");
        categoryDao.addQuestion(project, question);
        assertThat(project.getQuestions().get(0).getRequest(), is("testrequest"));
        verify(statement).executeUpdate(anyString());
    }
}
