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

import ua.dborisenko.kickstarter.domain.Project;

@RunWith(MockitoJUnitRunner.class)
public class RewardDaoTest {

    @Mock
    private DataSource dataSource;
    @InjectMocks
    private RewardDao rewardDao;
    
    @Test
    public void getRewardsTest() throws SQLException {
        ResultSet rs =  mock(ResultSet.class);
        when(rs.getInt("id")).thenReturn(1);
        when(rs.getString("description")).thenReturn("testdescription");
        when(rs.getInt("amount")).thenReturn(10);
        when(rs.next()).thenReturn(true,false);
        PreparedStatement statement = mock(PreparedStatement.class);
        when(statement.executeQuery()).thenReturn(rs);
        Connection connection = mock(Connection.class);
        when(connection.prepareStatement(anyString())).thenReturn(statement);
        when(dataSource.getConnection()).thenReturn(connection);
        Project project = new Project();
        rewardDao.getRewards(project);
        assertThat(project.getRewards().size(), is(1));
        assertThat(project.getRewards().get(0).getId(), is(1));
        assertThat(project.getRewards().get(0).getDescription(), is("testdescription"));
        assertThat(project.getRewards().get(0).getAmount(), is(10));
    }

    @Test(expected = IllegalStateException.class)
    public void getRewardsFailTest() throws SQLException {
        when(dataSource.getConnection()).thenReturn(null);
        Project project = new Project();
        rewardDao.getRewards(project);
    }
}
