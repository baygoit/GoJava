package ua.com.goit.gojava7.kickstarter.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.beans.Category;
import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;

@Repository
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	@SuppressWarnings("unchecked")
	public List<Category> getAll() {
		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(Category.class);
		List<Category> categories = criteria.list();

		return categories;
	}

	@Transactional
	public Category getCategoryById(int id) {
		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(Category.class);
		criteria.add(Restrictions.eq("id", id));
		Category category = (Category) criteria.uniqueResult();

		session.close();
		return category;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Object[]> getTop10Categories() {
		Session session = sessionFactory.getCurrentSession();

		SQLQuery query = session.createSQLQuery("SELECT category.name, SUM(coalesce(payment.pledge,0)) AS money "
				+ "FROM category " + "LEFT JOIN project ON category.id = project.category_id "
				+ "LEFT JOIN payment ON project.id = payment.project_id " + "GROUP BY category.id "
				+ "ORDER BY money DESC limit 10");

		List<Object[]> list = query.list();
		System.out.println(list);
		return list;
	}

	public void add(Category category) {
		// TODO
	}

	public void remove(Category category) {
		// TODO
	}
}
