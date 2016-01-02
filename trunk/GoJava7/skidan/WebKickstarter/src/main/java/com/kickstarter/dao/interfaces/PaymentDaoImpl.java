package com.kickstarter.dao.interfaces;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kickstarter.hibernate.HibernateUtil;
import com.kickstarter.model.Payment;
import com.kickstarter.model.Project;

@Repository
public class PaymentDaoImpl implements PaymentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void addPayment(Project project, int amount) {
		Payment payment = new Payment();
		payment.setAmount(amount);
		payment.setProject(project);
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(payment);
		session.getTransaction().commit();
		session.close();
	}
	
	public List<Integer> getTopProjects() {
		String sql = "select projectId from payments group by projectId order by sum(amount) desc";
		return jdbcTemplate.queryForList(sql, Integer.class);

	}

	public Integer getAll(int projectId) {
		final String sql = "select SUM(amount)from Payment where projectId =" + projectId;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Long g = (Long)session.createQuery(sql).uniqueResult();
		int sum = g.intValue();
		session.close();
		return sum;
	}
}




























/*public void addPayment(int projectId, int amount) {
String sql = "insert into payments (projectId, amount) VALUES (?, ?)";
jdbcTemplate.update(sql, new Object[] { projectId, amount });
}*/




/*
 * public Integer getAll(int projectId) { String sql =
 * "select SUM(amount) from payments where projectId = ?"; return
 * jdbcTemplate.queryForObject(sql, new Object[] { projectId },
 * Integer.class);
 * 
 * }
 */