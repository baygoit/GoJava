package ua.com.sas.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import ua.com.sas.model.*;

@Repository
public class CategoriesDAO extends AbstractDAO implements Categories {
	
	@Override
	public void add(Category category) {
		 Session session = getSession();
	     session.save(category);
	}

	@Override
	public List<Category> getCategories() {
		Session session = getSession();
        Query query = session.createQuery("FROM Category");
        List<Category> categories = query.list();
		return categories;
	}
	
	@Override
	public Category get(int id) {
		Session session = getSession();
	    Category category = (Category) session.get(Category.class, id);
	    category.getProjects().size();
	    return category;
	}

}
