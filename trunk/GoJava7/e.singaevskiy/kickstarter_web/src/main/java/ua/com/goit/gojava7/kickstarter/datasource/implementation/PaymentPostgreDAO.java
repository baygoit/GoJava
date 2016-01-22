package ua.com.goit.gojava7.kickstarter.datasource.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.com.goit.gojava7.kickstarter.datasource.contract.PaymentDAO;
import ua.com.goit.gojava7.kickstarter.domain.Payment;

@Repository
public class PaymentPostgreDAO implements PaymentDAO {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public void clear() {
		entityManager.createNamedQuery("Payment.removeAll").executeUpdate();
	}

	@Override
	public Payment get(Long index) {
		return entityManager.find(Payment.class, index);
	}

	@Override
	@Transactional
	public void add(Payment element) {
		entityManager.persist(element);
	}

	@Override
	@Transactional
	public void addAll(List<Payment> elements) {
		elements.forEach(entityManager::persist);
	}

	@Override
	public List<Payment> getAll() {
		return entityManager.createNamedQuery("Payment.getAll", Payment.class).getResultList();
	}

	@Override
	public List<Payment> getByProject(Long projectId) {
		TypedQuery<Payment> query = entityManager.createNamedQuery("Payment.getByProject", Payment.class);
		query.setParameter("project_id", projectId);
		return query.getResultList();
	}

	@Override
	public long getSum(Long projectId) {
		TypedQuery<Long> query = entityManager.createNamedQuery("Payment.getSumByProject", Long.class);
		query.setParameter("project_id", projectId);
		Long sum = query.getSingleResult();
		if (sum == null) {
			sum = 0L;
		}
		return sum;
	}
	
}
