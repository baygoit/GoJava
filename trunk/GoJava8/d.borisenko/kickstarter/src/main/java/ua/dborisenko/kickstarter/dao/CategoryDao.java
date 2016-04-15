package ua.dborisenko.kickstarter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ua.dborisenko.kickstarter.domain.Category;

@Repository
public class CategoryDao {

    final class CategoryRowMapper implements RowMapper<Category> {
        @Override
        public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
            Category category = new Category();
            category.setId(rs.getInt("id"));
            category.setName(rs.getString("name"));
            return category;
        }
    }

    static final String GET_BY_PROJECT_ID_QUERY = "SELECT c.id, c.name FROM categories c INNER JOIN projects p ON (p.category_id = c.id) WHERE p.id = ?";
    static final String GET_BY_ID_QUERY = "SELECT id, name FROM categories WHERE id = ?";
    static final String GET_ALL_QUERY = "SELECT id, name FROM categories ORDER BY name";
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private CategoryRowMapper mapper = new CategoryRowMapper();

    public Category getById(int id) {
        return jdbcTemplate.queryForObject(GET_BY_ID_QUERY, new Object[] { id }, mapper);
    }

    public List<Category> getAll() {
        return jdbcTemplate.query(GET_ALL_QUERY, mapper);
    }

    public Category getByProjectId(int id) {
        return jdbcTemplate.queryForObject(GET_BY_PROJECT_ID_QUERY, new Object[] { id }, mapper);
    }
}
