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
		return em.find(Category.class, categoryId);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean categoryExists(long categoryId) {
		return em.find(Category.class, categoryId) != null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Category> getCategories() {
		return em.createQuery("from Category").getResultList();
	}

}
