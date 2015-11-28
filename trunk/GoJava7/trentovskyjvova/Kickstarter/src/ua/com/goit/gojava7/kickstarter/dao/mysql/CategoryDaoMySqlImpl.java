package ua.com.goit.gojava7.kickstarter.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.exception.IODatabaseException;

public class CategoryDaoMySqlImpl implements CategoryDao {
	private Connection connection;

	public CategoryDaoMySqlImpl(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public List<Category> getCategories() {
		List<Category> categories = new ArrayList<>();
		
		try (PreparedStatement ps = connection
				.prepareStatement("SELECT id, name FROM category");
				ResultSet rs = ps.executeQuery()) {
			
			Category category;
			while (rs.next()) {			
				int id = rs.getInt("id");
				String name = rs.getString("name");
				category = new Category();
				category.setId(id);
				category.setName(name);
				categories.add(category);
			}
		} catch (SQLException e) {
		
			throw new IODatabaseException("Problem with database", e);
		}
		return categories;
	}

	@Override
	public Category getCategory(int id) {
		Category category = null;
		
		try (PreparedStatement ps = connection
				.prepareStatement("SELECT name FROM category WHERE id = " + id);
				ResultSet rs = ps.executeQuery()) {
			
			
			while (rs.next()) {			
				
				String name = rs.getString("name");
				category = new Category();
				category.setId(id);
				category.setName(name);
				
			}
		} catch (SQLException e) {
		
			throw new IODatabaseException("Problem with database", e);
		}
		return category;
	}

	@Override
	public int size() {
		int size = 0;
		try (PreparedStatement ps = connection
				.prepareStatement("SELECT COUNT(*) size FROM category");
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				
				size = rs.getInt("size");
				
			}
		} catch (SQLException e) {
		
			throw new IODatabaseException("Problem with database", e);
		}
		
		return size;
	}

}
