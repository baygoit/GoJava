package ua.dborisenko.kickstarter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ua.dborisenko.kickstarter.domain.Category;
import ua.dborisenko.kickstarter.domain.Project;

@Repository
public class ProjectDao {

    final class ProjectRowMapper implements RowMapper<Project> {
        @Override
        public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
            Project project = new Project();
            project.setId(rs.getInt("id"));
            project.setName(rs.getString("name"));
            project.setDaysLeft(rs.getInt("days_left"));
            project.setDescription(rs.getString("description"));
            project.setHistory(rs.getString("history"));
            project.setRequiredSum(rs.getInt("required_sum"));
            project.setVideoUrl(rs.getString("video_url"));
            return project;
        }
    }

    static final String GET_BY_ID_QUERY = "SELECT id, name, description, history, required_sum, days_left, video_url FROM projects WHERE id = ?";
    static final String GET_ALL_BY_CATEGORY_QUERY = "SELECT id, name, description, history, required_sum, days_left, video_url FROM projects WHERE category_id = ?";
    @Autowired
    private InvestmentDao investmentDao;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private ProjectRowMapper mapper = new ProjectRowMapper();

    public void getAllForCategory(Category category) {
        category.setProjects(jdbcTemplate.query(GET_ALL_BY_CATEGORY_QUERY, new Object[] { category.getId() }, mapper));
    }

    public Project getById(int id) {
        Project project = jdbcTemplate.queryForObject(GET_BY_ID_QUERY, new Object[] { id }, mapper);
        investmentDao.getAllForProject(project);
        return project;
    }
}
