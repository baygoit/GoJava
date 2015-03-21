package ua.com.goit.gojava2.vova.kickstarter.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava2.vova.kickstarter.model.Category;

@Repository("categoryDao")
public class CategoryDaoImpl extends AbstractDao implements CategoryDao{

	public void saveCategory(Category category) {
		persist(category);
	}

	@SuppressWarnings("unchecked")
	public List<Category> findAllCategories() {
		Criteria criteria = getSession().createCriteria(Category.class);
		return (List<Category>) criteria.list();
	}

	public void deleteCategoriesById(Integer id) {
		Query query = getSession().createSQLQuery("delete from Categories where id = :id");
		query.setInteger("id", id);
		query.executeUpdate();
	}
	
}
