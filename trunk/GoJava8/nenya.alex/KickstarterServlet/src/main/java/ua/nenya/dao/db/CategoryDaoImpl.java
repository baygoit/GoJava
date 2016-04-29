package ua.nenya.dao.db;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.nenya.dao.CategoryDao;
import ua.nenya.domain.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Category> getCategories() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Category.class);
		criteria.addOrder(Order.asc("name"));
		return criteria.list();
	}

	@Transactional(readOnly = true)
	@Override
	public boolean isCategoryExist(int categoryId) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Category.class);
		criteria.add(Restrictions.eq("id", categoryId));
		long count = (long) criteria.setProjection(Projections.rowCount()).uniqueResult();
		return count == 1;
	}

}
