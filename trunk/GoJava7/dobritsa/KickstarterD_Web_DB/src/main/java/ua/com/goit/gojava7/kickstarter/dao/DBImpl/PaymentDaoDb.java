package ua.com.goit.gojava7.kickstarter.dao.DBImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.model.Payment;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class PaymentDaoDb implements PaymentDao {

	private static final Logger log = LoggerFactory.getLogger(PaymentDaoDb.class);

	@Autowired
	private ProjectDao projectDao;

	@PersistenceContext
	private EntityManager em;

	public Long calculatePledgedForProject(Long projectId) {
		log.info("<Long> calculatePledgedForProject(projectId = {})...", projectId);

		Long sumAmount = em.createNamedQuery("Payment.calculatePledgedForProject", Long.class)
				.setParameter("project", projectDao.get(projectId)).getSingleResult();
		log.info("<Long> calculatePledgedForProject(projectId = {}) returned {}", projectId, sumAmount);

		if(sumAmount == null)
			return 0L;

		return sumAmount;
	}

	public void add(Payment payment) {
		log.info("<void> add({})...", payment);
		em.persist(payment);
	}
}
