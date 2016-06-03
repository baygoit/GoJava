package ua.nenya.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.nenya.controller.jsp.CategoryController;
import ua.nenya.service.ProjectService;

@Service
@Transactional(readOnly = true)
public class ProjectServiceImpl implements ProjectService {

	@PersistenceContext
	private EntityManager em;
	
	private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);
	
	@Override
	public boolean isProjectExistById(Long projectId) {
		Query query = em.createNamedQuery("Project.Count");
		query.setParameter("projectId", projectId);
		long count = (long) query.getSingleResult();
		return count == 1L;
	}

	@Override
	public boolean isProjectExistByName(String projectName) {
		Query query = em.createNamedQuery("Project.CountByName");
		query.setParameter("projectName", projectName);
		long count = (long) query.getSingleResult();
		return count == 1L;
	}

	@Override
	public long getPaymentSum(Long projectId) {
		long paymentSum;
		Query query = em.createNamedQuery("Payment.getAmount");
		query.setParameter("projectId", projectId);
		try {
			paymentSum = (long) query.getSingleResult();
		} catch (NoResultException e) {
			logger.info("Project with id = "+projectId+" is without payments!");
			logger.trace("Exception: ", e);
			return 0;
		}
		return paymentSum;
	}

}
