package ua.com.sas.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import ua.com.sas.model.Categories;
import ua.com.sas.model.Category;

public class CategoriesDAO extends AbstractDAO implements Categories {

	public CategoriesDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void add(Category category) {
		try (Connection connection = getConnection()) {
			Statement statement = connection.createStatement();
			statement.execute("INSERT INTO categories (name) VALUES (\'" + category.getName() + "\')");
			ResultSet rs = statement.executeQuery("SELECT * FROM categories WHERE name = \'" + category.getName() + "\'");
			while (rs.next()){
				category.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			throw new RuntimeException("Connection Failed! Check output console", e);
		}
	}

	@Override
	public List<Category> getCategories() {
		try (Connection connection = getConnection()) {
			List<Category> categories = new ArrayList<Category>();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM categories");
			while (rs.next()){
				categories.add(new Category(rs.getInt(1), rs.getString(2)));
			}
			return categories;
		} catch (SQLException e) {
			throw new RuntimeException("Connection Failed! Check output console", e);
		}
	}
	
	@Override
	public Category get(int id) {
		try (Connection connection = getConnection()) {
			Category category = null;
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM categories WHERE id = " + id);
			while (rs.next()) {
				category = new Category(rs.getInt(1), rs.getString(2));
			}
			return category;
		} catch (SQLException e) {
			throw new RuntimeException("Connection Failed! Check output console", e);
		}
	}

	@Override
	public int size() {
		try (Connection connection = getConnection()) {
			int size = 0;
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select count(*) from categories");
			while (rs.next()) {
				size = rs.getInt(1);
			}
			return size;
		} catch (SQLException e) {
			throw new RuntimeException(
					"Connection Failed! Check output console", e);
		}
	}

}
