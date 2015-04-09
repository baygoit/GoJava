package ua.com.goit.gojava.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Component;

import ua.com.goit.gojava.model.Categories;
import ua.com.goit.gojava.model.Category;

@Component
public class CategoriesDAO extends AbstractDAO implements Categories {

	public void add(Category category) {
		Session session = getSession();
		session.save(category);
		session.close();
	}

	public List<Category> getCategories() {
		Session session = getSession();
		Query query = session.createQuery("FROM Category");
		List<Category> categories = query.list();
		session.close();
		return categories;
	}

	public Category get(int id) {
		Session session = getSession();
		Category category = (Category) session.get(Category.class, id);
		session.close();
		return category;
	}

	public int size() {
		Session session = getSession();
		int size = 0;
		Criteria criteria = session.createCriteria(Category.class);
		criteria.setProjection(Projections.rowCount());
		Long count = (Long) criteria.uniqueResult();
		size = count.intValue();
		criteria.setProjection(null);
		criteria.setResultTransformer(Criteria.ROOT_ENTITY);
		session.close();
		return size;
	}

}