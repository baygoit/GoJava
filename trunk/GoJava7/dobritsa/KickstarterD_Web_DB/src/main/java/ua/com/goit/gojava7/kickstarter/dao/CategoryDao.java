package ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.goit.gojava7.kickstarter.model.Category;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
		return em.createNamedQuery("Category.getAll", Category.class).getResultList();
	}
}
