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

import ua.dborisenko.kickstarter.dao.RewardDao.RewardRowMapper;
import ua.dborisenko.kickstarter.domain.Project;
import ua.dborisenko.kickstarter.domain.Reward;

@RunWith(MockitoJUnitRunner.class)
public class RewardDaoTest {

    @Mock
    private JdbcTemplate jdbcTemplate;
    @InjectMocks
    private RewardDao rewardDao;
    
    @Test
    public void mapRowTest() throws SQLException  {
        ResultSet rs = mock(ResultSet.class);
        when(rs.getInt("id")).thenReturn(111);
        when(rs.getInt("amount")).thenReturn(222);
        when(rs.getString("description")).thenReturn("testdescription");
        RewardRowMapper mapper = rewardDao.new RewardRowMapper();
        Reward reward = mapper.mapRow(rs, 1);
        assertThat(reward.getId(), is(111));
        assertThat(reward.getDescription(), is("testdescription"));
        assertThat(reward.getAmount(), is(222));
        
    }
    
    @Test
    public void getAllForProjectTest() {
        Project project = new Project();
        project.setId(1);
        rewardDao.getAllForProject(project);
        verify(jdbcTemplate).query(eq(RewardDao.GET_ALL_BY_PROJECT_ID_QUERY), eq(new Object[] { 1 }), Matchers.any(RewardRowMapper.class));
    }
}
