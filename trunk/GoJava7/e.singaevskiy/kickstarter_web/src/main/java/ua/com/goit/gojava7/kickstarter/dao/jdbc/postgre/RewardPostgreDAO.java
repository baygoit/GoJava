package ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import ua.com.goit.gojava7.kickstarter.dao.RewardDAO;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.util.StatementSetter;
import ua.com.goit.gojava7.kickstarter.domain.Reward;

public class RewardPostgreDAO implements RewardDAO {
	
    private static final String TABLE = "reward";
    private static final String FIELDS = "id,description,pledgeSum,project_id";
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
    public Reward get(int index) {
        String sql = "select " + FIELDS + " from " + TABLE + " where " + KEY + " = ?";
		return jdbcTemplate.queryForObject(sql, new Object[]{index}, getRowMapper());
    }

    @Override
    public void add(Reward element) {
        String sql = "insert into " + TABLE + " (" + FIELDS + ") values (" + INSERTION + ")";
		jdbcTemplate.batchUpdate(sql, getStatementSetter(element));
    }

    @Override
    public void addAll(List<Reward> elements) {
        String sql = "insert into " + TABLE + " (" + FIELDS + ") values (" + INSERTION + ")";
		jdbcTemplate.batchUpdate(sql, getStatementSetter(elements));
    }

    @Override
    public List<Reward> getAll() {
        String sql = "select " + FIELDS + " from " + TABLE;
        return jdbcTemplate.query(sql, getRowMapper());
    }

    @Override
    public List<Reward> getByProject(int projectId) {
        String sql = "select " + FIELDS + " from " + TABLE + " where project_id = ?";
        return jdbcTemplate.query(sql, new Object[]{projectId},getRowMapper());
    }

	public StatementSetter<Reward> getStatementSetter(Object argument) {
		return new StatementSetter<Reward>(argument) {
			@Override
			public void setupStatement(PreparedStatement statement, Reward element) throws SQLException  {
				int i = 0;
		        statement.setInt(++i, element.getId());
		        statement.setString(++i, element.getDescription());
		        statement.setLong(++i, element.getPledgeSum());
		        if (element.getProjectId() == 0) {
		        	statement.setNull(++i, Types.INTEGER);
				} else {
					statement.setInt(++i, element.getProjectId());
				}
			}
		};
	}
		
	public RowMapper<Reward> getRowMapper() {
		return new RowMapper<Reward>() {
			@Override
			public Reward mapRow(ResultSet resultSet, int rowNum) throws SQLException {
				Reward element = new Reward();
		        element.setId(resultSet.getInt("id"));
		        element.setDescription(resultSet.getString("description"));
		        element.setPledgeSum(resultSet.getLong("pledgeSum"));
		        element.setProjectId(resultSet.getInt("project_id"));
		        return element;
			}
		};
	}

}
