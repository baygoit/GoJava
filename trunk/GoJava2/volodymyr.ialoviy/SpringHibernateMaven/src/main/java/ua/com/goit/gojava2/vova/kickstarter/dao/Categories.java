package ua.com.goit.gojava2.vova.kickstarter.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava2.vova.kickstarter.model.Category;

@Repository("categoryDao")
public class Categories extends AbstractDao implements CategoryDao{

	@Override
	public void saveCategory(Category category) {
		persist(category);
	}

	@Override
	public List<Category> findAllCategories() {
		return (List<Category>) getSession().createCriteria(Category.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	}
	
	@Override
	public void deleteCategoryById(int id) {
		Category category = (Category) getSession().load(Category.class, id);
		getSession().delete(category);
	}

	@Override
	public Category findCategoryById(int id) {
        return (Category) getSession().get(Category.class, id);
	}
	
}
