package com.anmertrix.dao.sql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.anmertrix.dao.CategoryDao;
import com.anmertrix.domain.Category;

@Repository
public class CategoryDaoSql implements CategoryDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional(readOnly = true)
	public Category getCategory(long categoryId) {
		return em.createNamedQuery("Category.getCategory", Category.class)
				.setParameter("categoryId", categoryId).getSingleResult();
	}

	@Override
	@Transactional(readOnly = true)
	public boolean isExists(long categoryId) {
		return em.createNamedQuery("Category.count", Long.class).setParameter("categoryId", categoryId).getSingleResult() > 0;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Category> getCategories() {
		return em.createNamedQuery("Category.getCategories", Category.class).getResultList();
	}

}