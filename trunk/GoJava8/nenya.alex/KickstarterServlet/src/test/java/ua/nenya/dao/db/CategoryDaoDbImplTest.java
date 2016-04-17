package ua.nenya.dao.db;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import ua.nenya.domain.Category;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Ignore
@RunWith(MockitoJUnitRunner.class)
public class CategoryDaoDbImplTest {

	@Mock
	private JdbcTemplate jdbcTemplate;
	@InjectMocks
	private CategoryDaoImpl categoryDaoImpl;

	private List<Category> categories = new ArrayList<>();

	@Before
	public void init() {
		Category category = new Category();
		category.setName("Category Art");
		categories.add(category);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testGetCategories() throws SQLException {
		when(jdbcTemplate.query(anyString(), Matchers.any(BeanPropertyRowMapper.class))).thenReturn(categories);
		List<Category> testCategories = categoryDaoImpl.getCategories();
		assertThat(testCategories.get(0).getName(), is("Category Art"));

	}

	@Ignore
	@Test
	public void testIsCategoryExist() throws SQLException {
		when(jdbcTemplate.queryForObject(eq(anyString()), eq(new Object[] { "Category Art" }), Integer.class))
				.thenReturn(1);

		assertThat(categoryDaoImpl.isCategoryExist(1), is(true));
	}
}
