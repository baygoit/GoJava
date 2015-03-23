package ua.com.goit.gojava2.vova.kickstarter.dao;

import java.util.List;

import org.hibernate.Query;
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
		List<Category> result = (List<Category>) getSession().createQuery("from Category").list();
		return result;
	}

	@Override
	public void deleteCategoryById(Integer id) {
		Query query = getSession().createSQLQuery("delete from Categories where id = :id");
		query.setInteger("id", id);
		query.executeUpdate();
	}
	
}
