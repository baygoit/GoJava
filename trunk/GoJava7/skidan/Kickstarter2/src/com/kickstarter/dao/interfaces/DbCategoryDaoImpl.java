package com.kickstarter.dao.interfaces;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kickstarter.model.Category;

public class DbCategoryDaoImpl extends DbConnector implements CategoryDaoInterface {

	public List<Category> getAll() {
		ResultSet rs = null;
		Statement statement = null;
		List<Category> list = new ArrayList<>();

		try (Connection conection = getConnection()) {
			statement = conection.createStatement();
			rs = statement.executeQuery("select * from categories");

			while (rs.next()) {
				Category category = new Category();
				category.setId(rs.getInt("id"));
				category.setTitle(rs.getString("title"));
				list.add(category);
			}

		} catch (SQLException e) {
			System.out.println("Category getAll MySql connection problem");
		}
		return list;

	}

	public Category getByNumber(int categoryNumber) {
		ResultSet rs = null;
		Statement statement = null;
		Category category = new Category();

		try (Connection conection = getConnection()) {
			statement = conection.createStatement();
			rs = statement.executeQuery("select id, title from categories where id = " + "'" + categoryNumber + "'");
			while (rs.next()) {
				category.setId(rs.getInt("id"));
				category.setTitle(rs.getString("title"));
			}

		} catch (SQLException e) {
			System.out.println("Category getCategorieByNumber MySql connection problem");

		}
		return category;
	}

}
