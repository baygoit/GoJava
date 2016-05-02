package com.anmertrix.dao.sql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Category> criteria = criteriaBuilder.createQuery(Category.class);
		Root<Category> category = criteria.from(Category.class);
		TypedQuery<Category> query = em.createQuery(
		    criteria.select(category).where(criteriaBuilder.equal(category.get("id"), categoryId)));
		return query.getSingleResult();
	}

	@Override
	@Transactional(readOnly = true)
	public boolean categoryExists(long categoryId) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
		Root<Category> category = criteriaQuery.from(Category.class);
		criteriaQuery.select(criteriaBuilder.count(category));
		criteriaQuery.where(criteriaBuilder.equal(category.get("id"), categoryId));
		TypedQuery<Long> typedQuery = em.createQuery(criteriaQuery);
		return typedQuery.getSingleResult() > 0;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Category> getCategories() {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Category> criteria = criteriaBuilder.createQuery(Category.class);
		Root<Category> category = criteria.from(Category.class);
		TypedQuery<Category> query = em.createQuery(criteria.select(category));
		return query.getResultList();
		//return em.createNamedQuery("Category.getCategories", Category.class).getResultList();
	}

}