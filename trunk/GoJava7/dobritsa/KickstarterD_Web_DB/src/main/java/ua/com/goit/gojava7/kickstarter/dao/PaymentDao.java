package ua.com.goit.gojava7.kickstarter.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;
import ua.com.goit.gojava7.kickstarter.model.Payment;

@Repository
@Transactional
public class PaymentDao {

	private static final Logger log = LoggerFactory.getLogger(PaymentDao.class);

	@Autowired
	private SessionFactory sessionFactory;

	public Long calculatePledgedForProject(Long projectId) {
		log.info("<Long> calculatePledgedForProject({})...", projectId);
		Session session = sessionFactory.getCurrentSession();

		Long sumAmount = (Long) session.createCriteria(Payment.class).add(Restrictions.eq("project.id", projectId))
				.setProjection(Projections.sum("amount")).uniqueResult();

		if (sumAmount == null)
			return 0L;

		return sumAmount;
	}

	public void add(Payment payment) {
		log.info("<void> add({})...", payment);
		Session session = sessionFactory.getCurrentSession();

		session.save(payment);
	}
}
