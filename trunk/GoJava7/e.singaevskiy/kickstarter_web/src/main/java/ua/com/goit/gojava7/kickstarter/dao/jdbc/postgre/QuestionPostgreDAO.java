package ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import ua.com.goit.gojava7.kickstarter.dao.QuestionsDAO;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.util.StatementSetter;
import ua.com.goit.gojava7.kickstarter.domain.Question;

public class QuestionPostgreDAO implements QuestionsDAO{

    private static final String TABLE = "question";
    private static final String FIELDS = "project_id,question,answer";
    private static final String INSERTION = FIELDS.replaceAll("[^,]+", "?");
   
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
    public Question get(int index) {
        String sql = "select " + FIELDS + " from " + TABLE + " limit 1 offset  " + index;
        return jdbcTemplate.queryForObject(sql, getRowMapper());
    }

    @Override
    public void add(Question element) {
        String sql = "insert into " + TABLE + " (" + FIELDS + ") values (" + INSERTION + ")";
        jdbcTemplate.batchUpdate(sql, getStatementSetter(element));
    }

    @Override
    public void addAll(List<Question> elements) {
        String sql = "insert into " + TABLE + " (" + FIELDS + ") values (" + INSERTION + ")";
        jdbcTemplate.batchUpdate(sql, getStatementSetter(elements));
    }

    @Override
    public List<Question> getAll() {
        String sql = "select " + FIELDS + " from " + TABLE;
        return jdbcTemplate.query(sql, getRowMapper());
    }

    @Override
    public List<Question> getByProject(int projectId) {
        String sql = "select " + FIELDS + " from " + TABLE + " where project_id = " + projectId;
        return jdbcTemplate.query(sql, getRowMapper());
    }

	public StatementSetter<Question> getStatementSetter(Object argument) {
		return new StatementSetter<Question>(argument) {
			@Override
			public void setupStatement(PreparedStatement statement, Question element) throws SQLException  {
				int i = 0;
		        if (element.getProjectId() == 0) {
		            statement.setNull(++i, java.sql.Types.INTEGER);   
		        } else {
		            statement.setInt(++i, element.getProjectId());             
		        }
		        statement.setString(++i, element.getQuestion());
		        statement.setString(++i, element.getAnswer());
			}
		};
	}
		
	public RowMapper<Question> getRowMapper() {
		return new RowMapper<Question>() {
			@Override
			public Question mapRow(ResultSet resultSet, int rowNum) throws SQLException {
				Question element = new Question();
		        element.setQuestion(resultSet.getString("question"));
		        element.setAnswer(resultSet.getString("answer"));
		        element.setProjectId(resultSet.getInt("project_id"));
		        return element;
			}
		};
	}

}
