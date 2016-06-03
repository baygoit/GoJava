package ua.nenya.dao.impl;

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
	public Category getCategoryByCategoryId(Long categoryId) {
		Query query = em.createNamedQuery("Category.getCategory");
		query.setParameter("categoryId", categoryId);
		return (Category) query.getSingleResult();
	}

	@Override
	public Category deleteCategoryByCategoryId(Long categoryId) {
		Category category = getCategoryByCategoryId(categoryId);
		em.remove(category);
		return category;
	}

	@Override
	public Category saveCategory(Category category) {
			return em.merge(category);
	}

}
