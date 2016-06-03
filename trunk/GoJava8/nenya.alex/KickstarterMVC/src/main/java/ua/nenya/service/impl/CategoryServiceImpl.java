package ua.nenya.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.nenya.service.CategoryService;

@Service
@Transactional(readOnly = true)
public class CategoryServiceImpl implements CategoryService {

	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean isCategoryExistById(Long categoryId) {
		Query query = em.createNamedQuery("Category.Count");
		query.setParameter("categoryId", categoryId);
		long count = (long) query.getSingleResult();
		return count == 1L;
	}

	@Override
	public boolean isCategoryExistByName(String categoryName) {
		Query query = em.createNamedQuery("Category.CountByName");
		query.setParameter("categoryName", categoryName);
		long count = (long) query.getSingleResult();
		return count == 1L;
	}

}
