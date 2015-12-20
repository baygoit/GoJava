package ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import ua.com.goit.gojava7.kickstarter.dao.QuoteDAO;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.util.StatementSetter;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

public class QuotePostgreDAO implements QuoteDAO {
    	
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

    @Override
    public List<Quote> getAll() {
        String sql = "select text, author from quote";       
		return jdbcTemplate.query(sql, getRowMapper());
    }

    @Override
    public Quote get(int index) {
        String sql = "select text, author from quote limit 1 offset " + index;
		return jdbcTemplate.queryForObject(sql, getRowMapper());
    }

    @Override
    public void add(Quote element) {
        String sql = "insert into quote (text, author) values (?, ?)";
		jdbcTemplate.batchUpdate(sql, getStatementSetter(element));
    }

    @Override
    public void addAll(List<Quote> elements) {      
        String sql = "insert into quote (text, author) values (?, ?)";
		jdbcTemplate.batchUpdate(sql, getStatementSetter(elements));
    }

    @Override
    public void clear() {
        String sql = "delete from quote";
		jdbcTemplate.execute(sql);
    }

	public StatementSetter<Quote> getStatementSetter(Object argument) {
		return new StatementSetter<Quote>(argument) {
			@Override
			public void setupStatement(PreparedStatement statement, Quote element) throws SQLException  {
				 statement.setString(1, element.getText());
		         statement.setString(2, element.getAuthor());
			}
		};
	}
		
	public RowMapper<Quote> getRowMapper() {
		return new RowMapper<Quote>() {
			@Override
			public Quote mapRow(ResultSet resultSet, int rowNum) throws SQLException {
				Quote quote = new Quote(
		                resultSet.getString("author"), 
		                resultSet.getString("text"));
				return quote;
			}
		};
	}

}
