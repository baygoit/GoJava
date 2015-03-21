package ua.com.sas.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;








import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.com.sas.model.*;

@Component
public class CategoriesDAO extends AbstractDAO implements Categories {
	
	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public void add(Category category) {
		 Session session = this.sessionFactory.openSession();
	        Transaction tx = session.beginTransaction();
	        session.persist(category);
	        tx.commit();
	        session.close();
	}

	@Override
	public List<Category> getCategories() {
		Session session = this.sessionFactory.openSession();
        Query query = session.createQuery("FROM Category");
        List<Category> categories = query.list();
        session.close();
		return categories;
	}
	
	@Override
	public Category get(int id) {
		Session session = this.sessionFactory.openSession();
	    Category category = (Category) session.get(Category.class, id);
	    session.close();
	    return category;
	}

	@Override
	public int size() {
		Session session = this.sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Category.class);
		criteria.setProjection(Projections.rowCount());
	    Long count = (Long) criteria.uniqueResult();
	    int size = count.intValue();
	    criteria.setProjection(null);
	    criteria.setResultTransformer(Criteria.ROOT_ENTITY);
	    session.close();
		return size;
	}

}
