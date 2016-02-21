package com.kickstarter.dao.Impl;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
	public void addPayment(int projectId, int amount) {
		Project project = entityManager.find(Project.class, projectId);
		Payment payment = new Payment();
		payment.setAmount(amount);
		payment.setProject(project);
		entityManager.persist(payment);
	}
	
	@Transactional(readOnly = true)
	public Integer getAll(int projectId) {      
		Long tempSum = (Long) entityManager
				.createQuery("select SUM(amount)from Payment where projectId = :projectId")
				.setParameter("projectId", projectId)
			    .getSingleResult();
		
		return tempSum.intValue();
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