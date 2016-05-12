package ua.nenya.dao.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.nenya.dao.CategoryDao;
import ua.nenya.domain.Category;

@Transactional(readOnly = true)
@Repository
public class CategoryDaoImpl implements CategoryDao {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getCategories() {
		return em.createNamedQuery("Category.getCategories").getResultList();
	}

	@Override
	public boolean isCategoryExist(Long categoryId) {
		Query query = em.createNamedQuery("Category.Count");
		query.setParameter("categoryId", categoryId);
		long count = (long) query.getSingleResult();
		return count == 1L;
	}

}
