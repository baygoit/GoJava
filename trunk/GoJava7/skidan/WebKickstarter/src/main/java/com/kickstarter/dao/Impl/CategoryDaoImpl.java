package com.kickstarter.dao.Impl;


import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kickstarter.dao.interfaces.CategoryDao;
import com.kickstarter.model.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao {
	
	@Autowired(required=false)
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Transactional (readOnly = true)
	public List<Category> getAll() {
		Session session = sessionFactory.openSession();
		List<Category> categoryList = session.createQuery("from Category c").list();
		if (categoryList.isEmpty()) {
			return null;
		}
		session.close();
		return categoryList;
	}
	@Transactional (readOnly = true)
	public Category getByNumber(int categoryNumber) {
		Session session = sessionFactory.openSession();
		Category category = session.get(Category.class, categoryNumber);
		session.close();
		return category;
	}

}






















/*
@Autowired
private JdbcTemplate jdbcTemplate;

public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	this.jdbcTemplate = jdbcTemplate;
}
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