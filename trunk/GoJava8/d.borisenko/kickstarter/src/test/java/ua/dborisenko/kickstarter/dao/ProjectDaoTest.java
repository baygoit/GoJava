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

import ua.dborisenko.kickstarter.dao.ProjectDao.ProjectRowMapper;
import ua.dborisenko.kickstarter.domain.Category;
import ua.dborisenko.kickstarter.domain.Project;

@RunWith(MockitoJUnitRunner.class)
public class ProjectDaoTest {

    @Mock
    private JdbcTemplate jdbcTemplate;
    @Mock
    private InvestmentDao investmentDao;
    @InjectMocks 
    private ProjectDao projectDao;
    
    @Test
    public void mapRowTest() throws SQLException  {
        ResultSet rs = mock(ResultSet.class);
        when(rs.getInt("id")).thenReturn(1);
        when(rs.getString("name")).thenReturn("testname");
        when(rs.getString("description")).thenReturn("testdescription");
        when(rs.getString("history")).thenReturn("testhistory");
        when(rs.getInt("required_sum")).thenReturn(10);
        when(rs.getInt("days_left")).thenReturn(20);
        when(rs.getString("video_url")).thenReturn("testvideo_url");
        ProjectRowMapper mapper = projectDao.new ProjectRowMapper();
        Project project = mapper.mapRow(rs, 1);
        assertThat(project.getId(), is(1));
        assertThat(project.getName(), is("testname"));
        assertThat(project.getDescription(), is("testdescription"));
        assertThat(project.getHistory(), is("testhistory"));
        assertThat(project.getRequiredSum(), is(10));
        assertThat(project.getDaysLeft(), is(20));
        assertThat(project.getVideoUrl(), is("testvideo_url"));
        
    }
    
    @Test
    public void getAllForCategoryTest()  {
        Category category = new Category();
        category.setId(1);
        projectDao.getAllForCategory(category);
        verify(jdbcTemplate).query(eq(ProjectDao.GET_ALL_BY_CATEGORY_QUERY), eq(new Object[] { 1 }), Matchers.any(ProjectRowMapper.class));
    }
    
    @Test
    public void getByIdTest() {
        projectDao.getById(1);
        verify(jdbcTemplate).queryForObject(eq(ProjectDao.GET_BY_ID_QUERY), eq(new Object[] { 1 }), Matchers.any(ProjectRowMapper.class));
    }
}

