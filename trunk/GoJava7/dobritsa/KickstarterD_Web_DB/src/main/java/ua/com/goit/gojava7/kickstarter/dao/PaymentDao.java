package ua.com.goit.gojava7.kickstarter.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.config.Validator;
import ua.com.goit.gojava7.kickstarter.models.Payment;
import ua.com.goit.gojava7.kickstarter.models.Project;

@Repository
public class PaymentDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private Validator validator;

	private static final Logger log = LoggerFactory.getLogger(PaymentDao.class);

	public PaymentDao() {
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void add(Payment payment) {
		log.info("<void> add({})...", payment);
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(payment);
		session.getTransaction().commit();
		
		session.close();
	}

	public Long calculatePledgedForProject(Long projectId) {
		log.info("<Long> calculatePledgedForProject({})...", projectId);
		Session session = sessionFactory.openSession();
	
		Long sumAmount = (Long) session.createCriteria(Payment.class).add(Restrictions.eq("project.id", projectId))
				.setProjection(Projections.sum("amount")).uniqueResult();
	
		session.close();

		if (sumAmount == null)
			return 0L;

		return sumAmount;
	}

	public boolean createPayment(String name, String card, Long amount, Project project) {
		log.info("<boolean> createPayment({}, {}, {}, {})...", name, card, amount, project);
		if (validator.validatePayer(name, card)) {
			Payment payment = new Payment(name, card, amount, project);
			add(payment);
			return true;
		}
		return false;
	}
}
