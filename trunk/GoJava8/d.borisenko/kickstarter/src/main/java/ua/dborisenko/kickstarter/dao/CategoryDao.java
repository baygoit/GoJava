package ua.dborisenko.kickstarter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ua.dborisenko.kickstarter.domain.Category;

@Repository
public class CategoryDao {

    private final class CategoryRowMapper implements RowMapper<Category> {
        @Override
        public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
            Category category = new Category();
            category.setId(rs.getInt("id"));
            category.setName(rs.getString("name"));
            return category;
        }
    }

    private static final String QUERY_GET_CATEGORY_BY_PROJECT_ID = "SELECT c.id, c.name FROM categories c INNER JOIN projects p ON (p.category_id = c.id) WHERE p.id = ?";
    private static final String QUERY_GET_CATEGORY_BY_ID = "SELECT id, name FROM categories WHERE id = ?";
    private static final String QUERY_GET_CATEGORIES = "SELECT id, name FROM categories ORDER BY name";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Category getById(int id) {
        return jdbcTemplate.queryForObject(QUERY_GET_CATEGORY_BY_ID, new Object[] { id }, new CategoryRowMapper());
    }

    public List<Category> getAll() {
        return jdbcTemplate.query(QUERY_GET_CATEGORIES, new CategoryRowMapper());
    }

    public Category getByProjectId(int id) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("id", String.valueOf(id));
        return jdbcTemplate.queryForObject(QUERY_GET_CATEGORY_BY_PROJECT_ID, new Object[] { id },
                new CategoryRowMapper());
    }
}
