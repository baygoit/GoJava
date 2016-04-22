package ua.dborisenko.kickstarter.dao;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;
@Ignore
@RunWith(MockitoJUnitRunner.class)
public class CategoryDaoTest {

    @Mock
    private JdbcTemplate jdbcTemplate;
    @InjectMocks 
    private CategoryDao categoryDao;
    
  
    @Test
    public void getByIdTest() {
        categoryDao.getById(1);
//        verify(jdbcTemplate).queryForObject(eq(CategoryDao.GET_BY_ID_QUERY), eq(new Object[] { 1 }), Matchers.any(CategoryRowMapper.class));
        
    }

    @Test
    public void getAllTest() {
        categoryDao.getAll();
//        verify(jdbcTemplate).query(eq(CategoryDao.GET_ALL_QUERY), Matchers.any(CategoryRowMapper.class));
    }
    
    @Test
    public void getByProjectIdTest() {
//        categoryDao.getByProjectId(1);
//        verify(jdbcTemplate).queryForObject(eq(CategoryDao.GET_BY_PROJECT_ID_QUERY), eq(new Object[] { 1 }), Matchers.any(CategoryRowMapper.class));
    }
}
