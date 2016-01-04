package ua.com.goit.gojava7.kickstarter.dao.sql;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.domain.Category;

@Repository
@Transactional
public class CategoryDaoSqlImpl implements CategoryDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Category> getCategories() {

/*		String sql = "SELECT c.id, c.name "
				+ "FROM category c "				
				+ "LEFT JOIN project ON c.id = project.categoryId "
				+ "LEFT JOIN payment ON project.id = payment.projectId " 
				+ "GROUP BY c.id, c.name "
				+ "ORDER BY SUM(CASE WHEN payment.pledge IS NULL THEN 0 ELSE payment.pledge END) DESC limit 10";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Category>(Category.class));*/
		
		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(Category.class);
		
		return criteria.list();
	}

	@Override
	public Category getCategory(int id) {

		Session session = sessionFactory.getCurrentSession();
		
		return session.get(Category.class, id);
	}

	@Override
	public Category getBestCategory() {
/*		
		String sql = "SELECT c.id, c.name FROM category c "
				+ "WHERE c.id = ("
				+ "SELECT p.categoryId FROM project p "
				+ "JOIN payment ON p.id = payment.projectId "
				+ "GROUP BY p.categoryId, p.id, p.name "
				+ "HAVING SUM(payment.pledge) = ( SELECT MAX(t.pledge) "
				+ "FROM (SELECT projectId, SUM(pledge) pledge FROM payment GROUP BY projectId) t))";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Category>(Category.class));
		*/
		
		Session session = sessionFactory.getCurrentSession();
		
		return session.get(Category.class, 1);
		
	}

}
