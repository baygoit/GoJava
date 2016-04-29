package ua.nenya.dao.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ua.nenya.dao.PaymentDao;
import ua.nenya.domain.Payment;

@Repository
public class PaymentDaoImpl implements PaymentDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
	@Override
	public int writePaymentInProject(Payment payment) {
		Session session = sessionFactory.getCurrentSession();
		int id = (int) session.save(payment);
		return id;
	}

}
