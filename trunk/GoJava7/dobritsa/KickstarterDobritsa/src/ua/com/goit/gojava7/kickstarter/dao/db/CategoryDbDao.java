package ua.com.goit.gojava7.kickstarter.dao.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.domain.Category;

public class CategoryDbDao implements CategoryStorage 
{

	private Connection connection;

	public CategoryDbDao(Connection connection) {
		this.connection = connection;
	}

	@Override
	public Category get(int index) {
		Category category = null;
		String query = "select id, name from category where id = " + index;

		try (PreparedStatement ps = connection.prepareStatement(query); 
				ResultSet resultSet = ps.executeQuery()) {
			if (resultSet.next()) {
				category = new Category(resultSet.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return category;
	}

	@Override
	public List<Category> getAll() {
		List<Category> categories = new ArrayList<>();
		String query = "select name from category";
		try (PreparedStatement ps = connection.prepareStatement(query);
				ResultSet resultSet = ps.executeQuery()) {
			while (resultSet.next()) {
				Category category = new Category(resultSet.getString("name"));
				categories.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categories;
	}

	@Override
	public int size() {
		int size = 0;
		String query = "select count(*) from category";
		try (PreparedStatement ps = connection.prepareStatement(query);
				ResultSet resultSet = ps.executeQuery()) {
			if (resultSet.next()) {
				size = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return size;
	}
}
