package com.kickstarter.dao.Impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
//import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kickstarter.dao.Interfaces.CategoryDao;
import com.kickstarter.model.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional(readOnly = true)
	public List<Category> getAll() {

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Category> criteriaQuery = criteriaBuilder.createQuery(Category.class);
		Root<Category> categoryRoot = criteriaQuery.from(Category.class);
		criteriaQuery.select(categoryRoot);
		TypedQuery<Category> query = entityManager.createQuery(criteriaQuery);
		List<Category> categories = query.getResultList();

		return categories;
	}

	@Transactional(readOnly = true)
	public Category getByNumber(int categoryNumber) {
		return entityManager.find(Category.class, categoryNumber);
	}

}







/*
 * @Autowired private JdbcTemplate jdbcTemplate;
 * 
 * public void setJdbcTemplate(JdbcTemplate jdbcTemplate) { this.jdbcTemplate =
 * jdbcTemplate; }
 */
/*
 * public Category getByNumber(int categoryNumber) { String sql =
 * "select categoryId,categoryTitle from categories where categoryId = ?";
 * return jdbcTemplate.queryForObject(sql, new Object[] { categoryNumber }, new
 * CategoryMapper()); }
 * 
 * public final class CategoryMapper implements RowMapper<Category> { public
 * Category mapRow(ResultSet rs, int rowNum) throws SQLException { Category
 * category = new Category(); category.setId(rs.getInt("categoryId"));
 * category.setTitle(rs.getString("categoryTitle")); return category; }
 * 
 * }
 */

// public List<Category> getAll() {
// String sql = "select categoryId,categoryTitle from categories";
// return jdbcTemplate.query(sql, new CategoryMapper());
// }