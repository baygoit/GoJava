package ua.dborisenko.kickstarter.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
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

import ua.dborisenko.kickstarter.domain.Category;
import ua.dborisenko.kickstarter.domain.Project;

@RunWith(MockitoJUnitRunner.class)
public class ProjectDaoTest {

    @Mock
    private DataSource dataSource;
    @Mock
    private InvestmentDao investmentDao;
    @InjectMocks 
    private ProjectDao projectDao;
    
    @Test
    public void getProjectsTest() throws SQLException {
        ResultSet rs =  mock(ResultSet.class);
        when(rs.getInt("id")).thenReturn(1);
        when(rs.getString("name")).thenReturn("testname");
        when(rs.getString("description")).thenReturn("testdescription");
        when(rs.getString("history")).thenReturn("testhistory");
        when(rs.getInt("required_sum")).thenReturn(10);
        when(rs.getInt("days_left")).thenReturn(20);
        when(rs.getString("video_url")).thenReturn("testvideo_url");
        when(rs.next()).thenReturn(true,false);
        PreparedStatement statement = mock(PreparedStatement.class);
        when(statement.executeQuery()).thenReturn(rs);
        Connection connection = mock(Connection.class);
        when(connection.prepareStatement(anyString())).thenReturn(statement);
        when(dataSource.getConnection()).thenReturn(connection);
        Category category = new Category();
        projectDao.getProjects(category);
        assertThat(category.getProjects().size(), is(1));
        assertThat(category.getProjects().get(0).getId(), is(1));
        assertThat(category.getProjects().get(0).getName(), is("testname"));
        assertThat(category.getProjects().get(0).getDescription(), is("testdescription"));
        assertThat(category.getProjects().get(0).getHistory(), is("testhistory"));
        assertThat(category.getProjects().get(0).getRequiredSum(), is(10));
        assertThat(category.getProjects().get(0).getDaysLeft(), is(20));
        assertThat(category.getProjects().get(0).getVideoUrl(), is("testvideo_url"));
    }
    
    @Test(expected = IllegalStateException.class)
    public void getProjectsFailTest() throws SQLException {
        when(dataSource.getConnection()).thenReturn(null);
        Category category = new Category();
        projectDao.getProjects(category);
    }
    
    @Test
    public void getProjectByIdTest() throws SQLException {
        ResultSet rs =  mock(ResultSet.class);
        when(rs.getInt("id")).thenReturn(1);
        when(rs.getString("name")).thenReturn("testname");
        when(rs.getString("description")).thenReturn("testdescription");
        when(rs.getString("history")).thenReturn("testhistory");
        when(rs.getInt("required_sum")).thenReturn(10);
        when(rs.getInt("days_left")).thenReturn(20);
        when(rs.getString("video_url")).thenReturn("testvideo_url");
        when(rs.next()).thenReturn(true);
        PreparedStatement statement = mock(PreparedStatement.class);
        when(statement.executeQuery()).thenReturn(rs);
        Connection connection = mock(Connection.class);
        when(connection.prepareStatement(anyString())).thenReturn(statement);
        when(dataSource.getConnection()).thenReturn(connection);
        Project project = projectDao.getProjectById(1);
        assertThat(project.getId(), is(1));
        assertThat(project.getName(), is("testname"));
        assertThat(project.getDescription(), is("testdescription"));
        assertThat(project.getHistory(), is("testhistory"));
        assertThat(project.getRequiredSum(), is(10));
        assertThat(project.getDaysLeft(), is(20));
        assertThat(project.getVideoUrl(), is("testvideo_url"));
    }

    @Test(expected = NoResultException.class)
    public void getProjectByIdEmptyTest() throws SQLException {
        ResultSet rs =  mock(ResultSet.class);
        when(rs.next()).thenReturn(false);
        PreparedStatement statement = mock(PreparedStatement.class);
        when(statement.executeQuery()).thenReturn(rs);
        Connection connection = mock(Connection.class);
        when(connection.prepareStatement(anyString())).thenReturn(statement);
        when(dataSource.getConnection()).thenReturn(connection);
        projectDao.getProjectById(1);
    }
    
    @Test(expected = IllegalStateException.class)
    public void getProjectByIdFailTest() throws SQLException {
        when(dataSource.getConnection()).thenReturn(null);
        projectDao.getProjectById(1);
    }

}
