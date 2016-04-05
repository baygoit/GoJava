package com.anmertrix.dao.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.anmertrix.ConnectionManager;
import com.anmertrix.dao.CategoryDao;
import com.anmertrix.dao.DaoException;
import com.anmertrix.dao.NoResultException;
import com.anmertrix.domain.Category;

public class CategoryDaoSql implements CategoryDao {

	private static final String SELECT_CATEGORIES = "SELECT id, name FROM category";

	private static final String SELECT_CATEGORY_BY_ID = "SELECT name FROM category WHERE id=?";

	private ConnectionManager connectionManager;

	public CategoryDaoSql(ConnectionManager connectionManager) {
		this.connectionManager = connectionManager;
	}

	@Override
	public Category getCategory(int id) {
		try (PreparedStatement statement = connectionManager.getConnection().prepareStatement(SELECT_CATEGORY_BY_ID)) {
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				String name = rs.getString("name");

				Category category = new Category();
				category.setId(id);
				category.setName(name);
				return category;
			} else {
				throw new NoResultException("No category found");
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		}

	}

	@Override
	public List<Category> getCategories() {
		List<Category> categories = new ArrayList<>();

		try (PreparedStatement statement = connectionManager.getConnection().prepareStatement(SELECT_CATEGORIES)) {
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
