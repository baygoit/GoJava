package com.anmertrix.dao.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.anmertrix.dao.CategoryDao;
import com.anmertrix.dao.DaoException;
import com.anmertrix.domain.Category;

@Repository
public class CategoryDaoSql implements CategoryDao {

	private static final String SELECT_CATEGORIES = "SELECT id, name FROM category";
	private static final String SELECT_CATEGORY_BY_ID = "SELECT name FROM category WHERE id=?";

	@Autowired
	private DataSource dataSource;

	@Override
	public Category getCategory(int category_id) {

		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(SELECT_CATEGORY_BY_ID)) {
			statement.setInt(1, category_id);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				String name = rs.getString("name");
				Category category = new Category();
				category.setId(category_id);
				category.setName(name);
				return category;
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		}

	}

	@Override
	public List<Category> getCategories() {
		List<Category> categories = new ArrayList<>();

		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(SELECT_CATEGORIES)) {
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				Category category = new Category();
				category.setName(name);
				category.setId(id);
				categories.add(category);
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		}

		return categories;
	}

}
