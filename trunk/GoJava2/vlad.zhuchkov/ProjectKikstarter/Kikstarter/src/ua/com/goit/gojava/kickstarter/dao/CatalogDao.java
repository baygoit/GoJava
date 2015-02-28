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
		Statement stmt = null;
		try {
			stmt = this.c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM category;");
			while (rs.next()) {
				size = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
			throw new RuntimeException("operation not complite");
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	@Override
	public List<String> getCatalog() {
		List<String> list = new LinkedList<>();
		Statement stmt = null;
		try {
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT name FROM category;");
			while (rs.next()) {
				list.add(rs.getString("name"));
			}
		} catch (SQLException e) {
			throw new RuntimeException("operation not complite");
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public Category getCategory(int i) {
		if (i > size)
			throw new IlligalInputException();
		return new CategoryDao(c, i);
	}

	@Override
	public int size() {
		return size;
	}

}
