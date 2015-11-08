package ua.com.goit.gojava2.vova.kickstarter.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoriesDAO implements Categories{
	private Connection connection;
	public CategoriesDAO(Connection connection){
		this.connection = connection;
	}
	
	@Override
	public List<Category> getCategories() {
		List<Category> categories = new ArrayList<Category>();
		ResultSet result;
		try {
			Statement statement = connection.createStatement();
			result = statement.executeQuery("SELECT * FROM categories ORDER BY id_category");
			while (result.next()) {
			    categories.add(new Category(result.getInt("id_category"), result.getString("name_category")));
			}
		} catch (SQLException e) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
		}
		return categories;
	}

	@Override
	public String showCatecoryName(int categoryId) {
		Category category = getCategories().get(categoryId - 1);
		String name = category.getCategoryName();
		return name;
	}
}