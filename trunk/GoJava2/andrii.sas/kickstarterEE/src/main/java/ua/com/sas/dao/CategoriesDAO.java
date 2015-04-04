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

	@Override
	public int size() {
		Session session = getSession();
		int size = 0;
		Criteria criteria = session.createCriteria(Category.class);
		criteria.setProjection(Projections.rowCount());
	    Long count = (Long) criteria.uniqueResult();
	    size = count.intValue();
	    criteria.setProjection(null);
	    criteria.setResultTransformer(Criteria.ROOT_ENTITY);
		return size;
	}

}
