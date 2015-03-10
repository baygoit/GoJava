package ua.com.goit.gojava.kickstarter.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import ua.com.goit.gojava.kickstarter.data.Category;
import ua.com.goit.gojava.kickstarter.data.CategoryCatalog;
import ua.com.goit.gojava.kickstarter.exceptions.IlligalInputException;

public class CatalogDao implements CategoryCatalog {
	private Connection c;
	private int size = 0;

	public CatalogDao(Connection c) {
		size = 0;
		this.c = c;
		Statement stmt;
		try {
			stmt = this.c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM category;");
			while (rs.next()) {
				size = rs.getInt(1);
			}
		} catch (SQLException e) {
			throw new RuntimeException("statement does not executed",e);
			
		}
	}

	@Override
	public void addCategory(String name) {
		Statement stmt = null;
		try {
			stmt = c.createStatement();
			String sql = "INSERT INTO category (name) " + "VALUES ('" + name
					+ "');";
			stmt.executeUpdate(sql);
			size++;
		} catch (SQLException e) {
			throw new RuntimeException("statement does not executed",e);
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				throw new RuntimeException("statement does not closed",e);
			}

		}

	}

	@Override
	public List<Category> getCatalog() {
		List<Category> list = new LinkedList<>();
		Statement stmt = null;
		try {
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM category;");
			while (rs.next()) {
				String name = rs.getString("name");
				int id = rs.getInt("id");
				list.add(new Category(id,name));
			}
		} catch (SQLException e) {
			throw new RuntimeException("operation not complite",e);
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				throw new RuntimeException("statement does not closed",e);
			}
		}
		return list;
	}

	@Override
	public CategoryDao getCategory(int i) {
		if (i > size||i<0)
			throw new IlligalInputException();
		return new CategoryDao(c, i);
	}

	@Override
	public int size() {
		return size;
	}

}
