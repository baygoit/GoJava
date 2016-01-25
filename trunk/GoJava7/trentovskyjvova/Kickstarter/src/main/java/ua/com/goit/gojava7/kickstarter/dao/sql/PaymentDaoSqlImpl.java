package ua.com.goit.gojava7.kickstarter.dao.sql;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kickstarter.domain.Payment;

@Repository
@Transactional
public class PaymentDaoSqlImpl implements PaymentDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public void addPayment(Payment payment) {

		em.merge(payment);
	}

}
