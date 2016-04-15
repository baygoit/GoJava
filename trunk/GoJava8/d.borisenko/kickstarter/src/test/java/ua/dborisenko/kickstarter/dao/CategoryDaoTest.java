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

import ua.dborisenko.kickstarter.dao.CategoryDao.CategoryRowMapper;
import ua.dborisenko.kickstarter.domain.Category;

@RunWith(MockitoJUnitRunner.class)
public class CategoryDaoTest {

    @Mock
    private JdbcTemplate jdbcTemplate;
    @InjectMocks 
    private CategoryDao categoryDao;
    
    @Test
    public void mapRowTest() throws SQLException  {
        ResultSet rs = mock(ResultSet.class);
        when(rs.getInt("id")).thenReturn(111);
        when(rs.getString("name")).thenReturn("testname");
        CategoryRowMapper mapper = categoryDao.new CategoryRowMapper();
        Category category = mapper.mapRow(rs, 1);
        assertThat(category.getId(), is(111));
        assertThat(category.getName(), is("testname"));
    }
    
    @Test
    public void getByIdTest() {
        categoryDao.getById(1);
        verify(jdbcTemplate).queryForObject(eq(CategoryDao.GET_BY_ID_QUERY), eq(new Object[] { 1 }), Matchers.any(CategoryRowMapper.class));
        
    }

    @Test
    public void getAllTest() {
        categoryDao.getAll();
        verify(jdbcTemplate).query(eq(CategoryDao.GET_ALL_QUERY), Matchers.any(CategoryRowMapper.class));
    }
    
    @Test
    public void getByProjectIdTest() {
        categoryDao.getByProjectId(1);
        verify(jdbcTemplate).queryForObject(eq(CategoryDao.GET_BY_PROJECT_ID_QUERY), eq(new Object[] { 1 }), Matchers.any(CategoryRowMapper.class));
    }
}
