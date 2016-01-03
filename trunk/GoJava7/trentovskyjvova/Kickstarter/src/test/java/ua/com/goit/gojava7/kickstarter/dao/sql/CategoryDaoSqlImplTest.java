package ua.com.goit.gojava7.kickstarter.dao.sql;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.dao.sql.CategoryDaoSqlImpl;

@RunWith(MockitoJUnitRunner.class)
public class CategoryDaoSqlImplTest {

	@Mock
	private JdbcTemplate jdbcTemplate;
	@InjectMocks
	private CategoryDao categoryDaoMySqlImpl = new CategoryDaoSqlImpl();

	@Test
	@Ignore
	public void testGetCategory() {

		categoryDaoMySqlImpl.getCategory(1);
		verify(jdbcTemplate).queryForObject(contains("category WHERE id = ?"), any(Integer[].class),
				any(BeanPropertyRowMapper.class));
	}

	@Test
	@Ignore
	public void testGetCategories() {

		categoryDaoMySqlImpl.getCategories();
		verify(jdbcTemplate).query(contains("category"), any(BeanPropertyRowMapper.class));
	}

	@Test
	@Ignore
	public void testSize() {

		when(jdbcTemplate.queryForObject(contains("category"), eq(Integer.class))).thenReturn(2);
		int i = categoryDaoMySqlImpl.size();
		assertThat(i, is(2));
	}
}
