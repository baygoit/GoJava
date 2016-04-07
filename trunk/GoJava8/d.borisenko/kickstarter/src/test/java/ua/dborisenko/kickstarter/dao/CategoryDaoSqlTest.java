package ua.dborisenko.kickstarter.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.mysql.jdbc.Statement;

import ua.dborisenko.kickstarter.domain.Category;
import ua.dborisenko.kickstarter.domain.Investment;
import ua.dborisenko.kickstarter.domain.Project;
import ua.dborisenko.kickstarter.domain.Question;

@Ignore
public class CategoryDaoSqlTest {
    private CategoryDao categoryDao = spy(CategoryDao.class);
    private BasicDataSource dataSource = mock(BasicDataSource.class);
    private Connection connection = mock(Connection.class);
    private Statement statement = mock(Statement.class);
    private ResultSet rs = mock(ResultSet.class);

    @Before
    public void prepareMock() throws SQLException {
        categoryDao.setDataSource(dataSource);
        doNothing().when(categoryDao).initDataSource();
        when(dataSource.getConnection()).thenReturn(connection);
        when(connection.createStatement()).thenReturn(statement);
        when(statement.executeQuery(anyString())).thenReturn(rs);
    }

    @Test
    public void getCategoriesTest() throws SQLException {
        when(rs.getString("name")).thenReturn("testname");
        when(rs.next()).thenReturn(true).thenReturn(false);
        List<Category> categories = categoryDao.getCategories();
        assertThat(categories.get(0).getName(), is("testname"));
    }

    @Test(expected = IllegalStateException.class)
    public void getCategoriesFailTest() throws SQLException {
        when(categoryDao.getConnection()).thenThrow(new SQLException());
        categoryDao.getCategories();
    }

    @Test
    public void getCategoryByIdTest() throws SQLException {
        when(rs.getString("name")).thenReturn("testname");
        when(rs.getInt("id")).thenReturn(1);
        Category category = categoryDao.getCategoryById(1);
        assertThat(category.getId(), is(1));
        assertThat(category.getName(), is("testname"));
    }

    @Test(expected = IllegalStateException.class)
    public void getcategoryByIdFailTest() throws SQLException {
        when(categoryDao.getConnection()).thenThrow(new SQLException());
        categoryDao.getCategoryById(1);
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
        Category category = categoryDao.getCategoryById(1);
        Project project = category.getProjects().get(0);
        assertThat(project.getId(), is(1));
        assertThat(project.getName(), is("testname"));
        assertThat(project.getDescription(), is("testdescription"));
        assertThat(project.getHistory(), is("testhistory"));
        assertThat(project.getDaysLeft(), is(111));
        assertThat(project.getRequiredSum(), is(222));
        assertThat(project.getVideoUrl(), is("testvideourl"));
    }

    @Test(expected = IllegalStateException.class)
    public void getProjectsFailTest() throws SQLException {
        when(categoryDao.getConnection()).thenReturn(connection).thenThrow(new SQLException());
        categoryDao.getCategoryById(1);
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

    @Test(expected = IllegalStateException.class)
    public void getQuestionsFailTest() throws SQLException {
        when(categoryDao.getConnection()).thenThrow(new SQLException());
        Project project = new Project();
        categoryDao.getQuestions(project);
    }

    @Test(expected = IllegalStateException.class)
    public void addInvestmentFailTest() throws SQLException {
        when(categoryDao.getConnection()).thenThrow(new SQLException());
        Investment investment = new Investment();
        categoryDao.addInvestment(1, investment);
    }

    @Test(expected = IllegalStateException.class)
    public void addQuestionFailTest() throws SQLException {
        when(categoryDao.getConnection()).thenThrow(new SQLException());
        Question question = new Question();
        categoryDao.addQuestion(1, question);
    }

    @Test
    public void getInvestmentsTest() throws SQLException {
        when(rs.getInt("id")).thenReturn(1);
        when(rs.getInt("amount")).thenReturn(111);
        when(rs.getString("cardholder_name")).thenReturn("testcardholdername");
        when(rs.getString("card_number")).thenReturn("testcardnumber");
        when(rs.next()).thenReturn(true).thenReturn(false);
        Project project = new Project();
        categoryDao.getInvestments(project);
        Investment investment = project.getInvestments().get(0);
        assertThat(investment.getId(), is(1));
        assertThat(investment.getCardHolderName(), is("testcardholdername"));
        assertThat(investment.getCardNumber(), is("testcardnumber"));
    }

    @Test(expected = IllegalStateException.class)
    public void getInvestmentsFailTest() throws SQLException {
        when(categoryDao.getConnection()).thenThrow(new SQLException());
        Project project = new Project();
        categoryDao.getInvestments(project);
    }
}
