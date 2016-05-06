package ua.nenya.dao.db;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.nenya.dao.PaymentDao;
import ua.nenya.domain.Payment;

@Repository
public class PaymentDaoImpl implements PaymentDao {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	@Override
	public Payment writePaymentInProject(Payment payment) {
		em.persist(payment);
		return payment;
	}
	
}
