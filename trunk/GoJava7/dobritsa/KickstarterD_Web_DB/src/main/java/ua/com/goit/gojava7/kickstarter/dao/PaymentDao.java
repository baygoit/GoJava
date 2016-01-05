package ua.com.goit.gojava7.kickstarter.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.models.Payment;
import ua.com.goit.gojava7.kickstarter.models.Project;

@Repository
public class PaymentDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private static final Logger log = LoggerFactory.getLogger(PaymentDao.class);

	public PaymentDao() {
	}

	public void add(Payment payment) {
		log.info("<void> add({})...", payment);
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(payment);
		session.getTransaction().commit();
		
		session.close();
	}

	public Long calculatePledgedForProject(Project project) {
		log.info("<Integer> calculatePledgedForProject({})...", project);
		Session session = sessionFactory.openSession();
	
		Long sumAmount = (Long) session.createCriteria(Payment.class).add(Restrictions.eq("Project", project))
				.setProjection(Projections.sum("amount")).uniqueResult();
	
		session.close();
		log.debug("<Integer> calculatePledgedForProject({}) returned questions: {}", project, ".......");
		return sumAmount;
	}
}
