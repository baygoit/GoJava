package com.kickstarter.dao.Impl;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Isolation;
//import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kickstarter.dao.Interfaces.PaymentDao;
import com.kickstarter.model.Payment;
import com.kickstarter.model.Project;

@Repository
public class PaymentDaoImpl implements PaymentDao {

    @PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	public void addPayment(Project project, int amount) {
		Payment payment = new Payment();
		System.out.println("1");
		payment.setAmount(amount);
		System.out.println("2");
		payment.setProject(project);
		System.out.println("3");
		entityManager.persist(payment);
		System.out.println("4");

	}
	
	@Transactional(readOnly = true)
	public Integer getAll(int projectId) {      
		Query query = entityManager.
				createQuery("select SUM(amount)from Payment where projectId = :projectId");
        query.setParameter("projectId", projectId);
		Long g = (Long)query.getSingleResult();
		int sum = g.intValue();
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