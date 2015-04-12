package ua.com.goit.gojava.kickstarter.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava.kickstarter.data.Category;
import ua.com.goit.gojava.kickstarter.data.Categories;

@Repository
public class CategoriesDao extends AbstractDao implements Categories {
	
	

	@Override
	public int size() {
		Session session = getCurrentSession();
	    Number n = (Number)session.createCriteria(Category.class).setProjection(Projections.rowCount()).uniqueResult();
	    return n.intValue();
	}

	@Override
	public void add(Category category) {
		 Session session = getCurrentSession();
		 session.save(category);

	}

	@Override
	public List<Category> getCatalog() {
		Session session = getCurrentSession();
		 Query query = session.createQuery("FROM  Category");
		 List<Category> categories = query.list();
		 return categories;
	 }

	@Override
	public Category get(int i) {
		Session session = getCurrentSession();
		 Category category = (Category) session.get(Category.class, i);
		 return category;
	}

}
