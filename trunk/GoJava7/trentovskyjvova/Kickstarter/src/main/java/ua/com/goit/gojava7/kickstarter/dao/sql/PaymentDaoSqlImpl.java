package ua.com.goit.gojava7.kickstarter.dao.sql;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kickstarter.domain.Payment;
import ua.com.goit.gojava7.kickstarter.hibernate.HibernateUtil;

@Repository
public class PaymentDaoSqlImpl implements PaymentDao {
	/*@Autowired
	private JdbcTemplate jdbcTemplate;*/

	@Override
	public List<Payment> getPayments(int projectId) {

		/*String sql = "SELECT id, projectId, name, cardNumber, pledge FROM payment WHERE projectId = ?";
		return jdbcTemplate.query(sql, new Integer[] { projectId }, new BeanPropertyRowMapper<Payment>(Payment.class));*/

		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Criteria criteria = session.createCriteria(Payment.class);	
		criteria.add(Restrictions.eq("projectId", projectId));
		List<Payment> payments = criteria.list();
		
		session.close();

		return payments;
	}

	@Override
	public void addPayment(Payment payment) {

		/*String sql = "INSERT INTO payment (projectId, name, cardNumber, pledge) VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(sql, payment.getProjectId(), payment.getName(), payment.getCardNumber(),
				payment.getPledge());*/
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		session.save(payment);
		session.getTransaction().commit();

		session.close();

	}
	
	@Override
	public int getPledged(int projectId) {

		/*String sql = "SELECT SUM(pledge) pledged FROM payment WHERE projectId IN ?";
		return jdbcTemplate.queryForObject(sql, new Integer[] { projectId }, Integer.class);*/	
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Criteria criteria = session.createCriteria(Payment.class);
		criteria.add(Restrictions.eq("projectId", projectId));
		criteria.setProjection(Projections.sum("pledge"));

		int pledged = (int) criteria.uniqueResult();
		
		session.close();

		return pledged;
	}

}
