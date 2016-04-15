package ua.dborisenko.kickstarter.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;

import ua.dborisenko.kickstarter.dao.InvestmentDao.InvestmentRowMapper;
import ua.dborisenko.kickstarter.domain.Investment;
import ua.dborisenko.kickstarter.domain.Project;

@RunWith(MockitoJUnitRunner.class)
public class InvestmentDaoTest {
    
    @Mock
    private JdbcTemplate jdbcTemplate;
    @InjectMocks 
    private InvestmentDao investmentDao;

    @Test
    public void mapRowTest() throws SQLException  {
        ResultSet rs = mock(ResultSet.class);
        when(rs.getInt("id")).thenReturn(111);
        when(rs.getString("cardholder_name")).thenReturn("testcardholder_name");
        when(rs.getString("card_number")).thenReturn("testcard_number");
        when(rs.getInt("amount")).thenReturn(222);
        InvestmentRowMapper mapper = investmentDao.new InvestmentRowMapper();
        Investment investment = mapper.mapRow(rs, 1);
        assertThat(investment.getId(), is(111));
        assertThat(investment.getCardHolderName(), is("testcardholder_name"));
        assertThat(investment.getCardNumber(), is("testcard_number"));
        assertThat(investment.getAmount(), is(222));
        
    }
    
    @Test
    public void getAllForProjectTest() {
        Project project = new Project();
        project.setId(1);
        investmentDao.getAllForProject(project);
        verify(jdbcTemplate).query(eq(InvestmentDao.GET_ALL_BY_PROJECT_ID_QUERY), eq(new Object[] { 1 }), Matchers.any(InvestmentRowMapper.class));
    }
    
    @Test
    public void addTest() {
        Investment investment = new Investment();
        investment.setId(1);
        investment.setCardHolderName("testcardholder_name");
        investment.setCardNumber("testcard_number");
        investment.setAmount(100);
        investmentDao.add(1, investment);
        verify(jdbcTemplate).update(InvestmentDao.ADD_QUERY, 1, investment.getCardHolderName(), investment.getCardNumber(),
                investment.getAmount());
    }
}
