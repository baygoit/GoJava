package ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import ua.com.goit.gojava7.kickstarter.dao.ProjectDAO;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.util.StatementSetter;
import ua.com.goit.gojava7.kickstarter.domain.Project;

public class ProjectPostgreDAO implements ProjectDAO {
	
	private static final String TABLE = "project";
	private static final String FIELDS = "id,name,goalSum,startDate,endDate,category_id,description,videoUrl,author";
	private static final String INSERTION = FIELDS.replaceAll("[^,]+", "?");
	private static final String KEY = "id";

	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void clear() {
		String sql = "delete from " + TABLE;
		jdbcTemplate.execute(sql);
	}

	@Override
	public Project get(int index) {
		String sql = "select " + FIELDS + " from " + TABLE + " where " + TABLE + "." + KEY + " = ?";
		return jdbcTemplate.queryForObject(sql, new Object[]{index}, getRowMapper());
	}

	@Override
	public void add(Project element) {
		String sql = "insert into " + TABLE + " (" + FIELDS + ") values (" + INSERTION + ")";
		jdbcTemplate.batchUpdate(sql, getStatementSetter(element));
	}

	@Override
	public void addAll(List<Project> elements) {
		String sql = "insert into " + TABLE + " (" + FIELDS + ") values (" + INSERTION + ")";
		jdbcTemplate.batchUpdate(sql, getStatementSetter(elements));
	}

	@Override
	public List<Project> getAll() {
		return jdbcTemplate.query("select " + FIELDS + " from " + TABLE, getRowMapper());
	}

	@Override
	public List<Project> getByCategory(int categoryId) {
		String sql = "select " + FIELDS + " from " + TABLE + " where project.category_id = ?";
		return jdbcTemplate.query(sql, new Object[]{categoryId}, getRowMapper());
	}
	
	@Override
	public List<Project> getTopDonated(int limit) {
		String sql = "" +
		"SELECT " +
		"  coalesce(projectPayments.balance,0) as balance, " +
		"  project.* " +
		"FROM  " +
		"  project left join  " +
		"	(select payment.project_id,  " +
		"	sum(payment.sum)  " +
		"		as balance from payment " +
		"	group by project_id) projectPayments " +
		"  on project.id = projectPayments.project_id " +
		"  order by balance desc " +
		"limit ? ";
		
		return jdbcTemplate.query(sql, new Object[]{limit}, getRowMapper());
	}

	public StatementSetter<Project> getStatementSetter(Object argument) {
		return new StatementSetter<Project>(argument) {
			@Override
			public void setupStatement(PreparedStatement statement, Project element) throws SQLException  {
				int i = 0;
				statement.setInt(++i, element.getId());
				statement.setString(++i, element.getName());
				statement.setLong(++i, element.getGoalSum());
				statement.setDate(++i, element.getStartDate());
				statement.setDate(++i, element.getEndDate());
				if (element.getCategoryId() == 0) {
					statement.setNull(++i, java.sql.Types.INTEGER);
				} else {
					statement.setInt(++i, element.getCategoryId());
				}
				statement.setString(++i, element.getDescription());
				statement.setString(++i, element.getVideoUrl());
				statement.setString(++i, element.getAuthor());
			}
		};
	}
		
	public RowMapper<Project> getRowMapper() {
		return new RowMapper<Project>() {
			@Override
			public Project mapRow(ResultSet resultSet, int rowNum) throws SQLException {
				Project project = new Project();
				project.setId(resultSet.getInt("id"));
				project.setName(resultSet.getString("name"));
				project.setAuthor(resultSet.getString("author"));
				project.setDescription(resultSet.getString("description"));
				project.setVideoUrl(resultSet.getString("videoUrl"));
				project.setStartDate(resultSet.getDate("startDate"));
				project.setEndDate(resultSet.getDate("endDate"));
				project.setGoalSum(resultSet.getLong("goalSum"));
				project.setCategoryId(resultSet.getInt("category_id"));
				try {
					project.setBalanceSum(resultSet.getLong("balance"));
				} catch (Exception e) {
					// TODO: handle exception
				}				
				return project;
			}
		};
	}

}
