package ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.goit.gojava7.kickstarter.model.Category;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
@Transactional
public class CategoryDao {

	private static final Logger log = LoggerFactory.getLogger(CategoryDao.class);

	@PersistenceContext
	private EntityManager em;

	public Category get(Long categoryId) {
		log.info("<Category> get(categoryId = {})...", categoryId);

		return em.find(Category.class, categoryId);
	}

	public List<Category> getAll() {
		log.info("<categories> getAll()...");

		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

		CriteriaQuery<Category> criteriaQuery = criteriaBuilder.createQuery(Category.class);
		Root<Category> categoryRoot = criteriaQuery.from(Category.class);
		criteriaQuery.select(categoryRoot);

		TypedQuery<Category> query = em.createQuery(criteriaQuery);
		List<Category> categories = query.getResultList();

		log.info("<categories> getAll() returns {} categories", categories.size());

		return categories;
	}
}
