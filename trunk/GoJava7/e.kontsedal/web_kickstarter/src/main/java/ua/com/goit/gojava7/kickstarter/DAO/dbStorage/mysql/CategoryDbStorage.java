package ua.com.goit.gojava7.kickstarter.DAO.dbStorage.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.DAO.AbstractCategoryStorage;
import ua.com.goit.gojava7.kickstarter.DAO.dbStorage.util.JdbcDispatcher;
import ua.com.goit.gojava7.kickstarter.model.Category;

public class CategoryDbStorage extends AbstractCategoryStorage {

	private final String INSERT_CATEGORY = "INSERT INTO categories (name) VALUES (?)";
	private final String SELECT_ALL_CATEGORIES = "SELECT id, name FROM categories";
	private final String SELECT_CATEGORY = "SELECT id, name FROM categories WHERE id = ";

	private JdbcDispatcher dispatcher;

	public CategoryDbStorage(JdbcDispatcher dispatcher) {
		this.dispatcher = dispatcher;
	}

	@Override
	public List<Category> getAll() {
		List<Category> categories = new ArrayList<>();
		try (Connection connection = dispatcher.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(SELECT_ALL_CATEGORIES);) {

			while (resultSet.next()) {
				Category category = new Category();
				category.setIdCategory(resultSet.getInt("id"));
				category.setCategoryName(resultSet.getString("name"));
				categories.add(category);
			}
		} catch (SQLException e) {
			System.err.println("DB reading problem");
		}
		return categories;
	}

	@Override
	public void add(Category category) {
		try (Connection connection = dispatcher.getConnection();
				PreparedStatement statement = connection.prepareStatement(INSERT_CATEGORY);) {
			statement.setString(1, category.getCategoryName());
			statement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			System.err.println("DB writing problem");
		}
	}

	@Override
	public int getIdOfCategory(int numberOfCategory) {
		return getAll().get(numberOfCategory).getIdCategory();
	}

	@Override
	public Category getCategoryById(int idOfCategory) {
		Category category = null;
		try (Connection connection = dispatcher.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(SELECT_CATEGORY + idOfCategory);) {
			category = new Category();
			while (resultSet.next()) {
				category.setIdCategory(idOfCategory);
				category.setCategoryName(resultSet.getString("name"));
			}
		} catch (SQLException e) {
			System.err.println("DB reading problem");
		}
		return category;
	}

}
