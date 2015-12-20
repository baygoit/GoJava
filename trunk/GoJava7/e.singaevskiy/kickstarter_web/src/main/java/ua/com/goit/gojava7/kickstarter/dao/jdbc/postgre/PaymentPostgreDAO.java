package ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import ua.com.goit.gojava7.kickstarter.dao.PaymentDAO;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.util.StatementSetter;
import ua.com.goit.gojava7.kickstarter.domain.Payment;

public class PaymentPostgreDAO implements PaymentDAO {

	private static final String TABLE = "payment";
	private static final String FIELDS = "cardid,date,username,sum,project_id,reward_id";
	private static final String INSERTION = FIELDS.replaceAll("[^,]+", "?");

	private JdbcTemplate jdbcTemplate;

	@Override
	public void clear() {
		String sql = "delete from " + TABLE;
		jdbcTemplate.execute(sql);
	}

	@Override
	public Payment get(int index) {
		String sql = "select " + FIELDS + " from " + TABLE + " limit 1 offset " + index;
		return jdbcTemplate.queryForObject(sql, getRowMapper());
	}

	@Override
	public void add(Payment element) {
		String sql = "insert into " + TABLE + " (" + FIELDS + ") values (" + INSERTION + ")";
		jdbcTemplate.batchUpdate(sql, getStatementSetter(element));
	}

	@Override
	public void addAll(List<Payment> elements) {
		String sql = "insert into " + TABLE + " (" + FIELDS + ") values (" + INSERTION + ")";
		jdbcTemplate.batchUpdate(sql, getStatementSetter(elements));
	}

	@Override
	public List<Payment> getAll() {
		String sql = "select " + FIELDS + " from " + TABLE;
		return jdbcTemplate.query(sql, getRowMapper());
	}

	@Override
	public List<Payment> getByProject(int projectId) {
		String sql = "select " + FIELDS + " from " + TABLE + " where project_id = " + projectId;
		return jdbcTemplate.query(sql, getRowMapper());
	}

	@Override
	public long getSum(int projectId) {
		String sql = "select SUM(sum) from " + TABLE + " where project_id = " + projectId;
		return jdbcTemplate.queryForObject(sql, Long.class);
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public StatementSetter<Payment> getStatementSetter(Object argument) {
		return new StatementSetter<Payment>(argument) {
			@Override
			public void setupStatement(PreparedStatement statement, Payment element) throws SQLException  {
				statement.setLong(1, element.getCardId());
				statement.setDate(2, element.getDate());
				statement.setString(3, element.getUser());
				statement.setLong(4, element.getSum());
				if (element.getProjectId() == 0) {
					statement.setNull(5, java.sql.Types.INTEGER);
				} else {
					statement.setInt(5, element.getProjectId());
				}
				if (element.getRewardId() == 0) {
					statement.setNull(6, java.sql.Types.INTEGER);
				} else {
					statement.setInt(6, element.getRewardId());
				};
			}
		};
	}
		
	public RowMapper<Payment> getRowMapper() {
		return new RowMapper<Payment>() {
			@Override
			public Payment mapRow(ResultSet resultSet, int rowNum) throws SQLException {
				Payment element = new Payment();
				element.setCardId(resultSet.getInt("cardId"));
				element.setDate(resultSet.getDate("date"));
				element.setUser(resultSet.getString("username"));
				element.setSum(resultSet.getLong("sum"));
				element.setRewardId(resultSet.getInt("reward_id"));
				element.setProjectId(resultSet.getInt("project_id"));
				return element;
			}
		};
	}
	
}
