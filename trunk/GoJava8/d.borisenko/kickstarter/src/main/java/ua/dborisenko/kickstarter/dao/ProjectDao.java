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

    private final class ProjectRowMapper implements RowMapper<Project> {
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

    private static final String QUERY_GET_PROJECT_BY_ID = "SELECT id, name, description, history, required_sum, days_left, video_url FROM projects WHERE id = ?";
    private static final String QUERY_GET_PROJECTS = "SELECT id, name, description, history, required_sum, days_left, video_url FROM projects WHERE category_id = ?";
    @Autowired
    private InvestmentDao investmentDao;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void getProjects(Category category) {
        category.setProjects(
                jdbcTemplate.query(QUERY_GET_PROJECTS, new Object[] { category.getId() }, new ProjectRowMapper()));
    }

    public Project getProjectById(int id) {
        Project project = jdbcTemplate.queryForObject(QUERY_GET_PROJECT_BY_ID, new Object[] { id },
                new ProjectRowMapper());
        investmentDao.getInvestments(project);
        return project;
    }
}
