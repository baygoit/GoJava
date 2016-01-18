package ua.com.goit.gojava7.kickstarter.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
		Query query = em.createQuery("from Category");

		List<Category> categories = (List<Category>) query.getResultList();

		return categories;
	}

	@Override
	public Category get(Long categoryId) {
		return em.find(Category.class, categoryId);
	}

}
