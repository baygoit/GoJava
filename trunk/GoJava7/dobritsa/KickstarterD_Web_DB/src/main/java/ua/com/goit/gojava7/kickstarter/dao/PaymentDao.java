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
import ua.com.goit.gojava7.kickstarter.validator.MyValidator;
import ua.com.goit.gojava7.kickstarter.model.Payment;
import ua.com.goit.gojava7.kickstarter.model.Project;

@Repository
@Transactional
public class PaymentDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private MyValidator myValidator;

	private static final Logger log = LoggerFactory.getLogger(PaymentDao.class);

	public Long calculatePledgedForProject(Long projectId) {
		log.info("<Long> calculatePledgedForProject({})...", projectId);
		Session session = sessionFactory.getCurrentSession();

		Long sumAmount = (Long) session.createCriteria(Payment.class).add(Restrictions.eq("project.id", projectId))
				.setProjection(Projections.sum("amount")).uniqueResult();

		if (sumAmount == null)
			return 0L;

		return sumAmount;
	}

	public boolean createPayment(String name, String card, Long amount, Project project) {
		log.info("<boolean> createPayment({}, {}, {}, {})...", name, card, amount, project);
		if (myValidator.validatePayer(name, card)) {
			Payment payment = new Payment(name, card, amount, project);
			add(payment);
			return true;
		}
		return false;
	}

	public void add(Payment payment) {
		log.info("<void> add({})...", payment);
		Session session = sessionFactory.getCurrentSession();

		session.save(payment);
	}
}
