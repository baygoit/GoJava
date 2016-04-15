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

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ua.dborisenko.kickstarter.domain.Investment;
import ua.dborisenko.kickstarter.domain.Project;
@Ignore
@RunWith(MockitoJUnitRunner.class)
public class InvestmentDaoTest {
    
    @Mock
    private DataSource dataSource;
    @InjectMocks 
    private InvestmentDao investmentDao;

    @Test
    public void getInvestmentsTest() throws SQLException {
        ResultSet rs =  mock(ResultSet.class);
        when(rs.getInt("id")).thenReturn(1);
        when(rs.getString("cardholder_name")).thenReturn("testcardholder_name");
        when(rs.getString("card_number")).thenReturn("testcard_number");
        when(rs.getInt("amount")).thenReturn(10);
        when(rs.next()).thenReturn(true,false);
        PreparedStatement statement = mock(PreparedStatement.class);
        when(statement.executeQuery()).thenReturn(rs);
        Connection connection = mock(Connection.class);
        when(connection.prepareStatement(anyString())).thenReturn(statement);
        when(dataSource.getConnection()).thenReturn(connection);
        Project project = new Project();
        investmentDao.getAllForProject(project);
        assertThat(project.getInvestments().size(), is(1));
        assertThat(project.getInvestments().get(0).getId(), is(1));
        assertThat(project.getInvestments().get(0).getCardHolderName(), is("testcardholder_name"));
        assertThat(project.getInvestments().get(0).getCardNumber(), is("testcard_number"));
        assertThat(project.getInvestments().get(0).getAmount(), is(10));
    }
    
    @Test(expected = IllegalStateException.class)
    public void getInvestmentsFailTest() throws SQLException {
        when(dataSource.getConnection()).thenReturn(null);
        Project project = new Project();
        investmentDao.getAllForProject(project);
    }
    
    @Test
    public void addInvestmentTest() throws SQLException {
        ResultSet rs =  mock(ResultSet.class);
        PreparedStatement statement = mock(PreparedStatement.class);
        when(statement.executeQuery()).thenReturn(rs);
        Connection connection = mock(Connection.class);
        when(connection.prepareStatement(anyString())).thenReturn(statement);
        when(dataSource.getConnection()).thenReturn(connection);
        Investment investment = new Investment();
        investmentDao.addToProject(1, investment);
        verify(statement).executeUpdate();
    }
    
    @Test(expected = IllegalStateException.class)
    public void addInvestmentFailTest() throws SQLException {
        when(dataSource.getConnection()).thenReturn(null);
        Investment investment = new Investment();
        investmentDao.addToProject(1, investment);
    }

}
