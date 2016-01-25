package ua.com.goit.gojava7.kickstarter.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.domain.Category;

@Repository
@Transactional
public class CategoryDaoImpl implements CategoryDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Category> getAll() {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

		CriteriaQuery<Category> criteriaQuery = criteriaBuilder.createQuery(Category.class);
		Root<Category> categoryRoot = criteriaQuery.from(Category.class);
		criteriaQuery.select(categoryRoot);

		TypedQuery<Category> query = em.createQuery(criteriaQuery);
		List<Category> categories = query.getResultList();

		return categories;
	}

	@Override
	public Category get(Long categoryId) {
		return em.find(Category.class, categoryId);
	}

}
