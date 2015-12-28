package ua.com.goit.gojava7.kickstarter.dao;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.hibernate.HibernateUtil;
import ua.com.goit.gojava7.kickstarter.models.Category;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CategoryDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final Logger log = LoggerFactory.getLogger(CategoryDao.class);

	public CategoryDao() {
		log.info("Constructor CategoryDao()...");
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public Category get(Long categoryId) {
		log.info("<Category> get({})...", categoryId);		
		Session session = HibernateUtil.getSessionFactory().openSession();

		Category category = (Category) session.createCriteria(Category.class)
				.add(Restrictions.eq("categoryId", categoryId))
				.uniqueResult();

		session.close();
		log.debug("<Category> get({}) returned category: {}", categoryId, category);
		return category;		
	}
	
	@SuppressWarnings("unchecked")
	public List<Category> getAll() {
		log.info("<categories> getAll()...");			
		Session session = HibernateUtil.getSessionFactory().openSession();

		List<Category> categories = session.createCriteria(Category.class)
				.add(Restrictions.naturalId())
				.list();	
		
		session.close();
		log.debug("<categories> getAll() returned categories: {}", categories);
		return categories;		
	}	
	
	public List<Category> getTop10() {
		log.info("<Category> getTop10()...");
		String query = "select category.id, category.name, sum(payment.amount) as cnt from category join project on category.id = project.category_id join payment on project.id = payment.project_id group by category_id having sum(payment.amount) > 5 order by cnt desc limit 10";
		return jdbcTemplate.query(query, new CategoryWithMoneyMapper());
	}
	
	public Category getCategoryWithTopProject() {
		log.info("<Category> getCategoryWithTopProject()...");
		String query = "select category.id, category.name from category join project on category.id = project.category_id join payment on project.id = payment.project_id group by payment.project_id order by sum(payment.amount) desc limit 1";
		return jdbcTemplate.queryForObject(query, new CategoryMapper());
	}	

	private class CategoryMapper implements RowMapper<Category> {
		public Category mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			log.info("CategoryMapper()...");
			Category category = new Category();
			category.setCategoryId((long) resultSet.getInt("id"));
			category.setName(resultSet.getString("name"));
			log.debug("CategoryMapper() returned category: {}", category);
			return category;
		}
	}
	
	private final class CategoryWithMoneyMapper extends CategoryMapper {
		public Category mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			log.info("CategoryWithMoneyMapper()...");			 
			Category category = super.mapRow(resultSet, rowNum);	
			category.setMoney(resultSet.getInt("cnt"));
			log.debug("CategoryWithMoneyMapper() returned category: {}", category);
			return category;
		}
	}
}
