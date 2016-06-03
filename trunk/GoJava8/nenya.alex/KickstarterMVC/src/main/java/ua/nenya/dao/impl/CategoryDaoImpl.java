package ua.nenya.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.nenya.dao.CategoryDao;
import ua.nenya.domain.Category;

@Transactional
@Repository
public class CategoryDaoImpl implements CategoryDao {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Category> getCategories() {
		return em.createNamedQuery("Category.getCategories").getResultList();
	}

	@Override
	@Transactional(readOnly = true)
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
	
	@Override
	@Transactional(readOnly = true)
	public boolean isCategoryExistById(Long categoryId) {
		Query query = em.createNamedQuery("Category.Count");
		query.setParameter("categoryId", categoryId);
		long count = (long) query.getSingleResult();
		return count == 1L;
	}

	@Override
	@Transactional(readOnly = true)
	public boolean isCategoryExistByName(String categoryName) {
		Query query = em.createNamedQuery("Category.CountByName");
		query.setParameter("categoryName", categoryName);
		long count = (long) query.getSingleResult();
		return count == 1L;
	}

}
