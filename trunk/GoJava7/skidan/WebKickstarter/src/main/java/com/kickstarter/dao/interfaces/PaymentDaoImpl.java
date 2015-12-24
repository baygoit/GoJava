package com.kickstarter.dao.interfaces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentDaoImpl implements PaymentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public Integer getAll(int projectId) {
		String sql = "select SUM(amount) from payments where projectId = ?";
		return jdbcTemplate.queryForObject(sql, new Object[]{projectId}, Integer.class);

	}

	public void addPayment(int projectId, int amount) {
		String sql = "insert into payments (projectId, amount) VALUES (?, ?)";
		jdbcTemplate.update(sql, new Object[] { projectId, amount });
	}

	public List<Integer> getTopProjects(){
		String sql = "select projectId from payments group by projectId order by sum(amount) desc";
		return jdbcTemplate.queryForList(sql, Integer.class);
		
	}
}
