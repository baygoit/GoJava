package ua.com.goit.gojava.kickstarter.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import ua.com.goit.gojava.kickstarter.data.Category;
import ua.com.goit.gojava.kickstarter.data.CategoryCatalog;

public class CategoriesDao implements CategoryCatalog {
	private Connection c;

	public CategoriesDao(Connection c) {
		this.c = c;
	}

	@Override
	public int size() {
		try (Statement stmt = this.c.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM category;");

			return rs.getInt(1);

		} catch (SQLException e) {
			throw new RuntimeException("statement does not executed", e);

		}
	}

	@Override
	public void addCategory(String name) {
		try (Statement stmt = c.createStatement()) {
			String sql = "INSERT INTO category (name) " + "VALUES ('" + name
					+ "');";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			throw new RuntimeException("statement does not executed", e);
		}

	}

	@Override
	public List<Category> getCatalog() {
		List<Category> list = new LinkedList<>();

		try (Statement stmt = c.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT * FROM category;");
			while (rs.next()) {
				list.add(new Category(rs.getInt("id"), rs.getString("name")));
			}
			return list;
		} catch (SQLException e) {
			throw new RuntimeException("operation not complite", e);
		}
	}

	@Override
	public Category getCategory(int i) {
		try (Statement stmt = c.createStatement()) {

			ResultSet rs = stmt
					.executeQuery("select * from category where id = " + i);
			while (rs.next()) {
				return new Category(rs.getInt("id"), rs.getString("name"));
			}

			throw new RuntimeException("no category id = " + i);
		} catch (SQLException e) {
			throw new RuntimeException("operation not complite", e);
		}
	}

}
