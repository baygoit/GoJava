package com.kickstarter.dao.Impl;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kickstarter.dao.interfaces.PaymentDao;
import com.kickstarter.model.Payment;
import com.kickstarter.model.Project;

@Repository
public class PaymentDaoImpl implements PaymentDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void addPayment(Project project, int amount) {
		Payment payment = new Payment();
		payment.setAmount(amount);
		payment.setProject(project);
		Session session = sessionFactory.openSession();
		session.save(payment);
		session.close();
	}
	
	@Transactional
	public Integer getAll(int projectId) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("select SUM(amount)from Payment where projectId = :projectId");
        query.setInteger("projectId", projectId);
		Long g = (Long)query.uniqueResult();
		int sum = g.intValue();
		session.close();
		return sum;
	}
}










/*public List<Integer> getTopProjects() {
String sql = "select projectId from payments group by projectId order by sum(amount) desc";
return jdbcTemplate.queryForList(sql, Integer.class);

}
*/


/*@Autowired
private JdbcTemplate jdbcTemplate;

public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	this.jdbcTemplate = jdbcTemplate;
}*/


















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