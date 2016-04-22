package ua.dborisenko.kickstarter.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;

import ua.dborisenko.kickstarter.domain.Category;
import ua.dborisenko.kickstarter.domain.Project;
@Ignore
@RunWith(MockitoJUnitRunner.class)
public class ProjectDaoTest {

    @Mock
    private JdbcTemplate jdbcTemplate;
    @Mock
    private InvestmentDao investmentDao;
    @InjectMocks 
    private ProjectDao projectDao;
    
    @Test
    public void getAllForCategoryTest()  {
        Category category = new Category();
        category.setId(1);
        projectDao.getAllForCategory(category);
//        verify(jdbcTemplate).query(eq(ProjectDao.GET_ALL_BY_CATEGORY_QUERY), eq(new Object[] { 1 }), Matchers.any(ProjectRowMapper.class));
    }
    
    @Test
    public void getByIdTest() {
        projectDao.getById(1);
//        verify(jdbcTemplate).queryForObject(eq(ProjectDao.GET_BY_ID_QUERY), eq(new Object[] { 1 }), Matchers.any(ProjectRowMapper.class));
    }
}

