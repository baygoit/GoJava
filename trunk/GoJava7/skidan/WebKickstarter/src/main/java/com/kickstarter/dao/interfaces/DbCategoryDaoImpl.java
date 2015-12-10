package com.kickstarter.dao.interfaces;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kickstarter.model.Category;

public class DbCategoryDaoImpl implements CategoryDaoInterface {

	
	private DBCon dbCon;

	public DBCon getDbCon() {
		return dbCon;
	}
	@Autowired
	public void setDbCon(DBCon dbCon) {
		this.dbCon = dbCon;
	}

	public List<Category> getAll() {

		ResultSet rs = null;
		List<Category> list = new ArrayList<>();

		try (PreparedStatement pStatement = dbCon.getConnection().prepareStatement("select * from categories")) {
			rs = pStatement.executeQuery();
			while (rs.next()) {
				Category category = new Category();
				category.setId(rs.getInt("categoryId"));
				category.setTitle(rs.getString("categoryTitle"));
				list.add(category);
			}
		} catch (SQLException e) {
			System.out.println("Category getAll MySql connection problem");
		}
		return list;
	}

	public Category getByNumber(int categoryNumber) {
		ResultSet rs = null;
		Category category = new Category();

		try (PreparedStatement pStatement = dbCon.getConnection()
				.prepareStatement("select * from categories where categoryId = ?")) {
			pStatement.setInt(1, categoryNumber);
			rs = pStatement.executeQuery();
			while (rs.next()) {
				category.setId(rs.getInt("categoryId"));
				category.setTitle(rs.getString("categoryTitle"));
			}
		} catch (SQLException e) {
			System.out.println("Category getCategorieByNumber MySql connection problem");
		}
		return category;
	}
}
