package ua.com.goit.gojava7.kickstarter.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public abstract class AbstractDao {
	protected JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
