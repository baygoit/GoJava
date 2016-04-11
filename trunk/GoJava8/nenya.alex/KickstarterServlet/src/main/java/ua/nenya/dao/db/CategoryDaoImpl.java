package ua.nenya.dao.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.nenya.dao.CategoryDao;
import ua.nenya.domain.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao {

	private static final String GET_ALL_CATEGORIES = "SELECT category_name, id FROM categories ORDER BY category_name";

	@Autowired
	private DataSource dataSource;

	@Override
	public List<Category> getCategories() {
		List<Category> categories = new ArrayList<Category>();
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(GET_ALL_CATEGORIES)) {
			ResultSet set = statement.executeQuery();
			while (set.next()) {
				Category category = new Category();
				category.setName(set.getString("category_name"));
				category.setId(set.getInt("id"));
				categories.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categories;
	}

}
